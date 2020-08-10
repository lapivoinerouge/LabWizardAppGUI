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
    private TextField firstname = new TextField("Firstname");
    @PropertyId("lastname")
    private TextField lastname = new TextField("Lastname");
    @PropertyId("pesel")
    private TextField pesel = new TextField("Pesel");
    @PropertyId("material")
    private TextField material = new TextField("Material");
    @PropertyId("result")
    private TextField result = new TextField("Result");
    @PropertyId("comment")
    private TextField comment = new TextField("Comment");

    private Binder<UndoneResultDto> binder = new Binder<>(UndoneResultDto.class);

    public LaboratoryForm(UndoneResultClient undoneResultClient, ResultClient resultClient, Laboratory laboratory) {

        getStyle().set("padding-top", "110px");

        firstname.setReadOnly(true);
        lastname.setReadOnly(true);
        pesel.setReadOnly(true);
        material.setReadOnly(true);

        Button save = new Button("Save", e -> save(resultClient, laboratory));
        Button clear = new Button("Clear", e -> binder.setBean(null));
        Button delete = new Button("Delete test", e -> delete(undoneResultClient, laboratory));
        save.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        HorizontalLayout buttons = new HorizontalLayout(save, clear);

        add(new H3("Release a result:"), firstname, lastname, pesel, material, result, comment, buttons);
        setMaxHeight("500px");
        setMaxWidth("40%");

        binder.bindInstanceFields(this);
    }

    public void save(ResultClient resultClient, Laboratory laboratory) {
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

    public void delete(UndoneResultClient undoneResultClient, Laboratory laboratory) {
        UndoneResultDto undoneResultDto = binder.getBean();
        undoneResultClient.deleteUndone(undoneResultDto.getId());
        laboratory.refresh(undoneResultClient);
        laboratory.resultDeleted();
    }

    public void setResult(UndoneResultDto undoneResultDto) {
        binder.setBean(undoneResultDto);
    }
}
