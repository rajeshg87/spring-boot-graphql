package com.rajesh.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rajesh.graphql.pojo.Speaker;
import com.rajesh.graphql.pojo.SpeakerTalk;
import com.rajesh.graphql.pojo.Talk;
import com.rajesh.graphql.repository.SpeakerRepository;
import com.rajesh.graphql.repository.SpeakerTalkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SpeakerService {
	
	private final SpeakerRepository speakerRepository;
	
	private final SpeakerTalkRepository speakerTalkRepository;
	
	public List<Speaker> findAll(){
		return speakerRepository.findAll();
	}
	
	public List<Speaker> findAllSpeakersForTalk(Talk talk) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllByTalkId(talk.getId());

        return st.stream()
                .map(e -> speakerRepository.findOne(e.getSpeakerId()))
                .collect(Collectors.toList());
    }

}
