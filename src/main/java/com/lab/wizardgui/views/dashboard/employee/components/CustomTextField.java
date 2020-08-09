package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.textfield.TextField;

public class CustomTextField extends TextField {

    public CustomTextField(String label) {
        super(label);
    }

    @Override
    public String toString() {
        return this.getLabelString();
    }
}
