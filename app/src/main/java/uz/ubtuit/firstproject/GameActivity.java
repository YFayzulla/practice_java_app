package uz.ubtuit.firstproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import java.util.Random;
public class GameActivity extends AppCompatActivity {
    private TextView resultTextView;
    private String[] choices = {"Tosh", "Qog'oz", "Qaychi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        resultTextView = findViewById(R.id.resultTextView);
        ImageButton rockButton = findViewById(R.id.rockButton);
        ImageButton paperButton = findViewById(R.id.paperButton);
        ImageButton scissorsButton = findViewById(R.id.scissorsButton);
        rockButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Tosh");
            }
        });
        paperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Qog'oz");
            }
        });
        scissorsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playGame("Qaychi");
            }
        });
    }

    private void playGame(String userChoice) {
        String computerChoice = choices[new
                Random().nextInt(choices.length)];
        String result;
        if (userChoice.equals(computerChoice)) {
            result = "Durrang! Kompyuter ham " + computerChoice + "harakatini tanladi.";
        } else if (
                (userChoice.equals("Tosh") &&
                        computerChoice.equals("Qaychi")) ||
                        (userChoice.equals("Qog'oz") &&
                                computerChoice.equals("Tosh")) ||
                        (userChoice.equals("Qaychi") &&
                                computerChoice.equals("Qog'oz"))) {
            result = "Siz yutdingiz! Kompyuter " + computerChoice + "harakatini tanladi.";
        } else {
            result = "Siz yutqazdingiz! Kompyuter " + computerChoice +
                    " harakatini tanladi.";
        }
        resultTextView.setText(result);
        showDialog(result);
    }

    private void showDialog(String message) {
        new android.app.AlertDialog.Builder(this)
                .setTitle("O'yin Natijasi")
                .setMessage(message)
                .setPositiveButton("OK", null)
                .show();
    }
}