package com.lab.wizardgui.views.dashboard.employee;

import com.lab.wizardgui.views.dashboard.employee.components.EmployeeBar;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.contextmenu.MenuItem;
import com.vaadin.flow.component.contextmenu.SubMenu;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.menubar.MenuBar;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Moje konto")
@Route(value = "employee/dashboard")
public class EmployeeDashboard extends VerticalLayout {

    private String licence = "1234";

    public EmployeeDashboard() {
        EmployeeBar bar = new EmployeeBar();
        add(bar);
    }
}
