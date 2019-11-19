package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "patient/rate")
public class PatientRate extends VerticalLayout {

    Binder<Double> binder = new Binder<>();

    public PatientRate(@Autowired RateClient client) {

        PatientBar bar = new PatientBar();

        H3 title = new H3("Co o nas myślisz?");

        ComboBox<Long> rate = new ComboBox<Long>("Ocena");
        rate.setItems(1L, 2L, 3L, 4L, 5L);

        TextField name = new TextField("Imię");

        TextArea comment = new TextArea("Komentarz");
        comment.getStyle().set("minHeight", "300px");
        comment.getStyle().set("minWidth", "400px");
        comment.setPlaceholder("Zostaw ");


//        binder.forField(rate).asRequired().withConverter(new DoubleToLongConverter()).bind(RateDto::getRate, RateDto::setRate);

        HorizontalLayout container1 = new HorizontalLayout(rate, name);
        VerticalLayout container2 = new VerticalLayout(container1,comment);
        container2.getStyle().set("margin-left", "300px");
        container2.setWidth("450px");

        add(bar, container2);
    }
}
