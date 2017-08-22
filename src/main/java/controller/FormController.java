package controller;

import model.Calculator;
import model.CalculatorException;

import java.awt.event.MouseEvent;

public class FormController
{
    private final Calculator calculator = new Calculator();


    public String actionClick(MouseEvent e, String symbol)
    {
        System.out.println("click by bumber: " + symbol.toLowerCase());
        try {
            calculator.add(symbol.toLowerCase());
        } catch (CalculatorException e1) {
            e1.printStackTrace();
            return  e1.getMessage();
        }

        return String.valueOf(calculator.getNumber());
    }
}
