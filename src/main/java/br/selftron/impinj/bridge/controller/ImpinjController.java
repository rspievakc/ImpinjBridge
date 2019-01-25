package br.selftron.impinj.bridge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.task.TaskExecutor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.impinj.octane.AntennaConfigGroup;
import com.impinj.octane.ImpinjReader;
import com.impinj.octane.OctaneSdkException;
import com.impinj.octane.ReaderMode;
import com.impinj.octane.ReportConfig;
import com.impinj.octane.ReportMode;
import com.impinj.octane.Settings;

import br.selftron.impinj.bridge.dto.TagsReadResultDTO;

@Controller
@Service
public class ImpinjController implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
    private SimpMessagingTemplate template;
	
	@Autowired
	@Qualifier("impinjTaskExecutor")
	private TaskExecutor taskExecutor;
	
	private boolean running = true;
	
	public ImpinjController() {
		System.out.println("Impinj instance created.");
	}
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		taskExecutor.execute(new Runnable() {
			@Override
			public void run() {
				ImpinjReader reader = new ImpinjReader();
				
				try {
				
		            reader.connect("169.254.1.1");

		            Settings settings = reader.queryDefaultSettings();

		            ReportConfig report = settings.getReport();
		            report.setIncludeAntennaPortNumber(true);
		            report.setMode(ReportMode.Individual);

		            // The reader can be set into various modes in which reader
		            // dynamics are optimized for specific regions and environments.
		            // The following mode, AutoSetDenseReader, monitors RF noise and interference and then automatically
		            // and continuously optimizes the reader's configuration
		            settings.setReaderMode(ReaderMode.AutoSetDenseReader);

		            // set some special settings for antenna 1
		            AntennaConfigGroup antennas = settings.getAntennas();
		            antennas.disableAll();
		            antennas.enableById(new short[]{1});
		            antennas.getAntenna((short) 1).setIsMaxRxSensitivity(false);
		            antennas.getAntenna((short) 1).setIsMaxTxPower(false);
		            antennas.getAntenna((short) 1).setTxPowerinDbm(20.0);
		            antennas.getAntenna((short) 1).setRxSensitivityinDbm(-70);

		            reader.setTagReportListener(new DefaultTagReportListener(template));

		            System.out.println("Applying Settings");
		            reader.applySettings(settings);

		            System.out.println("Starting");
		            reader.start();
					
					while(running) {
						System.out.println("teste");
						sendTags();
						Thread.sleep(10000);
					}
					
					reader.stop();
		            reader.disconnect();
		            
		            System.out.println("Reader exited");
		            
				}
				catch(OctaneSdkException ex) {
					ex.printStackTrace();
				}
				catch(InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		});
	}
	
	@Async("impinjTaskExecutor")
	public void sendTags() {
		template.convertAndSend("/impinj/tags", new TagsReadResultDTO());
		System.out.println("Simple message generated.");
	}
	
	@MessageMapping("/startReading")
	@SendTo("/impinj/tags")
    public TagsReadResultDTO startRead(@Payload String message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		template.convertAndSend("/impinj/tags", new TagsReadResultDTO());
        return new TagsReadResultDTO();
    }
	
	@MessageMapping("/stopReading")
	@SendTo("/impinj/tags")
    public TagsReadResultDTO stoptRead(@Payload String message, SimpMessageHeaderAccessor headerAccessor) throws Exception {
		template.convertAndSend("/impinj/tags", new TagsReadResultDTO());
        return new TagsReadResultDTO();
    }

}
