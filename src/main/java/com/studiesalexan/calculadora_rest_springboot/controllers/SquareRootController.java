package com.studiesalexan.calculadora_rest_springboot.controllers;

import com.studiesalexan.calculadora_rest_springboot.exception.ExceptionOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class SquareRootController {

    @RequestMapping(value = "/squareRoot/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) {
        if (!MathController.isNumeric(number)) {
            throw new ExceptionOperation("Please set a numeric value");
        }
        return Math.sqrt(MathController.convertToDouble(number));
    }
}
