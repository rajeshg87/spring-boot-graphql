package com.rajesh.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.graphql.pojo.Talk;

@Repository
public interface TalkRepository extends JpaRepository<Talk, Long>{

}
