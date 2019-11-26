package com.lab.wizardgui;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.views.main.components.UserZoneBar;
import com.lab.wizardgui.views.main.components.divs.Details;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("main")
public class MainView extends VerticalLayout {

    public MainView(@Autowired RateClient rateClient) {
        UserZoneBar userZoneBar = new UserZoneBar();

        Image logo = new Image("https://imgur.com/hwoqQay.png", "Logo");
        logo.setWidth("300px");
        logo.setHeight("150px");
        setHorizontalComponentAlignment(Alignment.END, logo);

        Details details = new Details(rateClient);

        add(userZoneBar, logo, details);
    }
}
