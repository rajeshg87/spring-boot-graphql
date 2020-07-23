package com.rajesh.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.graphql.pojo.Speaker;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker, Long>{

}
