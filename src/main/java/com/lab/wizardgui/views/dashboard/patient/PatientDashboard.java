package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Moje konto")
@Route(value = "patient/dashboard")
public class PatientDashboard extends VerticalLayout {

    public PatientDashboard(@Autowired ResultClient client) {

        PatientBar bar = new PatientBar();

        add(bar);
        setSizeFull();
    }
}
