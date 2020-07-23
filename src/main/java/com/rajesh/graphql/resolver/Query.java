package com.rajesh.graphql.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.rajesh.graphql.pojo.Attendee;
import com.rajesh.graphql.pojo.Speaker;
import com.rajesh.graphql.pojo.Talk;
import com.rajesh.graphql.service.AttendeeService;
import com.rajesh.graphql.service.SpeakerService;
import com.rajesh.graphql.service.TalkService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Query implements GraphQLQueryResolver {
	
	private final TalkService talkService;
	
	private final SpeakerService speakerService;
	
	private final AttendeeService attendeeService;
	
	public List<Talk> allTalks() {
		return talkService.findAll();
	}
	
	public List<Attendee> allAttendees() {
		return attendeeService.findAll();
	}
	
	public List<Speaker> allSpeakers() {
		return speakerService.findAll();
	}

}
