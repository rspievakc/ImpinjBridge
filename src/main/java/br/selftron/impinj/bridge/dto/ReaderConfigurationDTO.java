package br.selftron.impinj.bridge.dto;

import com.impinj.octane.ReaderMode;

public class ReaderConfigurationDTO {
	
	private String address;
	private AntennaConfigGroupDTO antennaConfigurationGroup;
	private ReportConfigDTO reportConfig;
	private ReaderMode readerMode;
	
	public ReaderConfigurationDTO() {
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AntennaConfigGroupDTO getAntennaConfigurationGroup() {
		return antennaConfigurationGroup;
	}

	public void setAntennaConfigurationGroup(AntennaConfigGroupDTO antennaConfigurationGroup) {
		this.antennaConfigurationGroup = antennaConfigurationGroup;
	}

	public ReportConfigDTO getReportConfig() {
		return reportConfig;
	}

	public void setReportConfig(ReportConfigDTO reportConfig) {
		this.reportConfig = reportConfig;
	}

	public ReaderMode getReaderMode() {
		return readerMode;
	}

	public void setReaderMode(ReaderMode readerMode) {
		this.readerMode = readerMode;
	}

}
