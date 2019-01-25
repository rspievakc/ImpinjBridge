package br.selftron.impinj.bridge.dto;

import java.util.ArrayList;
import java.util.List;

public class TagsReadResultDTO {

	private List<TagDTO> tags;
	
	public TagsReadResultDTO() {
		tags = new ArrayList<>();
	}
	
	public TagsReadResultDTO(List<TagDTO> tags) {
		this.tags = tags;
	}
	
	public List<TagDTO> getTags() {
		return tags;
	}

	public void setTags(List<TagDTO> tags) {
		this.tags = tags;
	}

}
