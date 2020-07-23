package com.rajesh.graphql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.coxautodev.graphql.tools.SchemaParser;
import com.rajesh.graphql.resolver.Query;
import com.rajesh.graphql.resolver.TalkResolver;
import com.rajesh.graphql.service.AttendeeService;
import com.rajesh.graphql.service.SpeakerService;
import com.rajesh.graphql.service.TalkService;

import graphql.schema.GraphQLSchema;
import graphql.servlet.SimpleGraphQLHttpServlet;

@SpringBootApplication
public class SpringBootGraphqlApplication {

	@Autowired
	private AttendeeService attendeeService;

	@Autowired
	private SpeakerService speakerService;

	@Autowired
	private TalkService talkService;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootGraphqlApplication.class, args);
	}

	@Bean
	public ServletRegistrationBean graphQLServlet() {
		return new ServletRegistrationBean(
				SimpleGraphQLHttpServlet.newBuilder(buildSchema(attendeeService, speakerService, talkService)).build(),
				"/graphql");
	}

	private GraphQLSchema buildSchema(AttendeeService attendeeService, SpeakerService speakerService,
			TalkService talkService) {
		return SchemaParser.newParser()
				.file("graphql/schema.graphqls")
				.resolvers(
						new Query(talkService, speakerService, attendeeService),
						new TalkResolver(speakerService)
					)
				.build()
				.makeExecutableSchema();
	}

}
