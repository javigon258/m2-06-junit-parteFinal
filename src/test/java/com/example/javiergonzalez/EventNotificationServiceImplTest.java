package com.example.javiergonzalez;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Event;
import com.example.EventType;
import com.example.Speaker;
import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;

class EventNotificationServiceImplTest {
	
	EventNotificationService sut;
	Event event1;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		sut = new EventNotificationServiceImpl();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testAnnounce() {
		EventType tipo = null;
		Speaker speaker = new Speaker();
		Event event = new Event(1L,"Titulo",tipo.BUSINESS,null);
		
		event.addSpeaker(speaker);
		sut.announce(event);
		
		assertNull(event);
	}

	@Test
	void testConfirmAttendance() {
		//fail("Not yet implemented");
	}

}
