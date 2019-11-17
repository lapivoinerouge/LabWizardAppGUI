package com.lab.wizardgui.views.main.components.divs;

import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class TestOffer extends Div {

    public TestOffer() {
        H3 title = new H3("Oferta badań");
        Accordion accordion = new Accordion();
        accordion.add("Posiew moczu", new Span("Varius duis at consectetur lorem donec massa. Nec sagittis aliquam malesuada bibendum arcu vitae elementum. Ac ut consequat semper viverra nam libero. Feugiat in fermentum posuere urna nec tincidunt praesent. Proin gravida hendrerit lectus a. Sit amet luctus venenatis lectus. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae. "))
                .addThemeVariants(DetailsVariant.FILLED);
        accordion.add("Posiew kału", new Span("Vitae nunc sed velit dignissim sodales ut. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing. Non curabitur gravida arcu ac tortor dignissim convallis aenean et. "))
                .addThemeVariants(DetailsVariant.FILLED);
        accordion.add("Wymaz z gardła i nosa", new Span("Velit egestas dui id ornare arcu. Pellentesque dignissim enim sit amet venenatis urna. Sapien et ligula ullamcorper malesuada. Egestas maecenas pharetra convallis posuere morbi."))
                .addThemeVariants(DetailsVariant.FILLED);
        accordion.add("Wymaz z pochwy", new Span("Purus semper eget duis at. Enim nunc faucibus a pellentesque. Vitae turpis massa sed elementum tempus egestas sed. Diam in arcu cursus euismod quis viverra nibh. Blandit aliquam etiam erat velit. Mi sit amet mauris commodo quis. Sapien pellentesque habitant morbi tristique senectus et. "))
                .addThemeVariants(DetailsVariant.FILLED);
        accordion.add("Wymaz ze skóry", new Span("Egestas purus viverra accumsan in nisl nisi scelerisque eu ultrices. Neque viverra justo nec ultrices dui sapien. Arcu dui vivamus arcu felis bibendum ut tristique et egestas. Cum sociis natoque penatibus et magnis dis parturient montes nascetur."))
                .addThemeVariants(DetailsVariant.FILLED);
        accordion.setWidth("500px");

        HorizontalLayout layout = new HorizontalLayout();
        Image image = new Image("https://images.pexels.com/photos/256262/pexels-photo-256262.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "img1");
        image.setWidth("50%");
        layout.add(accordion, image);

        add(title, layout);
    }
}
