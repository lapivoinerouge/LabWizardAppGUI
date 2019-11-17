package com.lab.wizardgui.views.main.components.divs;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class About extends Div {

    public About() {
        H3 title = new H3("Kim jesteśmy?");
        Text p1 = new Text("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua. Amet commodo nulla facilisi nullam vehicula " +
                "ipsum a arcu cursus. Bibendum est ultricies integer quis. Urna duis convallis convallis tellus " +
                "id interdum velit laoreet id. Nunc sed blandit libero volutpat sed cras ornare. At quis risus sed " +
                "vulputate odio ut enim blandit volutpat. Proin sagittis nisl rhoncus mattis rhoncus urna neque " +
                "viverra justo. Feugiat in ante metus dictum. Risus in hendrerit gravida rutrum quisque non. In " +
                "fermentum et sollicitudin ac orci phasellus. Convallis convallis tellus id interdum velit laoreet. \n" +
                "Augue ut lectus arcu bibendum at varius vel. Eu tincidunt tortor aliquam nulla facilisi. Nunc mattis" +
                " enim ut tellus. Natoque penatibus et magnis dis parturient montes nascetur ridiculus. Cum sociis " +
                "natoque penatibus et magnis dis parturient montes. Ipsum dolor sit amet consectetur adipiscing. " +
                "Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi. Aliquet bibendum enim facilisis " +
                "gravida neque convallis. Vestibulum rhoncus est pellentesque elit ullamcorper dignissim. Facilisis " +
                "volutpat est velit egestas dui id ornare. Praesent semper feugiat nibh sed pulvinar proin gravida " +
                "hendrerit lectus. Aliquam sem et tortor consequat id porta. Turpis egestas maecenas pharetra convallis " +
                "posuere morbi. Vitae tortor condimentum lacinia quis vel eros donec ac. Pretium lectus quam id leo in. " +
                "Ultrices vitae auctor eu augue ut. Nullam non nisi est sit amet facilisis magna.");

        Image img1 = new Image("https://images.pexels.com/photos/1170979/pexels-photo-1170979.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260", "img1");
        img1.setMaxWidth("50%");
        Image img2 = new Image("https://images.pexels.com/photos/3184398/pexels-photo-3184398.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940", "img2");
        img2.setMaxWidth("50%");

        HorizontalLayout imageLayout = new HorizontalLayout();
        imageLayout.add(img1, img2);

        add(title, p1, imageLayout);
    }
}
