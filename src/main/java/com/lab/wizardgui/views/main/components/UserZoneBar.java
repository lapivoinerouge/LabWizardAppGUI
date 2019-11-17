package com.lab.wizardgui.views.main.components;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.menubar.MenuBar;

public class UserZoneBar extends MenuBar {

    public UserZoneBar() {
        MenuItem patient = addItem("Strefa Pacjenta", event -> getUI().ifPresent(ui -> ui.navigate("patient/login")));
        MenuItem employee = addItem("Strefa Pracownika", event -> getUI().ifPresent(ui -> ui.navigate("employee/login")));
    }
}
