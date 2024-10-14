package uz.ubtuit.firstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ChatActivity extends AppCompatActivity {

    private EditText messageEditText;
    private Button sendButton;
    private ListView listViewMessages;

    private ArrayList<Message> messageList;
    private MessageAdapter messageAdapter;
    private String currentUser = "User";  // You can set this from a login or profile activity if needed

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chat);  // Connects to `chat.xml`

        // Initialize UI elements
        messageEditText = findViewById(R.id.editTextMessage);
        sendButton = findViewById(R.id.buttonSend);
        listViewMessages = findViewById(R.id.listViewMessages);

        // Initialize message list and adapter
        messageList = new ArrayList<>();
        messageAdapter = new MessageAdapter(this, messageList, currentUser);
        listViewMessages.setAdapter(messageAdapter);

        // Handle sending messages
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String messageText = messageEditText.getText().toString().trim();
                if (!messageText.isEmpty()) {
                    // Add the new message to the message list
                    Message message = new Message(messageText, currentUser);
                    messageList.add(message);

                    // Notify the adapter about the new message
                    messageAdapter.notifyDataSetChanged();

                    // Clear the input field
                    messageEditText.setText("");

                    // Scroll to the bottom to display the latest message
                    listViewMessages.smoothScrollToPosition(messageList.size() - 1);
                } else {
                    Toast.makeText(ChatActivity.this, "Please enter a message", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
