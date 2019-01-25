package br.selftron.impinj.bridge.dto;

public class AntennaConfigDTO {
	
	private double rxSensitivityInDbm;
	private double TxPowerDbm;
	private boolean isMaxRxSensitivity;
	private boolean isMaxTxPower;
	private boolean enabled;
	private short portNumber;
	private String portName;
	
	public AntennaConfigDTO() {
	}
	
	public AntennaConfigDTO(short newPortNumber) {
		this.portNumber = newPortNumber;
	}

	public double getRxSensitivityInDbm() {
		return rxSensitivityInDbm;
	}

	public void setRxSensitivityInDbm(double rxSensitivityInDbm) {
		this.rxSensitivityInDbm = rxSensitivityInDbm;
	}

	public double getTxPowerDbm() {
		return TxPowerDbm;
	}

	public void setTxPowerDbm(double txPowerDbm) {
		TxPowerDbm = txPowerDbm;
	}

	public boolean isMaxRxSensitivity() {
		return isMaxRxSensitivity;
	}

	public void setMaxRxSensitivity(boolean isMaxRxSensitivity) {
		this.isMaxRxSensitivity = isMaxRxSensitivity;
	}

	public boolean isMaxTxPower() {
		return isMaxTxPower;
	}

	public void setMaxTxPower(boolean isMaxTxPower) {
		this.isMaxTxPower = isMaxTxPower;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public short getPortNumber() {
		return portNumber;
	}

	public void setPortNumber(short portNumber) {
		this.portNumber = portNumber;
	}

	public String getPortName() {
		return portName;
	}

	public void setPortName(String portName) {
		this.portName = portName;
	}

}
