package com.example.calculator.domain;

public class CalculatorImpl implements Calculator {

    public double calculatingResult(double arg1, double arg2, Operation operation) {
        switch (operation) {
            case ADD:
                return addition(arg1,  arg2);
            case MULT:
                return multiplication(arg1,  arg2);
            case DIV:
                return division(arg1,  arg2);
            case SUB:
                return subtraction(arg1,  arg2);
        }
        return 0;
    }

    public double addition(double arg1, double arg2){
        return arg1 + arg2;
    }

    public double subtraction(double arg1, double arg2){
        return arg1 - arg2;
    }

    public double multiplication(double arg1, double arg2){
        return arg1 * arg2;
    }

    public double division(double arg1, double arg2){
        double result;
        if (arg2 != 0) {
            result = arg1 / arg2;
        } else {
            result = 0;
        }
        return result;
    }
}
