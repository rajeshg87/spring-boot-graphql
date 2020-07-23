package com.rajesh.graphql.resolver;

import java.util.List;

import com.coxautodev.graphql.tools.GraphQLResolver;
import com.rajesh.graphql.pojo.Speaker;
import com.rajesh.graphql.pojo.Talk;
import com.rajesh.graphql.service.SpeakerService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TalkResolver implements GraphQLResolver<Talk>{
	
	private final SpeakerService speakerService;
	
	public List<Speaker> speakers(Talk talk){
		return speakerService.findAllSpeakersForTalk(talk);
	}
	
}
