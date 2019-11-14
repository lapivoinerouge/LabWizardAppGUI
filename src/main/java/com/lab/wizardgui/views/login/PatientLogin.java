package com.lab.wizardgui.views.login;

import com.vaadin.flow.router.Route;

@Route(value = "patient/login")
public class PatientLogin extends MyLogin {

    @Override
    public void navigate() {
        getUI().ifPresent(ui -> ui.navigate("patient/dashboard"));
    }

}
