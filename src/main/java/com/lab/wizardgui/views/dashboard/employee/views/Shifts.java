package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.GoogleCalendarClient;
import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.lab.wizardgui.views.dashboard.patient.components.Iframe;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/calendar")
public class Shifts extends VerticalLayout {

    public Shifts(@Autowired GoogleCalendarClient client) {

        EmployeeBar bar = new EmployeeBar();

        H3 title = new H3("Zarządzaj kalendarzem");

        Iframe calendar = new Iframe("https://calendar.google.com/calendar/embed?src=vjqiss4v2deaig60dqgbe053qk%40group.calendar.google.com&ctz=Europe%2FWarsaw");
        calendar.setHeight("500px");
        calendar.setWidth("800px");

        DatePicker date = new DatePicker("Dzień:");
        date.setClearButtonVisible(true);

        TimePicker time1 = new TimePicker("Godzina rozpoczęcia:");
        date.setClearButtonVisible(true);

        TimePicker time2 = new TimePicker("Godzina zakończenia:");
        date.setClearButtonVisible(true);

        TextField summary = new TextField("Nazwa wydarzenia:");

        Button submit = new Button("Wyślij", event -> client.createNewEvent(summary.getValue(), date.getValue(), time1.getValue(), time2.getValue()));

        HorizontalLayout bar1 = new HorizontalLayout(summary, date);
        HorizontalLayout bar2 = new HorizontalLayout(time1, time2);
        VerticalLayout layout = new VerticalLayout(bar1, bar2, submit);
        HorizontalLayout container = new HorizontalLayout(calendar, layout);

        add(bar, title, container);
    }
}
