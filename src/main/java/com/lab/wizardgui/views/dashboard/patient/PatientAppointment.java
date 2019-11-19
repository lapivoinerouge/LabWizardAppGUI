package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.vaadin.flow.component.Text;
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

        VerticalLayout calendar = new VerticalLayout();
        calendar.getStyle().set("background-color", "#dde1e7");
        calendar.setWidth("400px");
        calendar.setHeight("300px");
        calendar.add(new Text("kalendarz"));

        DatePicker date = new DatePicker("Wybierz dzień:");
        date.setClearButtonVisible(true);
//        date.addValueChangeListener(
//                e -> ....);

        TimePicker time = new TimePicker("Wybierz godzinę:");
        date.setClearButtonVisible(true);
//        time.addValueChangeListener(
//                e -> ...);

        HorizontalLayout timeBar = new HorizontalLayout(date, time);
        HorizontalLayout container = new HorizontalLayout(calendar, timeBar);
        container.getStyle().set("margin-left", "300px");

        add(bar, title, container);
    }
}
