package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.lab.wizardgui.views.dashboard.patient.components.Iframe;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.timepicker.TimePicker;
import com.vaadin.flow.router.Route;

@Route(value = "patient/appointment")
public class PatientAppointment extends VerticalLayout {

    public PatientAppointment() {
        PatientBar bar = new PatientBar();

        H3 title = new H3("Umawianie wizyty");

        Iframe calendar = new Iframe("https://calendar.google.com/calendar/embed?src=vjqiss4v2deaig60dqgbe053qk%40group.calendar.google.com&ctz=Europe%2FWarsaw");
        calendar.setHeight("500px");
        calendar.setWidth("700px");

        DatePicker date = new DatePicker("Wybierz dzień:");
        date.setClearButtonVisible(true);

        TimePicker time = new TimePicker("Wybierz godzinę:");
        date.setClearButtonVisible(true);

        //here will be implementation of sending e-mail with appointment request

        HorizontalLayout timeBar = new HorizontalLayout(date, time);
        HorizontalLayout container = new HorizontalLayout(calendar, timeBar);

        add(bar, title, container);
    }
}
