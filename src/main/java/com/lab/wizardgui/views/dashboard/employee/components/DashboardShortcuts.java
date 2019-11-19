package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DashboardShortcuts extends VerticalLayout {

    public DashboardShortcuts() {

        EmployeeTile patients = new EmployeeTile("BAZA PACJENTÓW\n\n\n\nAby dodać pacjenta", new Icon(VaadinIcon.USERS), e -> getUI().ifPresent(ui -> ui.navigate("employee/patients")));
        EmployeeTile registration = new EmployeeTile("REJESTRACJA blelevlelbv", new Icon(VaadinIcon.CLIPBOARD_CROSS), e -> getUI().ifPresent(ui -> ui.navigate("employee/registration")));
        EmployeeTile laboratory = new EmployeeTile("LABORATORIUM vlvevlelve", new Icon(VaadinIcon.FLASK), e -> getUI().ifPresent(ui -> ui.navigate("employee/laboratory")));
        EmployeeTile results = new EmployeeTile("WYNIKI blelbleleb", new Icon(VaadinIcon.CLIPBOARD_CHECK), e -> getUI().ifPresent(ui -> ui.navigate("employee/results")));

        patients.getStyle().set("background-color", "#4994e5");
        registration.getStyle().set("background-color", "#e6eb67");
        laboratory.getStyle().set("background-color", "#30a868");
        results.getStyle().set("background-color", "#933055");

        HorizontalLayout row1 = new HorizontalLayout(patients, registration);
        HorizontalLayout row2 = new HorizontalLayout(laboratory, results);

        add(row1, row2);
        getStyle().set("margin-left", "250px");
    }
}
