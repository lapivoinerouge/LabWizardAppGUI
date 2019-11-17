package com.lab.wizardgui.views.main.components.divs;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.domain.RateDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Rating extends Div {

    @Autowired
    RateClient client;

    public Rating() {
        H3 title = new H3("Co o nas mówią?");
        Grid<RateDto> grid = new Grid<>();
        grid.setWidthFull();
        grid.setHeight("300px");
        List<RateDto> rates = client.getAllRates();
        grid.setItems(rates);

        Grid.Column<RateDto> nameColumn = grid.addColumn(RateDto::getName).setHeader("imię");
        Grid.Column<RateDto> rateColumn = grid.addColumn(RateDto::getRate).setHeader("ocena");
        Grid.Column<RateDto> commentColumn = grid.addColumn(RateDto::getComment).setHeader("komentarz");

        add(title, grid);
    }
}
