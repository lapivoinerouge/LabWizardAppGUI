package com.lab.wizardgui.views.dashboard.patient;

import com.lab.wizardgui.client.RateClient;
import com.lab.wizardgui.domain.RateDto;
import com.lab.wizardgui.views.dashboard.patient.components.PatientBar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "patient/rate")
public class PatientRate extends VerticalLayout {

    private ComboBox<Long> rate = new ComboBox<Long>("Ocena");
    private TextField name = new TextField("Imię");
    private TextArea comment = new TextArea("Komentarz");
    private Button submit;

    public PatientRate(@Autowired RateClient client) {

        PatientBar bar = new PatientBar();

        H3 title = new H3("Podziel się z nami swoją opinią!");

        rate.setItems(1L, 2L, 3L, 4L, 5L);

        comment.setHeight("300px");
        comment.setWidth("400px");
        comment.setPlaceholder("Co o nas myślisz...");

        submit = new Button("Oceń", e -> {
            client.createRate(new RateDto(name.getValue(), rate.getValue(), comment.getValue()));
            submit.setEnabled(false);
            rateAdded();
            rate.setEnabled(false);
            name.setEnabled(false);
            comment.setEnabled(false);
        });

        HorizontalLayout container1 = new HorizontalLayout(rate, name);
        VerticalLayout container2 = new VerticalLayout(title, container1, comment, submit);
        container2.getStyle().set("margin-left", "300px");
        container2.setWidth("450px");
        submit.getStyle().set("margin-left", "270px");

        add(bar, container2);
    }

    public void rateAdded() {
        Notification notification = new Notification("Opinia została dodana", 3000);
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
        notification.setPosition(Notification.Position.MIDDLE);
        notification.open();
    }
}
