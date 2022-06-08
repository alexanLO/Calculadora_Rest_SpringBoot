package com.studiesalexan.calculadora_rest_springboot.controllers;

import com.studiesalexan.calculadora_rest_springboot.exception.ExceptionOperation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DivisionController {

    @RequestMapping(value = "/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) {
        if (!MathController.isNumeric(numberOne) || !MathController.isNumeric(numberTwo)) {
            throw new ExceptionOperation("Please set a numeric value");
        }
        return MathController.convertToDouble(numberOne) / MathController.convertToDouble(numberTwo);
    }
}
