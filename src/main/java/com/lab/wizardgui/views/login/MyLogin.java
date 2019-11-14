package com.lab.wizardgui.views.login;

import com.vaadin.flow.component.login.AbstractLogin;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MyLogin extends VerticalLayout {

    public MyLogin() {
        LoginForm login = new LoginForm();
        login.setI18n(createPolishI18n());

        add(login);

        login.addLoginListener(e -> {
            boolean isAuthenticated = authenticate(e);
            if (isAuthenticated) {
                navigate();
            } else {
                login.setError(true);
            }
        });

    }

    //mock to test
    private boolean authenticate(AbstractLogin.LoginEvent e) {
        return true;
    }

    public void navigate() {

    }

    private LoginI18n createPolishI18n() {
        final LoginI18n i18n = LoginI18n.createDefault();

        i18n.setHeader(new LoginI18n.Header());
        i18n.getHeader().setTitle("?????????????");
        i18n.getHeader().setDescription("????????????");
        i18n.getForm().setTitle("Logowanie do systemu");
        i18n.getForm().setUsername("Login");
        i18n.getForm().setPassword("Hasło");
        i18n.getForm().setSubmit("Zaloguj");
        i18n.getForm().setForgotPassword("Przypomnij hasło");
        i18n.getErrorMessage().setTitle("Błąd logowania");
        i18n.getErrorMessage().setMessage("Login lub hasło nieprawidłowe.");
        i18n.setAdditionalInformation(
                "Dodatkowe informacje.......");
        return i18n;
    }
}
