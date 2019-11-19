package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

public class MyButton extends Button {

    public MyButton(String text, Component icon,
                    ComponentEventListener<ClickEvent<Button>> clickListener) {
        setText(text);
        setIcon(icon);
        addClickListener(clickListener);

        getStyle().set("margin", "2px");
    }
}
