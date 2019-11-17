package com.lab.wizardgui.views.main.components.divs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class Preparation extends Div {

    public Preparation() {
        H3 title = new H3("Jak się przygotować do badania?");
        Div textContainer = new Div();
        Text text = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Sollicitudin tempor id eu nisl nunc mi ipsum faucibus. Odio euismod lacinia at quis risus sed vulputate. Feugiat in fermentum posuere urna nec tincidunt praesent. Nisl tincidunt eget nullam non nisi. Eleifend quam adipiscing vitae proin sagittis nisl rhoncus. Tempor id eu nisl nunc mi ipsum faucibus vitae. Nunc mattis enim ut tellus elementum sagittis vitae et leo. Ultrices sagittis orci a scelerisque purus semper eget. Erat imperdiet sed euismod nisi porta. Tellus molestie nunc non blandit massa enim nec dui. Sed libero enim sed faucibus turpis in eu mi bibendum. Egestas pretium aenean pharetra magna ac placerat. Egestas fringilla phasellus faucibus scelerisque eleifend donec pretium vulputate sapien. Lectus proin nibh nisl condimentum id venenatis a.\n" +
                "\n" +
                "Augue eget arcu dictum varius duis at consectetur. Magna eget est lorem ipsum dolor sit. Tristique magna sit amet purus gravida quis. Sit amet risus nullam eget felis eget nunc lobortis mattis. Congue nisi vitae suscipit tellus mauris a diam maecenas sed. Vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare massa. Sagittis vitae et leo duis ut diam quam nulla porttitor. Libero volutpat sed cras ornare arcu dui vivamus. Facilisis volutpat est velit egestas dui. Ut sem nulla pharetra diam sit amet nisl suscipit adipiscing. Mi ipsum faucibus vitae aliquet nec.\n" +
                "\n" +
                "Quis enim lobortis scelerisque fermentum dui. Tincidunt eget nullam non nisi est sit amet facilisis. Neque gravida in fermentum et sollicitudin. Molestie at elementum eu facilisis sed odio morbi quis. Ultrices dui sapien eget mi. Platea dictumst quisque sagittis purus. Mattis pellentesque id nibh tortor id. Sit amet cursus sit amet dictum sit amet justo donec. Libero justo laoreet sit amet cursus sit amet dictum sit. Nullam non nisi est sit amet facilisis. Lobortis mattis aliquam faucibus purus in massa tempor. Bibendum at varius vel pharetra vel. Sed adipiscing diam donec adipiscing tristique. Venenatis urna cursus eget nunc scelerisque viverra. Enim nulla aliquet porttitor lacus luctus accumsan tortor posuere ac. Egestas egestas fringilla phasellus faucibus.\n" +
                "\n" +
                "Varius duis at consectetur lorem donec massa. Nec sagittis aliquam malesuada bibendum arcu vitae elementum. Ac ut consequat semper viverra nam libero. Feugiat in fermentum posuere urna nec tincidunt praesent. Proin gravida hendrerit lectus a. Sit amet luctus venenatis lectus. Vulputate sapien nec sagittis aliquam malesuada bibendum arcu vitae. Vitae nunc sed velit dignissim sodales ut. Interdum posuere lorem ipsum dolor sit amet consectetur adipiscing. Non curabitur gravida arcu ac tortor dignissim convallis aenean et. Velit egestas dui id ornare arcu. Pellentesque dignissim enim sit amet venenatis urna. Sapien et ligula ullamcorper malesuada. Egestas maecenas pharetra convallis posuere morbi. Purus semper eget duis at.");
        textContainer.add(text);
        textContainer.setWidth("50%");

        Image image = new Image("https://images.pexels.com/photos/302083/pexels-photo-302083.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "img1");
        image.setWidth("500px");

        HorizontalLayout layout = new HorizontalLayout();
        layout.add(textContainer, image);

        add(title, layout);
    }
}
