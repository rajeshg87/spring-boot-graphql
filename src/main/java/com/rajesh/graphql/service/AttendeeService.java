package com.rajesh.graphql.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rajesh.graphql.pojo.Attendee;
import com.rajesh.graphql.pojo.AttendeeTalk;
import com.rajesh.graphql.pojo.Talk;
import com.rajesh.graphql.repository.AttendeeRepository;
import com.rajesh.graphql.repository.AttendeeTalkRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AttendeeService {
	
	private final AttendeeRepository attendeeRepository;
	
	private final AttendeeTalkRepository attendeeTalkRepository;
	
	public List<Attendee> findAll() {
		return attendeeRepository.findAll();
	}
	
	public List<Attendee> findAllAttendiesForTalk(Talk talk){
		List<AttendeeTalk> at = attendeeTalkRepository.findAllByTalkId(talk.getId());

        return at.stream()
                .map(e -> attendeeRepository.findOne(e.getAttendeeId()))
                .collect(Collectors.toList());
	}

}
