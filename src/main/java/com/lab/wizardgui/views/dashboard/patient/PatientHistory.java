package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.domain.ResultDto;
import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "patient/history")
public class PatientHistory extends VerticalLayout {

    //pesel stub to personalize result window
    private String pesel = "456789";

    public PatientHistory(@Autowired ResultClient resultClient) {

        PatientBar bar = new PatientBar();

        H3 title = new H3("Historia wyników");
        Grid<ResultDto> grid = new Grid<>();
        grid.setHeight("200px");
        grid.setWidthFull();

        grid.setItems(resultClient.getResultsByPesel(pesel));

        grid.addColumn(ResultDto::getId).setHeader("id").setWidth("50px");
        grid.addColumn(ResultDto::getMaterial).setHeader("rodzaj badania");
        grid.addColumn(ResultDto::getResult).setHeader("wynik");
        grid.addColumn(ResultDto::getComment).setHeader("komentarz");
        grid.addColumn(ResultDto::getReceiveDate).setHeader("pobrano").setWidth("200px");
        grid.addColumn(ResultDto::getFinishDate).setHeader("zakończono").setWidth("200px");
        grid.addColumn(ResultDto::getEmployeeLicence).setHeader("wykonał(a)");

        add(bar, title, grid);
    }
}
