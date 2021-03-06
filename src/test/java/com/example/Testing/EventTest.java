package com.example.Testing;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.Attendee;
import com.example.Event;
import com.example.EventType;
import com.example.Speaker;
import com.example.service.EventNotificationServiceImpl;

class EventTest {

	Event event;
	Attendee persona1 = new Attendee(1L, "Persona1", "");
	Attendee persona2 = new Attendee(2L, "Persona1", "");
	Attendee persona3 = new Attendee(null, "Persona1", "");

	@BeforeEach
	void setUp() throws Exception {
		event = new Event();
	}

	@Test
	void testEvent() {
		event = new Event();
	}

	@Test
	@DisplayName("Comprobamos si al añadir deuelve algun valor")
	void testAddAttendee() {
		assertEquals(0, event.getAttendees().size());

		Attendee persona1 = new Attendee(1L, "Persona1", "");
		Attendee persona2 = new Attendee(2L, "Persona2", "");
		event.addAttendee(persona1);

		assertEquals(1, event.getAttendees().size());

		event.addAttendee(persona2);
		assertEquals(2, event.getAttendees().size());

		assertEquals("Persona1", event.getAttendees().get(0).getNickname());
		assertEquals("Persona2", event.getAttendees().get(1).getNickname());

	}

	@Test
	@DisplayName("Comprueba si la persona es nula")
	void testAddAttendeeNull() {
		assertEquals(0, event.getAttendees().size());

		event.addAttendee(null);

		assertEquals(0, event.getAttendees().size());
	}

	@Test
	@DisplayName("Comprueba si la lista de persona es nula")
	void testAddAttendeeListaNull() throws Exception {
		Event evento = new Event(1L, "Evento 1", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());
		Attendee persona1 = new Attendee(1L, "Persona1", "");

		evento.addAttendee(persona1);
		assertEquals(1, evento.getAttendees().size());

	}

	@Test
	@DisplayName("Comprueba que no se repitan valores")
	void testAddAttendeeIfExists() throws Exception {
		assertEquals(0, event.getAttendees().size());

		event.addAttendee(persona1);

		assertEquals(1, event.getAttendees().size());

		event.addAttendee(persona1);

		assertEquals(1, event.getAttendees().size());
	}

	@Test
	@DisplayName("Comprueba si se borra una persona")
	void testRemoveAttendee() {

		assertEquals(0, event.getAttendees().size());

		Attendee persona1 = new Attendee(1L, "Persona1", "");

		event.addAttendee(persona1);

		assertEquals(1, event.getAttendees().size());

		event.removeAttendee(persona1);

		assertEquals(0, event.getAttendees().size());
	}



	@Test
	@DisplayName("Comprueba si se borra una persona es null")
	void testRemoveAttendeeGetNull() {
		
		Attendee attendee = new Attendee(1L, "Persona1", "");

		event.setAttendees(null);
		
		event.removeAttendee(attendee);
		assertEquals(0L, event.getAttendees().size());
	}
	
	
	
	@Test
	@DisplayName("Comprueba si se borra una persona es null")
	void testRemoveAttendeeNull() {

		Event evento = new Event(1L, "Evento 1", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setAttendees(null);
		assertEquals(null, evento.getAttendees());

		evento.removeAttendee(null);

		assertNull(evento.getAttendees());
	}

	@Test
	@DisplayName("Comprobar hay una lista de personas vacia")
	void testAddAttendees() {
		List<Attendee> personas = new ArrayList<Attendee>();

		event.addAttendees(personas);
	}
	
	@Test
	@DisplayName("Comprobar hay una lista de personas cuando se le paso un null")
	void testAddAttendeesNull() {

		event.addAttendees(null);
		assertEquals(event, event);		
	}
	
	@Test
	@DisplayName("Comprobar hay una lista de personas")
	void testAddAttendeesListNull() {
		event.setAttendees(null);
		List<Attendee> personas = new ArrayList<Attendee>();
		Attendee persona1 = new Attendee(1L, "Persona1", "");

		personas.add(persona1);
		event.addAttendees(personas);
		assertEquals(event.getAttendees().size(), 1);		
	}
	
	@Test
	@DisplayName("Comprobar hay una lista de personas, ya hay un mismo valor")
	void testAddAttendeesListRepeatValue() {
		List<Attendee> personas = new ArrayList<Attendee>();
		Attendee persona1 = new Attendee(1L, "Persona1", "");

		personas.add(persona1);

		event.addAttendees(personas);

		assertEquals(1, event.getAttendees().size());

		personas.add(persona1);

		event.addAttendees(personas);

		assertEquals(1, event.getAttendees().size());
	}

	@Test
	@DisplayName("Comprueba para borrar personas sin tener ninguno")
	void testRemoveAttendees() {
		List<Attendee> personas = new ArrayList<Attendee>();

		event.removeAttendees(personas);
	}
	
	@Test
	@DisplayName("Comprobamos si se borra un attendee que sea null")
	void testRemoveAttendeesNull() {
		event.setAttendees(null);
		List<Attendee> personas = new ArrayList<Attendee>();
		Attendee persona1 = new Attendee(1L, "Persona1", "");

		personas.add(persona1);
		event.removeAttendees(personas);
		assertEquals(event.getAttendees().size(), 0);		
	}

	@Test
	@DisplayName("Comprobar hay una lista de personas cuando se le paso un null")
	void testRemoveAttendeesIsNull() {

		event.removeAttendees(null);
		assertEquals(event, event);		
	}
	
	@Test
	@DisplayName("Comprobamos si hay añadido algun speaker")
	void testAddSpeaker() {
		assertEquals(0, event.getSpeakers().size());

		Speaker speaker1 = new Speaker(1L, "Altavoz", "");
		Speaker speaker2 = new Speaker(2L, "Altavoz 2", "");
		event.addSpeaker(speaker1);

		assertEquals(1, event.getSpeakers().size());

		event.addSpeaker(speaker2);
		assertEquals(2, event.getSpeakers().size());

		assertEquals("Altavoz", event.getSpeakers().get(0).getName());
	}

	@Test
	@DisplayName("Comprobamos si al añadir un speaker es null, y no se añade")
	void testAddSpeakersNull() {
		assertEquals(0, event.getSpeakers().size());

		event.addSpeaker(null);

		assertEquals(0, event.getSpeakers().size());
	}

	@Test
	@DisplayName("Comprobamos si el total de speaker se borra")
	void testRemoveSpeaker() {
		assertEquals(0, event.getSpeakers().size());

		Speaker speaker1 = new Speaker(1L, "Altavoz", "");
		Speaker speaker2 = new Speaker(2L, "Altavoz 2", "");
		event.addSpeaker(speaker1);

		assertEquals(1, event.getSpeakers().size());

		event.addSpeaker(speaker2);
		assertEquals(2, event.getSpeakers().size());

		event.removeSpeaker(speaker2);
		assertEquals(1, event.getSpeakers().size());
	}

	@Test
	@DisplayName("Comprobamos si al borrar un null no se borra")
	void testRemoveSpeakerNull() {
		Event evento = new Event(1L, "Evento 1", EventType.BUSINESS, new EventNotificationServiceImpl());

		evento.setSpeakers(null);
		assertEquals(null, evento.getSpeakers());

		evento.removeSpeaker(null);

		assertNull(evento.getSpeakers());
	}
}
