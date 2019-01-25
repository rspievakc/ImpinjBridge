package br.selftron.impinj.bridge.dto;

import com.impinj.octane.ImpinjReader;

public class ReaderDTO {
	
	private String name;
	private String address;
	
	public ReaderDTO() {
	}
	
	public ReaderDTO(ImpinjReader reader) {
		if (reader != null) {
			name = reader.getName();
			address = reader.getAddress();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
