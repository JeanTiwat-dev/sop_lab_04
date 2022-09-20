package com.example.lab_04;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.lang.reflect.Array;

@Route(value = "/index2")
public class CashierView extends FormLayout{
    private TextField change, c1000, c500, c100, c20, c10, c5, c1;
    private Button cal;

    public CashierView(){
        VerticalLayout index = new VerticalLayout();
//        change
        change = new TextField();
        change.setLabel("เงินทอน");
        change.setPrefixComponent(new Span("$ : "));
//        cal
        cal = new Button();
        cal.setText("คำนวนเงินทอน");
//        c1000
        c1000 = new TextField();
        c1000.setEnabled(false);
        c1000.setPrefixComponent(new Span("$1000: "));
//        c500
        c500 = new TextField();
        c500.setEnabled(false);
        c500.setPrefixComponent(new Span("$500: "));
//        c100
        c100 = new TextField();
        c100.setEnabled(false);
        c100.setPrefixComponent(new Span("$100: "));
//        c20
        c20 = new TextField();
        c20.setEnabled(false);
        c20.setPrefixComponent(new Span("$20: "));
//        c10
        c10 = new TextField();
        c10.setEnabled(false);
        c10.setPrefixComponent(new Span("$10: "));
//        c5
        c5 = new TextField();
        c5.setEnabled(false);
        c5.setPrefixComponent(new Span("$5: "));
//        c1
        c1 = new TextField();
        c1.setEnabled(false);
        c1.setPrefixComponent(new Span("$1: "));

        index.add(change, cal, c1000, c500, c100, c20, c10, c5, c1);
        add(index);

//        function
        cal.addClickListener(even -> {
            int money;
            money = Integer.parseInt(change.getValue());
            Change res = WebClient.create().get().uri("http://localhost:8080/getChange/" + money).retrieve().bodyToMono(Change.class).block();
            c1000.setValue(res.getB1000()+"");
            c500.setValue(res.getB500()+"");
            c100.setValue(res.getB100()+"");
            c20.setValue(res.getB20()+"");
            c10.setValue(res.getB10()+"");
            c5.setValue(res.getB5()+"");
            c1.setValue(res.getB1()+"");
        });
    }
}

