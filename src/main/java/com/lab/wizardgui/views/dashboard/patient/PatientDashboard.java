package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.domain.ResultDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@PageTitle("Moje konto")
@Route(value = "patient/dashboard")
public class PatientDashboard extends VerticalLayout {

    private String pesel = "2345";

    public PatientDashboard(@Autowired ResultClient client) {
        H4 title = new H4("Historia wyników");
        Grid<ResultDto> grid = new Grid<>();
        grid.setHeight("200px");
        grid.setWidthFull();

        List<ResultDto> results = client.getResultsByPesel(pesel);
        grid.setItems(results);

        Grid.Column<ResultDto> idColumn = grid.addColumn(ResultDto::getId).setHeader("id").setWidth("50px");
        Grid.Column<ResultDto> materialColumn = grid.addColumn(ResultDto::getMaterial).setHeader("rodzaj badania");
        Grid.Column<ResultDto> resultColumn = grid.addColumn(ResultDto::getResult).setHeader("wynik");
        Grid.Column<ResultDto> commentColumn = grid.addColumn(ResultDto::getComment).setHeader("komentarz");
        Grid.Column<ResultDto> receiveColumn = grid.addColumn(ResultDto::getReceiveDate).setHeader("data przyjęcia materiału").setWidth("200px");
        Grid.Column<ResultDto> finishColumn = grid.addColumn(ResultDto::getFinishDate).setHeader("data zakończenia badania").setWidth("200px");
        Grid.Column<ResultDto> licenceColumn = grid.addColumn(ResultDto::getEmployeeLicence).setHeader("wykonał(a)");

        Div calendar = new Div();
        calendar.add(new H3("Umów się na wizytę"));
        calendar.setText("Tu będzie kalendarz blaaaaaaa");
        calendar.setWidth("500px");

        Div rating = new Div();
        rating.setText("Tu będą oceny balallala");
        calendar.setWidth("500px");

        HorizontalLayout dashboardLayout = new HorizontalLayout(calendar, rating);
        dashboardLayout.setSizeFull();

        add(title, grid, dashboardLayout);
        setSizeFull();
    }
}
