package com.example.calculator.ui;

import android.content.Context;
import android.media.VolumeShaper;

import com.example.calculator.domain.ActiveFiled;
import com.example.calculator.domain.Calculator;
import com.example.calculator.domain.Operation;

public class CalculatorPresenter {
    private final Calculator calculator;
    private final Context context;

    private ActiveFiled activeFiled = ActiveFiled.ARG1;
    private StringBuilder arg1 = new StringBuilder();
    private StringBuilder arg2 = new StringBuilder();
    private Operation operation;
    private String result;

    public CalculatorPresenter(Context context, Calculator calculator) {
        this.context = context;
        this.calculator = calculator;
    }

    public void digitalKeyPressed(String digitString) {
        switch (activeFiled) {
            case ARG1:
                arg1.append(digitString);
                break;
            case ARG2:
                arg2.append(digitString);
                break;
        }
    }

    public void operatorKeyPressed(Operation operation) {
        this.operation = operation;
    }

    public void calculate() {
        if ((arg1.length() != 0) && (arg2.length() != 0)) {
            double resultD =  calculator.calculatingResult(Double.parseDouble(arg1.toString()), Double.parseDouble(arg2.toString()), operation );
            this.result = Double.toString(resultD);
        }
    }

    public void clearAll() {
        arg1.delete(0, arg1.length());
        arg2.delete(0, arg2.length());
        result = "";
    }

    public ActiveFiled getActiveFiled() {
        return activeFiled;
    }

    public void setActiveFiled(ActiveFiled activeFiled) {
        this.activeFiled = activeFiled;
    }

    public String getArg1() {
        return arg1.toString();
    }

    public String getArg2() {
        return arg2.toString();
    }

    public String getResult() {
        return result;
    }
}
