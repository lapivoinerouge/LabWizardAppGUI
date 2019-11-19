package com.lab.wizardgui.views.dashboard.employee.components;

import com.lab.wizardgui.client.PatientClient;
import com.lab.wizardgui.domain.PatientDto;
import com.lab.wizardgui.views.dashboard.employee.views.PatientsBase;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;
import org.springframework.beans.factory.annotation.Autowired;

public class PatientForm extends FormLayout {

    @PropertyId("firstname")
    private TextField firstname = new TextField("Imię");
    @PropertyId("lastname")
    private TextField lastname = new TextField("Nazwisko");
    @PropertyId("pesel")
    private TextField pesel = new TextField("Pesel");
    @PropertyId("email")
    private TextField email = new TextField("E-mail");
    @PropertyId("password")
    private TextField password = new TextField("Hasło");

    private Binder<PatientDto> binder = new Binder<>(PatientDto.class);

    public PatientForm(@Autowired PatientClient client, PatientsBase base) {

        getStyle().set("padding-top", "120px");

        Button save = new Button("Zapisz", e -> save(client, base));
        Button clear = new Button("Wyczyść", e -> {
            binder.setBean(null);
            firstname.clear();
            lastname.clear();
            pesel.clear();
            email.clear();
            password.clear();
        });
        Button delete = new Button("Usuń", e -> delete(client, base));
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        HorizontalLayout buttons = new HorizontalLayout(save, clear, delete);

        add(firstname, lastname, pesel, email, password, buttons);
        setMaxHeight("500px");

        binder.bindInstanceFields(this);
    }

    public void save(PatientClient client, PatientsBase base) {
        PatientDto patientDto;

        if (binder.getBean() != null) {
            patientDto = binder.getBean();
            client.editPatient(patientDto);
            base.patientEdited();
        } else {
            patientDto = new PatientDto(
                    firstname.getValue(),
                    lastname.getValue(),
                    pesel.getValue(),
                    email.getValue(),
                    password.getValue());
            client.createNewPatient(patientDto);
            base.patientAdded();
        }
        base.refresh(client);
    }

    public void delete(PatientClient client, PatientsBase base) {
        PatientDto patientDto = binder.getBean();
        client.deletePatient(patientDto.getId());
        base.refresh(client);
        base.patientDeleted();
    }

    public void setPatient(PatientDto patient) {
        binder.setBean(patient);
    }
}
