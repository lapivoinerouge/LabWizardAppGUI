package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.PatientClient;
import com.lab.wizardgui.domain.PatientDto;
import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.lab.wizardgui.views.dashboard.employee.components.PatientForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/patients")
public class PatientsBase extends VerticalLayout {

    private Grid<PatientDto> grid = new Grid<>();

    public PatientsBase(@Autowired PatientClient client) {

        EmployeeBar bar = new EmployeeBar();

        HorizontalLayout layout = new HorizontalLayout();
        layout.setSizeFull();

        VerticalLayout base = new VerticalLayout();
        base.setWidth("60%");

        TextField filterByLastname = new TextField();
        filterByLastname.setPlaceholder("Szukaj po nazwisku...");
        filterByLastname.getStyle().set("font-size", "12px");
        filterByLastname.setClearButtonVisible(true);
        filterByLastname.setValueChangeMode(ValueChangeMode.EAGER);

        grid.setWidthFull();
        grid.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COMPACT);

        Grid.Column<PatientDto> firstnameColumn = grid.addColumn(PatientDto::getFirstname).setHeader("imię");
        Grid.Column<PatientDto> lastnameColumn = grid.addColumn(PatientDto::getLastname).setHeader("nazwisko");
        Grid.Column<PatientDto> peselColumn = grid.addColumn(PatientDto::getPesel).setHeader("pesel");
        Grid.Column<PatientDto> emailColumn = grid.addColumn(PatientDto::getEmail).setHeader("email");
        refresh(client);

        filterByLastname.addValueChangeListener(event -> grid.setItems(client.findPatientsByLastname(filterByLastname.getValue())));

        base.add(new H2("Baza pacjentów"), filterByLastname, grid);

        PatientForm form = new PatientForm(client, this);
        form.setWidth("35%");
        grid.asSingleSelect().addValueChangeListener(e -> {
            form.setPatient(grid.asSingleSelect().getValue());
        });

        layout.add(base, form);
        add(bar, layout);
    }

    public void refresh(PatientClient client) {
        grid.setItems(client.getAllPatients());
    }

    public void patientAdded() {
        Notification notification = new Notification("Pacjent został dodany do bazy.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }

    public void patientEdited() {
        Notification notification = new Notification("Zmiany zostały zapisane.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }

    public void patientDeleted() {
        Notification notification = new Notification("Pacjent został usunięty.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }
}
