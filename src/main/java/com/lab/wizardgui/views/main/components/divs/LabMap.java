package com.lab.wizardgui.views.main.components.divs;

import com.lab.wizardgui.maps.GoogleMap;
import com.lab.wizardgui.maps.GoogleMapMarker;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;

public class LabMap extends Div {

    private static final String API_KEY = "AIzaSyBWkzCpvmVY_vVviBFN9Y_EGELvwmX3WNA";

    public LabMap() {
        H3 title = new H3("Kontakt");

        Paragraph p1 = new Paragraph("Telefon: +XX XXX XXX XXX");
        Paragraph p2 = new Paragraph("Email: kontakt@labwizard.com");
        Paragraph p3 = new Paragraph("Adres: ul. Labowa 21/1");

        H4 title2 = new H4("Tu nas znajdziesz:");

        GoogleMapMarker marker = new GoogleMapMarker();
        marker.setLatitude(51.089999);
        marker.setLongitude(17.016841);
        marker.setDraggable(true);

        GoogleMap map = new GoogleMap(API_KEY);
        map.setLatitude(51.089999);
        map.setLongitude(17.016841);

        map.addMarker(marker);

        add(title, p1, p2, p3, title2, map);
    }
}
