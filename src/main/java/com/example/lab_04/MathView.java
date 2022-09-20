package com.example.lab_04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.awt.*;

@Route(value = "index1")
public class MathView extends FormLayout {
    private TextField n1, n2, ans;
    private Button plus_b, minus_b, times_b, divide_b, mod_b, max_b;

    public MathView() {
        HorizontalLayout div = new HorizontalLayout();
        VerticalLayout main_div = new VerticalLayout();
        n1 = new TextField("Number 1");
        n2 = new TextField("Number 2");
        ans = new TextField("Answer");
        plus_b = new Button("+");
        minus_b = new Button("-");
        times_b = new Button("x");
        divide_b = new Button("/");
        mod_b = new Button("Mod");
        max_b = new Button("Max");
        div.add(plus_b, minus_b, times_b, divide_b, mod_b, max_b);
        main_div.add(n1, n2, div, ans);
        add(main_div);

//        plus
        plus_b.addClickListener(even -> {
            double num_1, num_2;
            num_1 = Double.parseDouble(n1.getValue());
            num_2 = Double.parseDouble(n2.getValue());
            String res = WebClient.create().get().uri("http://localhost:8080/plus/" + num_1 +"/" + num_2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(res);

        });
//        minus
        minus_b.addClickListener(even -> {
            double num_1, num_2;
            num_1 = Double.parseDouble(n1.getValue());
            num_2 = Double.parseDouble(n2.getValue());
            String res = WebClient.create().get().uri("http://localhost:8080/minus/" + num_1 +"/" + num_2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(res);

        });
//        divide
        divide_b.addClickListener(even -> {
            double num_1, num_2;
            num_1 = Double.parseDouble(n1.getValue());
            num_2 = Double.parseDouble(n2.getValue());
            String res = WebClient.create().get().uri("http://localhost:8080/divide/" + num_1 +"/" + num_2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(res);

        });
//        times
        times_b.addClickListener(even -> {
            double num_1, num_2;
            num_1 = Double.parseDouble(n1.getValue());
            num_2 = Double.parseDouble(n2.getValue());
            String res = WebClient.create().get().uri("http://localhost:8080/multi/" + num_1 +"/" + num_2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(res);

        });
//        mod
        mod_b.addClickListener(even -> {
            double num_1, num_2;
            num_1 = Double.parseDouble(n1.getValue());
            num_2 = Double.parseDouble(n2.getValue());
            String res = WebClient.create().get().uri("http://localhost:8080/mod/" + num_1 +"/" + num_2)
                    .retrieve().bodyToMono(String.class).block();
            ans.setValue(res);

        });
//        max
        max_b.addClickListener(even -> {
            MultiValueMap<String , String> data = new LinkedMultiValueMap<>();
            data.add("n1", n1.getValue());
            data.add("n2", n2.getValue());
            String res = WebClient.create().post().uri("http://localhost:8080/max").contentType(MediaType.APPLICATION_FORM_URLENCODED).body(BodyInserters.fromFormData(data)).retrieve().bodyToMono(String.class).block();
            ans.setValue(res);
        });
    }
}
