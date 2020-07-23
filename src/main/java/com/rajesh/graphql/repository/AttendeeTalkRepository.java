package com.rajesh.graphql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.graphql.pojo.AttendeeTalk;

@Repository
public interface AttendeeTalkRepository extends JpaRepository<AttendeeTalk, Long>{
	
	List<AttendeeTalk> findAllByAttendeeId(Long attendeeId);
	
	List<AttendeeTalk> findAllByTalkId(Long talkId);
	
}
