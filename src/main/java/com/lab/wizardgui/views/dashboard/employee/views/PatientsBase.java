package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.PatientClient;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/patients")
public class PatientsBase extends VerticalLayout {

    public PatientsBase(@Autowired PatientClient client) {



    }

}
