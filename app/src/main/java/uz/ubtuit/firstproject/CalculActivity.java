package uz.ubtuit.firstproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculActivity extends AppCompatActivity {

    private TextView resultText;  // This will be used to display and input numbers
    private double firstNumber = 0;
    private double secondNumber = 0;
    private String operator = "";
    private boolean isOperatorPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calcul); // Set the content to calcul.xml

        resultText = findViewById(R.id.resultText);  // This is now your number display/input

        Button buttonAdd = findViewById(R.id.buttonAdd);
        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        Button buttonDivide = findViewById(R.id.buttonDivide);
        Button buttonEquals = findViewById(R.id.buttonEquals);
        Button buttonClear = findViewById(R.id.buttonClear);

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

        // Number buttons
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button button = (Button) view;

                // If the display is currently "0", replace it with the new number
                if (resultText.getText().toString().equals("0") || isOperatorPressed) {
                    resultText.setText("");  // Clear input if an operator was just pressed
                    isOperatorPressed = false;
                }
                resultText.append(button.getText().toString());
            }
        };

        buttonOne.setOnClickListener(numberClickListener);
        buttonTwo.setOnClickListener(numberClickListener);
        buttonThree.setOnClickListener(numberClickListener);
        buttonFour.setOnClickListener(numberClickListener);
        buttonFive.setOnClickListener(numberClickListener);
        buttonSix.setOnClickListener(numberClickListener);
        buttonSeven.setOnClickListener(numberClickListener);
        buttonEight.setOnClickListener(numberClickListener);
        buttonNine.setOnClickListener(numberClickListener);
        buttonZero.setOnClickListener(numberClickListener);

        // Operator buttons
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
    }

    private void saveFirstNumber(String op) {
        firstNumber = Double.parseDouble(resultText.getText().toString());
        operator = op;
        isOperatorPressed = true;  // Flag to clear input on next number press
    }

    private void clearButton() {
        resultText.setText("0"); // Change to "" if you want it to appear empty
        firstNumber = 0;
        secondNumber = 0;
        operator = "";
    }

    private void calculateResult() {
        secondNumber = Double.parseDouble(resultText.getText().toString());
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
                    resultText.setText("Error: Division by Zero");
                    return;
                }
                break;
        }

        resultText.setText(String.valueOf(result));
        firstNumber = result;  // Set result as the first number for further operations
        isOperatorPressed = true;  // Flag to clear input on next number press
    }
}
