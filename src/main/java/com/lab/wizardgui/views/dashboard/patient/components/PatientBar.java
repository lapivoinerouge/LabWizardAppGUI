package com.lab.wizardgui.views.dashboard.patient.components;

import com.lab.wizardgui.views.dashboard.employee.components.MyButton;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class PatientBar extends HorizontalLayout {

    public PatientBar() {

        MyButton history = new MyButton("Historia wyników", new Icon(VaadinIcon.ARCHIVE), event -> getUI().ifPresent(ui -> ui.navigate("patient/history")));
        MyButton appointment = new MyButton("Umów wizytę", new Icon(VaadinIcon.CALENDAR), event -> getUI().ifPresent(ui -> ui.navigate("patient/appointment")));
        MyButton rate = new MyButton("Zostaw ocenę", new Icon(VaadinIcon.STAR_HALF_LEFT), event -> getUI().ifPresent(ui -> ui.navigate("patient/rate")));

        Button back = new Button("", new Icon(VaadinIcon.ARROW_BACKWARD), event -> getUI().ifPresent(ui -> ui.navigate("patient/dashboard")));
        Button main = new Button("", new Icon(VaadinIcon.HOME), event -> getUI().ifPresent(ui -> ui.navigate("main")));
        Button logout = new Button("Wyloguj", new Icon(VaadinIcon.SIGN_OUT), event -> getUI().ifPresent(ui -> ui.navigate("main")));

        getStyle().set("margin-left", "15px");
        add(history, appointment, rate, back, main, logout);
        back.getStyle().set("margin-left", "560px");
        back.getStyle().set("margin-right", "0px");
        main.getStyle().set("margin-left", "2px");
        logout.getStyle().set("margin-left", "2px");
    }

}
