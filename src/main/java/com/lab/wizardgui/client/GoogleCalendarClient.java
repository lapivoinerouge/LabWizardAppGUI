package com.lab.wizardgui.client;

import com.lab.wizardgui.domain.CalendarEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Component
public class GoogleCalendarClient {

    @Autowired
    private RestTemplate restTemplate;

    public CalendarEvent createNewEvent(final String name, final LocalDate day, final LocalTime start, final LocalTime end) {

        LocalDateTime date1 = LocalDateTime.of(day, start);
        LocalDateTime date2 = LocalDateTime.of(day, end);

        URI url = UriComponentsBuilder.fromHttpUrl("http://localhost:8082/google/create/")
                .build().encode().toUri();

        CalendarEvent calendarEvent = new CalendarEvent(name, date1, date2);

        return restTemplate.postForObject(url, calendarEvent, CalendarEvent.class);
    }
}
