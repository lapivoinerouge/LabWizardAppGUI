package com.lab.wizardgui.views.dashboard.employee.components;

import com.lab.wizardgui.client.ResultClient;
import com.lab.wizardgui.client.UndoneResultClient;
import com.lab.wizardgui.domain.ResultDto;
import com.lab.wizardgui.domain.UndoneResultDto;
import com.lab.wizardgui.views.dashboard.employee.views.Laboratory;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.PropertyId;

public class LaboratoryForm extends FormLayout {

    @PropertyId("firstname")
    private TextField firstname = new TextField("Imię");
    @PropertyId("lastname")
    private TextField lastname = new TextField("Nazwisko");
    @PropertyId("pesel")
    private TextField pesel = new TextField("Pesel");
    @PropertyId("material")
    private TextField material = new TextField("Materiał");
//    @PropertyId("receiveDate")
//    private DateField receiveDate = new DateField("Data pobrania materiału");
    @PropertyId("result")
    private TextField result = new TextField("Wynik");
    @PropertyId("comment")
    private TextField comment = new TextField("Komentarz");

    private Binder<UndoneResultDto> binder = new Binder<>(UndoneResultDto.class);

    public LaboratoryForm(UndoneResultClient undoneResultClient, ResultClient resultClient, Laboratory laboratory) {

        getStyle().set("padding-top", "110px");

        firstname.setReadOnly(true);
        lastname.setReadOnly(true);
        pesel.setReadOnly(true);
        material.setReadOnly(true);
//        receiveDate.setReadOnly(true);


        Button save = new Button("Zapisz", e -> save(resultClient, undoneResultClient, laboratory));
        Button clear = new Button("Wyczyść", e -> binder.setBean(null));
//        Button edit = new Button("Edytuj zlecenie", e -> edit());
//        Button delete = new Button("Usuń zlecenie", e -> delete(undoneResultClient, laboratory));
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
//        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        HorizontalLayout buttons = new HorizontalLayout(save, clear);

        add(new H3("Wydawanie wyniku:"), firstname, lastname, pesel, material, result, comment, buttons);
        setMaxHeight("500px");
        setMaxWidth("40%");

        binder.bindInstanceFields(this);
    }

    public void save(ResultClient resultClient, UndoneResultClient undoneResultClient, Laboratory laboratory) {
        UndoneResultDto undoneResultDto = binder.getBean();
        ResultDto resultDto = new ResultDto(
                undoneResultDto.getId(),
                undoneResultDto.getFirstname(),
                undoneResultDto.getLastname(),
                undoneResultDto.getPesel(),
                undoneResultDto.getMaterial(),
                undoneResultDto.getReceiveDate(),
                result.getValue(),
                comment.getValue());
        resultClient.createResult(resultDto);
        laboratory.resultAdded();
    }

//    public void edit() {
//        firstname.setReadOnly(false);
//        lastname.setReadOnly(false);
//        pesel.setReadOnly(false);
//        material.setReadOnly(false);
//    }

//    public void delete(UndoneResultClient client, Laboratory laboratory) {
//        UndoneResultDto undoneResultDto = binder.getBean();
//        client.deleteUndone(undoneResultDto.getId());
//        laboratory.refresh(client);
//    }

    public void setResult(UndoneResultDto undoneResultDto) {
        binder.setBean(undoneResultDto);
    }
}
