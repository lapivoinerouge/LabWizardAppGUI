package com.lab.wizardgui.views.dashboard.employee.components;

import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class EmployeeBar extends VerticalLayout {

    public EmployeeBar() {

        MenuBar employeeBar = new MenuBar();

        MenuItem patientBase = employeeBar.addItem("Pacjenci");
        MenuItem registration = employeeBar.addItem("Rejestracja", event -> getUI().ifPresent(ui -> ui.navigate("employee/registration")));
        MenuItem laboratory = employeeBar.addItem("Pracownia", event -> getUI().ifPresent(ui -> ui.navigate("employee/laboratory")));
        MenuItem results = employeeBar.addItem("Wyniki", event -> getUI().ifPresent(ui -> ui.navigate("employee/results")));

        SubMenu patientSubmenu = patientBase.getSubMenu();
        MenuItem patientList = patientSubmenu.addItem("Baza pacjentów", event -> getUI().ifPresent(ui -> ui.navigate("employee/patients")));
        MenuItem newPatient = patientSubmenu.addItem("Nowy pacjent", event -> getUI().ifPresent(ui -> ui.navigate("employee/patients/new")));

        add(employeeBar);
    }
}
