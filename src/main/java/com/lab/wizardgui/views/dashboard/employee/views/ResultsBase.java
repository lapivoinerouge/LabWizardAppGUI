package com.lab.wizardgui.views.dashboard.employee.views;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.domain.ResultDto;
import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "employee/results")
public class ResultsBase extends VerticalLayout {

    private Binder<ResultDto> binder = new Binder<>(ResultDto.class);
    private Grid<ResultDto> grid = new Grid<>();

    public ResultsBase(@Autowired ResultClient client) {

        EmployeeBar employeeBar = new EmployeeBar();
        grid.setWidthFull();
        grid.setHeight("300px");
        grid.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COMPACT);

        refresh(client);

        grid.addColumn(ResultDto::getFirstname).setHeader("firstname");
        grid.addColumn(ResultDto::getLastname).setHeader("lastname");
        grid.addColumn(ResultDto::getPesel).setHeader("pesel");
        grid.addColumn(ResultDto::getMaterial).setHeader("material");
        grid.addColumn(ResultDto::getReceiveDate).setHeader("received");
        grid.addColumn(ResultDto::getResult).setHeader("result");
        grid.addColumn(ResultDto::getComment).setHeader("comment");
        grid.addColumn(ResultDto::getEmployeeLicence).setHeader("authorized by");
        grid.addColumn(ResultDto::getFinishDate).setHeader("released");

        grid.asSingleSelect().addValueChangeListener(e -> binder.setBean(grid.asSingleSelect().getValue()));

        Button delete = new Button("Delete", e -> delete(client));
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        setHorizontalComponentAlignment(Alignment.END, delete);

        add(employeeBar, new H3("Results"), grid, delete);
    }

    public void refresh(ResultClient client) {
        grid.setItems(client.getAllResults());
    }

    public void delete(ResultClient client) {
        ResultDto resultDto = binder.getBean();
        client.deleteResult(resultDto.getId());
        refresh(client);
        resultDeleted();
    }

    public void resultDeleted() {
        Notification notification = new Notification("Result has been deleted successfully", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }
}
