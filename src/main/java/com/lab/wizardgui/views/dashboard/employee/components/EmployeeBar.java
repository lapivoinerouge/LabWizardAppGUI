package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;


public class EmployeeBar extends HorizontalLayout {

    public EmployeeBar() {

        MyButton patients = new MyButton("Patients", new Icon(VaadinIcon.USERS), event -> getUI().ifPresent(ui -> ui.navigate("employee/patients")));
        MyButton registration = new MyButton("Tests", new Icon(VaadinIcon.CLIPBOARD_CROSS), event -> getUI().ifPresent(ui -> ui.navigate("employee/registration")));
        MyButton laboratory = new MyButton("Laboratory", new Icon(VaadinIcon.FLASK), event -> getUI().ifPresent(ui -> ui.navigate("employee/laboratory")));
        MyButton results = new MyButton("Results", new Icon(VaadinIcon.CLIPBOARD_CHECK), event -> getUI().ifPresent(ui -> ui.navigate("employee/results")));
        MyButton calendar = new MyButton("Shifts", new Icon(VaadinIcon.CALENDAR), event -> getUI().ifPresent(ui -> ui.navigate("employee/calendar")));

        Button back = new Button("", new Icon(VaadinIcon.ARROW_BACKWARD), event -> getUI().ifPresent(ui -> ui.navigate("employee/dashboard")));
        Button main = new Button("", new Icon(VaadinIcon.HOME), event -> getUI().ifPresent(ui -> ui.navigate("main")));
        Button logout = new Button("Log out", new Icon(VaadinIcon.SIGN_OUT), event -> getUI().ifPresent(ui -> ui.navigate("main")));

        getStyle().set("margin-left", "15px");
        add(patients, registration, laboratory, results, calendar, back, main, logout);
        back.getStyle().set("margin-left", "430px");
        back.getStyle().set("margin-right", "0px");
        main.getStyle().set("margin-left", "2px");
        logout.getStyle().set("margin-left", "2px");
    }
}
