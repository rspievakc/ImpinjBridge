package br.selftron.impinj.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.impinj.octane.AntennaConfigGroup;
import com.impinj.octane.ConnectionAttemptEvent;
import com.impinj.octane.ConnectionAttemptListener;
import com.impinj.octane.ConnectionCloseEvent;
import com.impinj.octane.ConnectionCloseListener;
import com.impinj.octane.ConnectionLostListener;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.ReportConfig;
import com.impinj.octane.Settings;

import br.selftron.impinj.bridge.dto.AntennaConfigDTO;
import br.selftron.impinj.bridge.dto.ReaderConfigurationDTO;
import br.selftron.impinj.bridge.dto.TagsReadResultDTO;

@Component
@Scope("prototype")
public class DefaultImpinjReaderRunnable implements ImpinjReaderRunnable {
	
	private ReaderConfigurationDTO configuration;
	
	@Autowired
    private SimpMessagingTemplate template;
	
	private boolean running = false; 
	
	public DefaultImpinjReaderRunnable(ReaderConfigurationDTO configuration) {
		this.configuration = configuration;
	}

	@Override
	public void run() {
		
		ImpinjReader reader = new ImpinjReader();
		
		try {
			
			// Wait time to clear the connection on the device
			Thread.sleep(2000);
			
            reader.connect(configuration.getAddress());

            Settings settings = reader.queryDefaultSettings();

            ReportConfig report = settings.getReport();
            report.setIncludeAntennaPortNumber(configuration.getReportConfig().isIncludeAntennaPortNumber());
            //ReportMode.Individual
            report.setMode(configuration.getReportConfig().getMode());

            // The reader can be set into various modes in which reader
            // dynamics are optimized for specific regions and environments.
            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
            // and continuously optimizes the reader's configuration
            //ReaderMode.AutoSetDenseReader
            settings.setReaderMode(configuration.getReaderMode());

            // set some special settings for antenna 1
            AntennaConfigGroup antennas = settings.getAntennas();
            antennas.disableAll();
            
            
            for (AntennaConfigDTO antenna : configuration.getAntennaConfigurationGroup().getAntennaConfigs()) {
            	short portNumber = antenna.getPortNumber();
            	antennas.enableById(new short[]{portNumber});
                antennas.getAntenna(portNumber).setIsMaxRxSensitivity(antenna.isMaxRxSensitivity());
                antennas.getAntenna(portNumber).setRxSensitivityinDbm(antenna.getRxSensitivityInDbm());
                antennas.getAntenna(portNumber).setIsMaxTxPower(antenna.isMaxTxPower());
                antennas.getAntenna(portNumber).setTxPowerinDbm(antenna.getTxPowerDbm());                
            }
            

            reader.setTagReportListener(new DefaultTagReportListener(template, configuration));
            reader.setConnectionCloseListener(new ConnectionCloseListener() {
				
				@Override
				public void onConnectionClose(ImpinjReader reader, ConnectionCloseEvent connectionCloseEvent) {
					System.out.println("Connection clonse on reader at: " + reader.getAddress() + " - " + connectionCloseEvent.toString());
					running = false;
				}
			});
            
            reader.setConnectionAttemptListener(new ConnectionAttemptListener() {
				
				@Override
				public void onConnectionAttempt(ImpinjReader reader, ConnectionAttemptEvent connectionAttemptEvent) {
					System.out.println("Connection attempt to reader at: " + reader.getAddress() + " - " + connectionAttemptEvent.toString());
				}
			});
            
            reader.setConnectionLostListener(new ConnectionLostListener() {
				
				@Override
				public void onConnectionLost(ImpinjReader reader) {
					System.out.println("Connection lost " + reader);
					running = false;
				}
			});

            reader.applySettings(settings);
            reader.start();
            
            running = true;
            
			while(running) {
				Thread.sleep(10000);
			}
			
			reader.stop();
            reader.disconnect();
            
		}
		catch(OctaneSdkException ex) {
			ex.printStackTrace();
		}
		catch(InterruptedException ex) {
			ex.printStackTrace();
		}
	}
	
	@Async("impinjTaskExecutor")
	public void sendTags(String address, TagsReadResultDTO results) {
		template.convertAndSend("/impinj/" + address, new TagsReadResultDTO());		
	}

}
