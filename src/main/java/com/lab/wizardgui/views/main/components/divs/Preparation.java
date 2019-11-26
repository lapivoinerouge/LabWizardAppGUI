package com.lab.wizardgui.views.main.components.divs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Preparation extends Div {

    public Preparation() {
        H3 title = new H3("Jak się przygotować do badania?");
        HorizontalLayout container = new HorizontalLayout();
        Paragraph p1 = new Paragraph("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                "tempor incididunt ut labore et dolore magna aliqua. Sollicitudin tempor id eu nisl nunc mi " +
                "ipsum faucibus. Odio euismod lacinia at quis risus sed vulputate. Feugiat in fermentum " +
                "posuere urna nec tincidunt praesent. Nisl tincidunt eget nullam non nisi. Eleifend quam " +
                "adipiscing vitae proin sagittis nisl rhoncus. Tempor id eu nisl nunc mi ipsum faucibus vitae. " +
                "Nunc mattis enim ut tellus elementum sagittis vitae et leo. Ultrices sagittis orci a scelerisque " +
                "purus semper eget. Erat imperdiet sed euismod nisi porta. Tellus molestie nunc non blandit massa " +
                "enim nec dui. Sed libero enim sed faucibus turpis in eu mi bibendum. Egestas pretium aenean pharetra. Nullam non nisi est sit amet facilisis. Lobortis mattis \" +\n" +
                "aliquam faucibus purus in massa tempor. Bibendum at varius vel pharetra vel. Sed adipiscing diam donec " +
                "adipiscing tristique. Venenatis urna cursus eget nunc scelerisque viverra. Enim nulla aliquet porttitor " +
                "lacus luctus accumsan tortor posuere ac. Egestas egestas fringilla phasellus faucibus.");
        Paragraph p2 = new Paragraph("Quis enim lobortis scelerisque fermentum dui. Tincidunt eget nullam non nisi " +
                "est sit amet facilisis. Neque gravida in fermentum et sollicitudin. Molestie at elementum eu facilisis sed " +
                "odio morbi quis. Ultrices dui sapien eget mi. Platea dictumst quisque sagittis purus. Mattis " +
                "pellentesque id nibh tortor id. Sit amet cursus sit amet dictum sit amet justo donec. Libero justo " +
                "laoreet sit amet cursus sit amet dictum sit.");
        Image image = new Image("https://images.pexels.com/photos/302083/pexels-photo-302083.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "img1");
        image.setWidth("500px");
        p1.setWidth("50%");

        container.add(p1, image);

        add(title, container, p2);
    }
}
