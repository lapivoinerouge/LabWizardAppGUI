package com.lab.wizardgui.views.components.main.divs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;

public class InfoDiv extends Div {

    private H3 title;
    private Text text;
    private Image image;

    public InfoDiv() {
        aboutUs();
    }

    public void aboutUs() {
        title = new H3("Kim jesteśmy?");
        text = new Text("Jesteśmy lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal");
        image = new Image("https://static.wixstatic.com/media/2cd43b_adbdc277169f414cb7ca9a27564edfcf~mv2.png?dn=PNGPIX-COM-Microscope-PNG-Transparent-Image-2.png", "img1");
        add(title, text, image);
    }

    public void offer() {
        title = new H3("Jakie badania u nas zrobisz?");
        text = new Text("Jesteśmy lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal");
        image = new Image("https://static.wixstatic.com/media/2cd43b_adbdc277169f414cb7ca9a27564edfcf~mv2.png?dn=PNGPIX-COM-Microscope-PNG-Transparent-Image-2.png", "img1");
        add(title, text, image);
    }

    public void preparation() {
        title = new H3("Jak się przygotować do badania?");
        text = new Text("Jesteśmy lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal");
        image = new Image("https://static.wixstatic.com/media/2cd43b_adbdc277169f414cb7ca9a27564edfcf~mv2.png?dn=PNGPIX-COM-Microscope-PNG-Transparent-Image-2.png", "img1");
        add(title, text, image);
    }

    public void rating() {
        title = new H3("Co o nas mówią?");
        text = new Text("Jesteśmy lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal");
        image = new Image("https://static.wixstatic.com/media/2cd43b_adbdc277169f414cb7ca9a27564edfcf~mv2.png?dn=PNGPIX-COM-Microscope-PNG-Transparent-Image-2.png", "img1");
        add(title, text, image);
    }

    public void contact() {
        title = new H3("Jak nas znaleźć?");
        text = new Text("Jesteśmy lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal" +
                "lalalalalalalalallalalalalalalallalalalalalalalallalalalalalalallalalalalalalalallalalalalalalal");
        image = new Image("https://static.wixstatic.com/media/2cd43b_adbdc277169f414cb7ca9a27564edfcf~mv2.png?dn=PNGPIX-COM-Microscope-PNG-Transparent-Image-2.png", "img1");
        add(title, text, image);
    }
}
