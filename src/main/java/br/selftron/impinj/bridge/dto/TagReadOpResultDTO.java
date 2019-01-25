package br.selftron.impinj.bridge.dto;

import com.impinj.octane.ReadResultStatus;
import com.impinj.octane.TagReadOpResult;

public class TagReadOpResultDTO {
	
	private ReadResultStatus result;
	private TagDataDto data;
	
	public TagReadOpResultDTO() {
	}
	
	public TagReadOpResultDTO(TagReadOpResult tagReadOpResult) {
		this.result = tagReadOpResult.getResult();
		this.data = new TagDataDto(tagReadOpResult.getData());
	}

	public ReadResultStatus getResult() {
		return result;
	}

	public void setResult(ReadResultStatus result) {
		this.result = result;
	}

	public TagDataDto getData() {
		return data;
	}

	public void setData(TagDataDto data) {
		this.data = data;
	}

}
