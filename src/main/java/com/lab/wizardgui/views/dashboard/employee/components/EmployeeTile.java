package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

public class EmployeeTile extends Button {

    public EmployeeTile(String text, Component icon,
                        ComponentEventListener<ClickEvent<Button>> clickListener) {
        setText(text);
        setIcon(icon);
        addClickListener(clickListener);

        getStyle().set("width", "400px");
        getStyle().set("height", "200px");
        getStyle().set("color", "white");
        getStyle().set("size", "200%");
    }

}
