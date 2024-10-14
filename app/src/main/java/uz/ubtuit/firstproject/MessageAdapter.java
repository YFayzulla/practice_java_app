package uz.ubtuit.firstproject;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Message> messages;
    private String currentUser;

    public MessageAdapter(Context context, ArrayList<Message> messages, String currentUser) {
        this.context = context;
        this.messages = messages;
        this.currentUser = currentUser;
    }

    @Override
    public int getCount() {
        return messages.size();
    }

    @Override
    public Object getItem(int position) {
        return messages.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message message = messages.get(position);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            // Check who is the sender, and inflate different layouts accordingly
            if (message.getSender().equals(currentUser)) {
                convertView = inflater.inflate(R.layout.item_message_sent, parent, false); // For messages sent by the user
            } else {
                convertView = inflater.inflate(R.layout.item_message_received, parent, false); // For messages received from others
            }
        }

        // Populate the message text into the appropriate view
        TextView messageTextView = convertView.findViewById(R.id.messageTextView);
        messageTextView.setText(message.getMessageText());

        return convertView;
    }
}
