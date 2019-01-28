package br.selftron.impinj.bridge.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import com.impinj.octane.ImpinjReader;
import com.impinj.octane.Tag;
import com.impinj.octane.TagReport;
import com.impinj.octane.TagReportListener;

import br.selftron.impinj.bridge.dto.ReaderConfigurationDTO;
import br.selftron.impinj.bridge.dto.TagDTO;
import br.selftron.impinj.bridge.dto.TagsReadResultDTO;

public class DefaultTagReportListener implements TagReportListener {
	
	private SimpMessagingTemplate template;
	private ReaderConfigurationDTO configuration;
	
	public DefaultTagReportListener(SimpMessagingTemplate template, ReaderConfigurationDTO configuration) {
		this.template = template;
		this.configuration = configuration;
	}

    @Override
    public void onTagReported(ImpinjReader reader, TagReport report) {
        List<Tag> tags = report.getTags();
        List<TagDTO> resultTags = new ArrayList<>();

        for (Tag tag : tags) {
        	TagDTO entry = new TagDTO(reader, tag);
        	resultTags.add(entry);        	
        }
        
        TagsReadResultDTO result = new TagsReadResultDTO(resultTags);
        template.convertAndSend("/impinj/" + configuration.getAddress(), result);        
    }
}
