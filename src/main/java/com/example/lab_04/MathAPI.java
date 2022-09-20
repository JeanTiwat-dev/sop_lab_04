package com.example.lab_04;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class MathAPI {
    private double n1;
    private double n2;

    public MathAPI() {
    }

    public MathAPI(double n1, double n2) {
        this.n1 = n1;
        this.n2 = n2;
    }

    @RequestMapping(value = "plus/{n1}/{n2}", method = RequestMethod.GET)
    public double myPlus(@PathVariable("n1") double n1,
                         @PathVariable("n2") double n2) {
        return n1 + n2;
    }

    @RequestMapping(value = "minus/{n1}/{n2}", method = RequestMethod.GET)
    public double myMinus(@PathVariable("n1") double n1,
                          @PathVariable("n2") double n2) {
        return n1 - n2;
    }

    @RequestMapping(value = "divide/{n1}/{n2}", method = RequestMethod.GET)
    public double myDivide(@PathVariable("n1") double n1,
                           @PathVariable("n2") double n2) {
        return n1 / n2;
    }

    @RequestMapping(value = "multi/{n1}/{n2}", method = RequestMethod.GET)
    public double myMulti(@PathVariable("n1") double n1,
                          @PathVariable("n2") double n2) {
        return n1 * n2;
    }

    @RequestMapping(value = "mod/{n1}/{n2}", method = RequestMethod.GET)
    public double myMod(@PathVariable("n1") double n1,
                        @PathVariable("n2") double n2) {
        return n1 % n2;
    }

    @RequestMapping(value = "/max", method = RequestMethod.POST)
    public double myMax(@RequestBody MultiValueMap<String, String> getnum) {
        Map<String, String> setnum = getnum.toSingleValueMap();
        double num1 = Double.parseDouble(setnum.get("n1"));
        double num2 = Double.parseDouble(setnum.get("n2"));
        if (num1 > num2) {
            return num1;
        }
        else {
            return num2;
        }
    }
}

