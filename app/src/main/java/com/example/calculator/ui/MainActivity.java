package com.example.calculator.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.domain.ActiveFiled;
import com.example.calculator.domain.CalculatorImpl;
import com.example.calculator.domain.Operation;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final CalculatorPresenter presenter = new CalculatorPresenter(this, new CalculatorImpl());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        TextView arg1 = findViewById(R.id.arg_1);
        TextView arg2 = findViewById(R.id.arg_2);
        TextView operation = findViewById(R.id.operation);
        TextView result = findViewById(R.id.result);

        Map<Integer, String> digitsMap = new HashMap<>();
        digitsMap.put(R.id.text_1, "1");
        digitsMap.put(R.id.text_2, "2");
        digitsMap.put(R.id.text_3, "3");
        digitsMap.put(R.id.text_4, "4");
        digitsMap.put(R.id.text_5, "5");
        digitsMap.put(R.id.text_6, "6");
        digitsMap.put(R.id.text_7, "7");
        digitsMap.put(R.id.text_8, "8");
        digitsMap.put(R.id.text_9, "9");
        digitsMap.put(R.id.text_0, "0");
        digitsMap.put(R.id.text_point, getResources().getString(R.string._point));

        View.OnClickListener digitCLickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.digitalKeyPressed(digitsMap.get(view.getId()));
                switch (presenter.getActiveFiled()) {
                    case ARG1:
                        arg1.setText(presenter.getArg1());
                        break;
                    case ARG2:
                        arg2.setText(presenter.getArg2());
                        break;
                }
            }
        };

        findViewById(R.id.text_1).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_2).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_3).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_4).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_5).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_6).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_7).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_8).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_9).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_0).setOnClickListener(digitCLickListener);
        findViewById(R.id.text_point).setOnClickListener(digitCLickListener);

        findViewById(R.id.arg_1).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arg2.setBackground(null);
                arg1.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.edit_text_style, null));
                presenter.setActiveFiled(ActiveFiled.ARG1);
            }
        });

        findViewById(R.id.arg_2).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.setActiveFiled(ActiveFiled.ARG2);
                arg1.setBackground(null);
                arg2.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.edit_text_style, null));
            }
        });

        Map<Integer, Operation> operatorsMap = new HashMap<>();
        operatorsMap.put(R.id.text_division, Operation.DIV);
        operatorsMap.put(R.id.text_mult, Operation.MULT);
        operatorsMap.put(R.id.text_add, Operation.ADD);
        operatorsMap.put(R.id.text_subt, Operation.SUB);

        View.OnClickListener operatorCLickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.operatorKeyPressed(operatorsMap.get(view.getId()));
                operation.setText(operatorsMap.get(view.getId()).getTitle());
            }
        };

        findViewById(R.id.text_division).setOnClickListener(operatorCLickListener);
        findViewById(R.id.text_mult).setOnClickListener(operatorCLickListener);
        findViewById(R.id.text_add).setOnClickListener(operatorCLickListener);
        findViewById(R.id.text_subt).setOnClickListener(operatorCLickListener);

        findViewById(R.id.text_calculate).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (operation.getText() != "") {
                    presenter.calculate();
                    result.setText(presenter.getResult());
                } else {
                    Toast.makeText(MainActivity.this, "не выбрана операция", Toast.LENGTH_SHORT).show();
                }

            }
        });

        findViewById(R.id.clear_text).setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.clearAll();
                result.setText("");
                arg1.setText("");
                arg2.setText("");
            }
        });
    }
}