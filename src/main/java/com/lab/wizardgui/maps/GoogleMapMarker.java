package com.lab.wizardgui.maps;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Synchronize;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.shared.Registration;

@SuppressWarnings("serial")
@Tag("google-map-marker")
@JsModule("@em-polymer/google-map/google-map-marker.js")
public class GoogleMapMarker extends Component {

    public GoogleMapMarker() {
    }

    public void setLatitude(double lat) {
        getElement().setProperty("latitude", lat);
    }

    public void setLongitude(double lon) {
        getElement().setProperty("longitude", lon);
    }

    @Synchronize("google-map-marker-dragend")
    public double getLatitude() {
        String property = getElement().getProperty("latitude");
        return Double.valueOf(property);
    }

    @Synchronize("google-map-marker-dragend")
    public double getLongitude() {
        String property = getElement().getProperty("longitude");
        return Double.valueOf(property);
    }

    public void setDraggable(boolean draggable) {
        getElement().setProperty("draggable", draggable);
        getElement().setProperty("dragEvents", true);
    }

    public Registration addDragEndListener(ComponentEventListener<DragEndEvent> dragEndListener) {
        return super.addListener(DragEndEvent.class, dragEndListener);
    }
}
