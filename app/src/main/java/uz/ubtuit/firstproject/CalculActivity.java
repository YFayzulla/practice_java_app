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

        Button buttonOne = findViewById(R.id.one);
        Button buttonTwo = findViewById(R.id.two);
        Button buttonThree = findViewById(R.id.three);
        Button buttonFour = findViewById(R.id.four);
        Button buttonFive = findViewById(R.id.five);
        Button buttonSix = findViewById(R.id.six);
        Button buttonSeven = findViewById(R.id.seven);
        Button buttonEight = findViewById(R.id.eight);
        Button buttonNine = findViewById(R.id.nine);
        Button buttonZero = findViewById(R.id.zero);
        Button buttonClear = findViewById(R.id.clear);

        // actions

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

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearButton();
            }
        });


        //for numbers

//        buttonOne.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                numberInput.setText("1");
//            }
//        });
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("1");
            }
        });
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("2");
            }
        });
        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("3");
            }
        });
        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("4");
            }
        });
        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("5");
            }
        });
        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("6");
            }
        });
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("7");
            }
        });
        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("8");
            }
        });
        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("9");
            }
        });
        buttonZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberInput.append("0");
            }
        });

    }

    private void saveFirstNumber(String op) {
        firstNumber = Double.parseDouble(numberInput.getText().toString());
        operator = op;
        numberInput.setText("");  // Очищаем поле для ввода второго числа
    }

    private void clearButton() {
        resultText.setText("0");
        numberInput.setText("0");
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
//        resultText.setText(String.valueOf(result));
        resultText.setText("hello world");
    }
}