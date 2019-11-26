package com.lab.wizardgui.views.dashboard.patient.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasSize;
import com.vaadin.flow.component.Tag;

@SuppressWarnings("serial")
@Tag("iframe")
public class Iframe extends Component implements HasSize {

    public Iframe() {
    }

    public Iframe(String src) {
        setSrc(src);
        setStyle();
        setWidth("700px");
        setHeight("500px");
    }

    public void setSrc(String src) {
        getElement().setProperty("src", src);
    }

    public void setStyle() {
        getElement().getStyle().set("border", "0");
        getElement().getStyle().set("width", "800");
        getElement().getStyle().set("height", "600");
        getElement().getStyle().set("frameborder", "0");
        getElement().getStyle().set("scrolling", "no");
        getElement().getStyle().set("margin-right", "50px");
    }
}