package com.studiesalexan.calculadora_rest_springboot.controllers;

import com.studiesalexan.calculadora_rest_springboot.exception.ExceptionOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new ExceptionOperation("Please set a numeric value");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if (isNumeric(number)) return Double.parseDouble(number);
        return 0D;
    }

    private boolean isNumeric(String strNumber) {
       if (strNumber == null) return false;
       String number = strNumber.replaceAll(",", ".");
       return number.matches("[-+]?\\d*\\.?\\d+");
    }
}
