package com.example.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.service.EventNotificationService;
import com.example.service.EventNotificationServiceImpl;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventNotificationServiceImplTest {

	EventNotificationService eventNotificationService ;
	
	Event myEvent;
	
	Attendee person1 = new Attendee(1L, "Manuel", "nn@mail.com");
	Attendee person2 = new Attendee(2L, "David", "david@gmail.com");
	Attendee person3 = new Attendee();

	@BeforeEach
	void setUp() throws Exception{
		eventNotificationService = new EventNotificationServiceImpl();
		myEvent = new Event(1L, "Evento Mock",EventType.BUSINESS, eventNotificationService);
	}

	@Test
	@DisplayName("Comprobamos si hay announce que sea null, y no lo añade")
	void testAnnounceeNull() {
		assertEquals(0,person1.getNotifications().size());
		eventNotificationService.announce(null);
		assertEquals(0,person1.getNotifications().size());
	}
	@Test
	@DisplayName("Comprobamos si hay un attendee null")
	void testSetAttendeesNull() {
		myEvent.setAttendees(null);
		eventNotificationService.announce(myEvent);
		assertEquals(0,person1.getNotifications().size());
	}
	@Test
	@DisplayName("Comprobamos si hay una lista")
	void testSetAttendeesList() {
		myEvent.setAttendees(new ArrayList<Attendee>());
		eventNotificationService.announce(myEvent);
		assertEquals(0,person1.getNotifications().size());
	}
    
	@Test
	@DisplayName("Comprobamos si al añadir un attendee no se pasa null")
	void testAddAttendeeNotNull() {
		myEvent.addAttendee(person1);
		eventNotificationService.announce(myEvent);
	}
		
	@Test
	@DisplayName("Comprobamos hay mas de un attende distinto, pasando el event, hay una notificacion")
	void testMultiAttendees(){
		myEvent.addAttendee(person1);
		
		myEvent.addAttendee(person3);
		eventNotificationService.announce(myEvent);
		assertEquals(1,person1.getNotifications().size());
	}   
	
	@Test
	@DisplayName("Comprobamos si event es null y attendee se pasa null")
	void testAttendeeAndEventNull() throws Exception{
		myEvent = null;
		Attendee attendee = null;
		eventNotificationService.confirmAttendance(myEvent, attendee);
		assertEquals(null, myEvent);
		assertEquals(null, attendee);
	}
	
	@Test
	@DisplayName("Comprobamos si event no es null y attendee se pasa null")
	void testConfirmAttendeeNullEventNotNull() throws Exception{
		Attendee attendee = null;
		eventNotificationService.confirmAttendance(myEvent, attendee);
		assertEquals(null, attendee);
		assertNotNull(myEvent);
	}
	
	
	@Test
	@DisplayName("Comprobamos si event no es  null y attendee no se pasa null")
	void testConfirmAttendeeAndEventNotNull() throws Exception{
		Attendee attendee = new Attendee();
		eventNotificationService.confirmAttendance(myEvent, attendee);
		assertEquals(1, attendee.getNotifications().size());
	}
	
	@Test
	@DisplayName("Comprobamos si event es null y attendee no se pasa null")
	void testConfirmAttendeeNotNullAndEvenNull() throws Exception{
		Attendee attendee = new Attendee();
		eventNotificationService.confirmAttendance(null, attendee);
		assertEquals(0, attendee.getNotifications().size());
	}
	
}
