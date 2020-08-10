package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.client.UndoneResultClient;
import com.lab.wizardgui.domain.UndoneResultDto;
import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.lab.wizardgui.views.dashboard.employee.components.LaboratoryForm;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/laboratory")
public class Laboratory extends VerticalLayout {

    private Grid<UndoneResultDto> grid = new Grid<>();

    public Laboratory(@Autowired UndoneResultClient undoneResultClient, @Autowired ResultClient resultClient) {

        EmployeeBar employeeBar = new EmployeeBar();

        VerticalLayout base = new VerticalLayout();

        grid.setWidthFull();
        grid.setMaxHeight("280px");
        grid.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COMPACT);

        grid.addColumn(UndoneResultDto::getId).setHeader("id").setWidth("20px");
        grid.addColumn(UndoneResultDto::getFirstname).setHeader("firstname");
        grid.addColumn(UndoneResultDto::getLastname).setHeader("lastname");
        grid.addColumn(UndoneResultDto::getPesel).setHeader("pesel");
        grid.addColumn(UndoneResultDto::getMaterial).setHeader("material").setWidth("110px");
        grid.addColumn(UndoneResultDto::getReceiveDate).setHeader("received ").setWidth("80px");
        refresh(undoneResultClient);

        base.add(new H2("Laboratory"), new H3("Select an order:"), grid);

        HorizontalLayout layout = new HorizontalLayout();

        LaboratoryForm form = new LaboratoryForm(undoneResultClient, resultClient, this);
        grid.asSingleSelect().addValueChangeListener(e ->
                form.setResult(grid.asSingleSelect().getValue()));

        layout.add(base, form);
        add(employeeBar, layout);
    }

    public void refresh(UndoneResultClient undoneResultClient) {
        grid.setItems(undoneResultClient.getAllUndone());
    }

    public void resultAdded() {
        Notification notification = new Notification("Result has been released.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }

    public void resultDeleted() {
        Notification notification = new Notification("Test has been deleted.", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }
}
