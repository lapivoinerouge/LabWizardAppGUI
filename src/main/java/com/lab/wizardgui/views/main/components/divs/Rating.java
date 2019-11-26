package com.lab.wizardgui.views.main.components.divs;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.domain.RateDto;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;

public class Rating extends Div {

    private Grid<RateDto> grid = new Grid<>();

    public Rating(RateClient client) {
        H3 title = new H3("Co o nas mówią?");
        H4 average = new H4("Średnia ocen: " + client.getAverageRate());

        grid.setWidthFull();
        grid.setMinHeight("300px");
        grid.addThemeVariants(GridVariant.LUMO_NO_ROW_BORDERS, GridVariant.LUMO_ROW_STRIPES, GridVariant.LUMO_COMPACT);
        grid.setItems(client.getAllRates());

        grid.addColumn(RateDto::getName).setHeader("imię");
        grid.addColumn(RateDto::getRate).setHeader("ocena");
        grid.addColumn(RateDto::getComment).setHeader("komentarz");

        add(title, average, grid);
    }
}
