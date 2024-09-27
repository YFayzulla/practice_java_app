package uz.ubtuit.firstproject;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class CalculActivity extends AppCompatActivity {

    private EditText numberInput;
    private TextView resultText;
    private double firstNumber = 0;
    private String operator = "";


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcul); // Set the content to calcul.xml

        numberInput = findViewById(R.id.numberInput);
        resultText = findViewById(R.id.resultText);

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);

        // Установка действий для каждой кнопки
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFirstNumber("+");
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFirstNumber("-");
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFirstNumber("*");
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveFirstNumber("/");
            }
        });

        buttonEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });
    }

    private void saveFirstNumber(String op) {
        firstNumber = Double.parseDouble(numberInput.getText().toString());
        operator = op;
        numberInput.setText("");  // Очищаем поле для ввода второго числа
    }

    private void calculateResult() {
        double secondNumber = Double.parseDouble(numberInput.getText().toString());
        double result = 0;

        switch (operator) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber != 0) {
                    result = firstNumber / secondNumber;
                } else {
                    resultText.setText("Ошибка: деление на ноль");
                    return;
                }
                break;
        }
        resultText.setText(String.valueOf(result));
    }
}