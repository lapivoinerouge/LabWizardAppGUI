package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.PatientClient;
import com.lab.wizardgui.client.UndoneResultClient;
import com.lab.wizardgui.domain.PatientDto;
import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.lab.wizardgui.views.dashboard.employee.components.UndoneResultForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/registration")
public class TestRegistration extends VerticalLayout {

    private Grid<PatientDto> grid = new Grid<>();

    public TestRegistration(@Autowired PatientClient patientClient, @Autowired UndoneResultClient undoneResultClient) {

        EmployeeBar bar = new EmployeeBar();

        VerticalLayout base = new VerticalLayout();

        TextField filterByLastname = new TextField();
        filterByLastname.setPlaceholder("Search");
        filterByLastname.getStyle().set("font-size", "12px");
        filterByLastname.setClearButtonVisible(true);
        filterByLastname.setValueChangeMode(ValueChangeMode.EAGER);

        grid.setWidthFull();
        grid.setMaxHeight("280px");
        grid.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COMPACT);

        grid.addColumn(PatientDto::getFirstname).setHeader("firstname");
        grid.addColumn(PatientDto::getLastname).setHeader("lastname");
        grid.addColumn(PatientDto::getPesel).setHeader("pesel");
        grid.setItems(patientClient.getAllPatients());

        filterByLastname.addValueChangeListener(event -> grid.setItems(patientClient.findPatientsByLastname(filterByLastname.getValue())));

        base.add(new H2("Test Registry"), new H3("Select a patient from the list below to register tests:"), filterByLastname, grid);

        UndoneResultForm form = new UndoneResultForm(undoneResultClient, this);
        grid.asSingleSelect().addValueChangeListener(e ->
            form.setUndone(grid.asSingleSelect().getValue()));

        HorizontalLayout layout = new HorizontalLayout(base, form);
        layout.setSizeFull();
        add(bar, layout);
    }

    public void testRegistered() {
        Notification notification = new Notification("Test has been registered.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }
}
