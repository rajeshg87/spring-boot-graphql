package com.rajesh.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rajesh.graphql.pojo.Attendee;
import com.rajesh.graphql.pojo.AttendeeTalk;
import com.rajesh.graphql.pojo.Speaker;
import com.rajesh.graphql.pojo.SpeakerTalk;
import com.rajesh.graphql.pojo.Talk;
import com.rajesh.graphql.repository.AttendeeTalkRepository;
import com.rajesh.graphql.repository.SpeakerTalkRepository;
import com.rajesh.graphql.repository.TalkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TalkService {
	
	private final TalkRepository talkRepository;
	
	@Autowired
    private SpeakerTalkRepository speakerTalkRepository;

    @Autowired
    private AttendeeTalkRepository attendeeTalkRepository;
	
	public List<Talk> findAll(){
		return talkRepository.findAll();
	}
	
	public List<Talk> findAllTalksBySpeaker(Speaker speaker) {
        List<SpeakerTalk> st = speakerTalkRepository.findAllBySpeakerId(speaker.getId());

        return st.stream()
                .map(e -> talkRepository.findOne(e.getTalkId()))
                .collect(Collectors.toList());
    }

    public List<Talk> findAllTAlksByAttendee(Attendee attendee) {
        List<AttendeeTalk> st = attendeeTalkRepository.findAllByAttendeeId(attendee.getId());

        return st.stream()
                .map(e -> talkRepository.findOne(e.getTalkId()))
                .collect(Collectors.toList());

    }
}
