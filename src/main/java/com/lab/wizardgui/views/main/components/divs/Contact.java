package com.lab.wizardgui.views.main.components.divs;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;

public class Contact extends Div {

    public Contact() {

        H3 title = new H3("Jak nas znaleźć?");
        //MAPA
        add(title);
    }
}
