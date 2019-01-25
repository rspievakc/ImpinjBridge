package br.selftron.impinj.bridge.dto;

import com.impinj.octane.TagModelDetails;
import com.impinj.octane.TagModelName;

public class TagModelDetailsDTO {
	
	private TagModelName modelName;
	private short userMemorySizeBits;
	private short epcSizeBits;
	private boolean supportsQt;
	
	public TagModelDetailsDTO() {
	}
	
	public TagModelDetailsDTO(TagModelDetails tagModelDetails) {
		this.modelName = tagModelDetails.getModelName();
		this.userMemorySizeBits = tagModelDetails.getUserMemorySizeBits();
		this.epcSizeBits = tagModelDetails.getEpcSizeBits();
		this.supportsQt = tagModelDetails.isSupportsQt();
	}

	public TagModelName getModelName() {
		return modelName;
	}

	public void setModelName(TagModelName modelName) {
		this.modelName = modelName;
	}

	public short getUserMemorySizeBits() {
		return userMemorySizeBits;
	}

	public void setUserMemorySizeBits(short userMemorySizeBits) {
		this.userMemorySizeBits = userMemorySizeBits;
	}

	public short getEpcSizeBits() {
		return epcSizeBits;
	}

	public void setEpcSizeBits(short epcSizeBits) {
		this.epcSizeBits = epcSizeBits;
	}

	public boolean isSupportsQt() {
		return supportsQt;
	}

	public void setSupportsQt(boolean supportsQt) {
		this.supportsQt = supportsQt;
	}

}
