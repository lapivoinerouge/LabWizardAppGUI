package com.lab.wizardgui.views.login;

import com.vaadin.flow.router.Route;

@Route(value = "employee/login")
public class EmployeeLogin extends MyLogin {

    @Override
    public void navigate() {
        getUI().ifPresent(ui -> ui.navigate("employee/dashboard"));
    }
}
