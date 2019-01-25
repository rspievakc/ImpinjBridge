package br.selftron.impinj.bridge.dto;

import java.util.ArrayList;
import java.util.List;

import com.impinj.octane.TagData;

public class TagDataDto {

	private List<Integer> data = new ArrayList<>();

	public TagDataDto() {
		data = new ArrayList<>();
	}

	public TagDataDto(TagData tagData) {
		if (tagData != null) {
			data = new ArrayList<>(tagData.toWordList());
		} else {
			data = new ArrayList<>();
		}
	}

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

}
