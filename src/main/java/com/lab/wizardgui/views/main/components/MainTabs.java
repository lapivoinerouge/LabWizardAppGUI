package com.lab.wizardgui.views.main.components;

import com.lab.wizardgui.views.main.components.divs.*;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;

public class MainTabs extends Tabs {

    private InfoDiv infoDiv = new InfoDiv();

    public MainTabs() {
        Tab aboutUs = new Tab("O nas");
        Tab ourOffer = new Tab("Oferta badań");
        Tab howToPrepare = new Tab("Jak się przygotować?");
        Tab ourOpinions = new Tab("Opinie pacjentów");
        Tab contactUs = new Tab("Kontakt");

        Tabs tabs = new Tabs();

        add(aboutUs, ourOffer, howToPrepare, ourOpinions, contactUs);
    }
}
