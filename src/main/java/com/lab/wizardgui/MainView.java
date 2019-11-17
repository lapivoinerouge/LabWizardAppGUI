package com.lab.wizardgui;

import com.lab.wizardgui.views.main.components.UserZoneBar;
import com.lab.wizardgui.views.main.components.divs.Details;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("main")
public class MainView extends VerticalLayout {

    public MainView() {
        UserZoneBar userZoneBar = new UserZoneBar();

        Image logo = new Image("https://imgur.com/hwoqQay.png", "Logo");
        logo.setWidth("500px");
        logo.setHeight("200px");
        setHorizontalComponentAlignment(Alignment.END, logo);

        Details details = new Details();

        add(userZoneBar, logo, details);
    }
}
