package com.rajesh.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.graphql.pojo.SpeakerTalk;

@Repository
public interface SpeakerTalkRepository extends JpaRepository<SpeakerTalk, Long>{
	
	List<SpeakerTalk> findAllBySpeakerId(Long speakerId);
	
	List<SpeakerTalk> findAllByTalkId(Long talkId);

}
