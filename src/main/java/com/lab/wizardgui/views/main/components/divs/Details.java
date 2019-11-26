package com.lab.wizardgui.views.main.components.divs;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.views.main.components.MainTabs;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class Details extends VerticalLayout {

    private Div div = new Div();

    public Details(RateClient rateClient) {

        MainTabs mainTabs = new MainTabs();
        setHorizontalComponentAlignment(Alignment.END, mainTabs);
        mainTabs.addSelectedChangeListener(event -> {
            String clicked = event.getSelectedTab().getLabel();
            switch (clicked) {
                case "O nas":
                    aboutUs();
                    break;
                case "Oferta badań":
                    offer();
                    break;
                case "Jak się przygotować?":
                    preparation();
                    break;
                case "Opinie pacjentów":
                    rating(rateClient);
                    break;
                case "Kontakt":
                    contact();
                    break;
            }
        });

        aboutUs();
        add(mainTabs, div);
    }

    public void aboutUs() {
        div.removeAll();
        div.add(new About());
    }

    public void offer() {
        div.removeAll();
        div.add(new TestOffer());
    }

    public void preparation() {
        div.removeAll();
        div.add(new Preparation());
    }

    public void rating(RateClient rateClient) {
        div.removeAll();
        div.add(new Rating(rateClient));
        div.setSizeFull();
    }

    public void contact() {
        div.removeAll();
        div.add(new LabMap());
        div.setSizeFull();
    }
}
