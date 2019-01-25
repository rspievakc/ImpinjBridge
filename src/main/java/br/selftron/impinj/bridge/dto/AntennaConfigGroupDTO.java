package br.selftron.impinj.bridge.dto;

import java.util.ArrayList;
import java.util.List;

public class AntennaConfigGroupDTO {
	
	private List<AntennaConfigDTO> antennaConfigs = new ArrayList<>();
	private boolean antennaCollectionCreatedBySerializer;
	private double rxSensitivityInDbm;
	private double txPowerInDbm;
	private boolean isMaxRxSensitivy;
	private boolean isMaxTxPower;
	private boolean polarizationEnabled; 
	
	public AntennaConfigGroupDTO() {
	}

	public List<AntennaConfigDTO> getAntennaConfigs() {
		return antennaConfigs;
	}

	public void setAntennaConfigs(List<AntennaConfigDTO> antennaConfigs) {
		this.antennaConfigs = antennaConfigs;
	}

	public boolean isAntennaCollectionCreatedBySerializer() {
		return antennaCollectionCreatedBySerializer;
	}

	public void setAntennaCollectionCreatedBySerializer(boolean antennaCollectionCreatedBySerializer) {
		this.antennaCollectionCreatedBySerializer = antennaCollectionCreatedBySerializer;
	}

	public double getRxSensitivityInDbm() {
		return rxSensitivityInDbm;
	}

	public void setRxSensitivityInDbm(double rxSensitivityInDbm) {
		this.rxSensitivityInDbm = rxSensitivityInDbm;
	}

	public double getTxPowerInDbm() {
		return txPowerInDbm;
	}

	public void setTxPowerInDbm(double txPowerInDbm) {
		this.txPowerInDbm = txPowerInDbm;
	}

	public boolean isMaxRxSensitivy() {
		return isMaxRxSensitivy;
	}

	public void setMaxRxSensitivy(boolean isMaxRxSensitivy) {
		this.isMaxRxSensitivy = isMaxRxSensitivy;
	}

	public boolean isMaxTxPower() {
		return isMaxTxPower;
	}

	public void setMaxTxPower(boolean isMaxTxPower) {
		this.isMaxTxPower = isMaxTxPower;
	}

	public boolean isPolarizationEnabled() {
		return polarizationEnabled;
	}

	public void setPolarizationEnabled(boolean polarizationEnabled) {
		this.polarizationEnabled = polarizationEnabled;
	}

}
