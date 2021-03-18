package com.example.calculator.domain;

public interface Calculator {
     double calculatingResult(double arg1, double arg2, Operation operation);
     double addition(double arg1, double arg2);
     double subtraction(double arg1, double arg2);
     double multiplication(double arg1, double arg2);
     double division(double arg1, double arg2);
}
