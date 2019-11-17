package com.lab.wizardgui.maps;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@SuppressWarnings("serial")
@Tag("google-map")
@JsModule("@em-polymer/google-map/google-map.js")
public class GoogleMap extends Component {


    public GoogleMap() {

        getElement().setProperty("fitToMarkers", true);

        getElement().getStyle().set("height", "450px");
        getElement().getStyle().set("width", "100%");
    }

    public GoogleMap(String apiKey) {
        this();

        getElement().setProperty("apiKey", apiKey);
    }

    public void addMarker(GoogleMapMarker marker) {
        getElement().appendChild(marker.getElement());
    }

    public void setLatitude(double lat) {
        getElement().setProperty("latitude", lat);
    }

    public void setLongitude(double lon) {
        getElement().setProperty("longitude", lon);
    }
}
