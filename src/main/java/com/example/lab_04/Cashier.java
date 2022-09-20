package com.example.lab_04;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cashier {
    @RequestMapping(value = "/getChange/{nbank}", method = RequestMethod.GET)
    public Change getChange(@PathVariable("nbank") int nbank){
        Change money = new Change();
        money.setB1000(nbank/1000);
        nbank %= 1000;
        money.setB500(nbank/500);
        nbank %= 500;
        money.setB100(nbank/100);
        nbank %= 100;
        money.setB20(nbank/20);
        nbank %= 20;
        money.setB10(nbank/10);
        nbank %= 10;
        money.setB5(nbank/5);
        nbank %= 5;
        money.setB1(nbank/1);
        return money;
    }
}

