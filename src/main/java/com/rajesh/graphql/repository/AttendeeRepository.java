package com.rajesh.graphql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rajesh.graphql.pojo.Attendee;

@Repository
public interface AttendeeRepository extends JpaRepository<Attendee, Long> {
}
