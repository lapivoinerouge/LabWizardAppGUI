package com.lab.wizardgui.views.dashboard.employee.components;

import com.lab.wizardgui.client.PatientClient;
import com.lab.wizardgui.client.UndoneResultClient;
import com.lab.wizardgui.domain.PatientDto;
import com.lab.wizardgui.domain.UndoneResultDto;
import com.lab.wizardgui.views.dashboard.employee.views.TestRegistration;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;

public class UndoneResultForm extends FormLayout {

    @PropertyId("firstname")
    private TextField firstname = new TextField("Imię");
    @PropertyId("lastname")
    private TextField lastname = new TextField("Nazwisko");
    @PropertyId("pesel")
    private TextField pesel = new TextField("Pesel");

    private ComboBox<String> material = new ComboBox<>("Materiał");

    private Binder<PatientDto> binder = new Binder<>(PatientDto.class);

    public UndoneResultForm(UndoneResultClient client, TestRegistration registration, PatientClient patientClient) {

        getStyle().set("padding-top", "100px");

        firstname.setReadOnly(true);
        lastname.setReadOnly(true);
        pesel.setReadOnly(true);

        material.setItems("Posiew moczu", "Posiew kału", "Wymaz z gardła", "Wymaz z nosa", "Wymaz z pochwy", "Wymaz ze skóry");

        Button save = new Button("Zapisz", e -> save(client, registration, patientClient));
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        HorizontalLayout buttons = new HorizontalLayout(save);

        add(new H3("Wybierz rodzaj badania:"), firstname, lastname, pesel, material, buttons);
        setMaxHeight("500px");
        setMaxWidth("40%");

        binder.bindInstanceFields(this);
    }

    public void save(UndoneResultClient undoneClient, TestRegistration registration, PatientClient patientClient) {

        PatientDto patientDto = binder.getBean();
        UndoneResultDto undoneResultDto = new UndoneResultDto(
                patientDto.getFirstname(),
                patientDto.getLastname(),
                patientDto.getPesel(),
                material.getValue());
        undoneClient.createUndone(undoneResultDto);
        registration.testRegistered();
    }

    public void setUndone(PatientDto patientDto) {
        binder.setBean(patientDto);
    }
}
