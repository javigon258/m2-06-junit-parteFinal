package com.example.Testing;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.Event;
import com.example.service.EventNotificationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class EventNotificationTest {

	@Mock
	EventNotificationServiceImpl notificationService;
	
	@InjectMocks
	Event event;
	
	@Test
	@DisplayName("Comprobamos si el notification lo llama una vez")
    void testNotificationService() throws Exception {

        event.notifyAssistants();

        verify(notificationService, times(1)).announce(event);
    }
	
}
