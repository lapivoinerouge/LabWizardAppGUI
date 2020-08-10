package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.HtmlComponent;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class DashboardShortcuts extends VerticalLayout {

    public DashboardShortcuts() {

        EmployeeTile patients = new EmployeeTile("PATIENTS", new Icon(VaadinIcon.USERS), e -> getUI().ifPresent(ui -> ui.navigate("employee/patients")));
        EmployeeTile registration = new EmployeeTile("TESTS", new Icon(VaadinIcon.CLIPBOARD_CROSS), e -> getUI().ifPresent(ui -> ui.navigate("employee/registration")));
        EmployeeTile laboratory = new EmployeeTile("LABORATORY", new Icon(VaadinIcon.FLASK), e -> getUI().ifPresent(ui -> ui.navigate("employee/laboratory")));
        EmployeeTile results = new EmployeeTile("RESULTS", new Icon(VaadinIcon.CLIPBOARD_CHECK), e -> getUI().ifPresent(ui -> ui.navigate("employee/results")));

        patients.getStyle().set("background-image", "url(https://images.pexels.com/photos/261152/pexels-photo-261152.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940)");
        registration.getStyle().set("background-image", "url(https://images.pexels.com/photos/1122864/pexels-photo-1122864.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940)");
        laboratory.getStyle().set("background-image", "url(https://images.pexels.com/photos/446462/pexels-photo-446462.jpeg?auto=compress&cs=tinysrgb&dpr=2&w=500)");
        results.getStyle().set("background-image", "url(https://images.pexels.com/photos/236950/pexels-photo-236950.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940)");

        HorizontalLayout row1 = new HorizontalLayout(patients, registration);
        HorizontalLayout row2 = new HorizontalLayout(laboratory, results);

        add(row1, row2);
        getStyle().set("margin-left", "250px");
    }
}
