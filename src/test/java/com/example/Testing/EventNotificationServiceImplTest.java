package com.example.Testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

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

	EventNotificationService eventNotificationService = new EventNotificationServiceImpl();
	
	Event myEvent = new Event(1L, "Evento Mock",EventType.BUSINESS, eventNotificationService);
	
	Attendee person1 = new Attendee(1L, "Manuel", "nn@mail.com");
	Attendee person2 = new Attendee(2L, "David", "david@gmail.com");

	
	@Test
	@Order(2)
    void testAnnounceEventNull() {
		myEvent = null;
		assertNull(myEvent);

/*		Exception excep = assertThrows(NullPointerException.class,
				() -> myEvent.notifyAssistants()
				);
		
		String msg = "Cannot invoke \"com.example.Event.notifyAssistants()\" because \"this.myEvent\" is null";
		assertEquals(msg, excep.getMessage());
		System.out.println(excep.getMessage());
		
		eventNotificationService.announce(myEvent);
		assertNull(myEvent);*/
    }
	
	@Test
	@Order(4)
    void testAnnounceEventNullAttendee() {
		myEvent.setAttendees(null);
		assertNull(myEvent.getAttendees());
		
		myEvent.notifyAssistants();
		assertNull(myEvent.getAttendees());
    }
	
	@Test
	@Order(6)
    void testAnnounceAttendeeIsEmpty() {
		assertTrue(myEvent.getAttendees().isEmpty());
		
		myEvent.notifyAssistants();
		assertTrue(myEvent.getAttendees().isEmpty());
    }
	
	@Test
	@Order(8)
	void testForEachGetAttendees(){
		for(Attendee attendee : myEvent.getAttendees()) {
			
		}
	}
    
    @Test
    void testConfirmEventNull() {

    	myEvent = null;
		assertNull(myEvent);
    }
    
	
}
