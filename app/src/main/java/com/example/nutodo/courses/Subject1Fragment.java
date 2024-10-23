package com.example.nutodo.courses;


import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutodo.R;

public class Subject1Fragment extends Fragment {

    private EditText commentInput1, commentInput2;
    private ImageView sendButton1, sendButton2;
    private LinearLayout commentsContainer1, commentsContainer2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject1, container, false);

        // Initialize components for Card 1
        commentInput1 = view.findViewById(R.id.commentInput1);
        sendButton1 = view.findViewById(R.id.sendButton1);
        commentsContainer1 = view.findViewById(R.id.commentsContainer1);

        // Initialize components for Card 2
        commentInput2 = view.findViewById(R.id.commentInput2);
        sendButton2 = view.findViewById(R.id.sendButton2);
        commentsContainer2 = view.findViewById(R.id.commentsContainer2);

        // Set comment functionality for Card 1
        sendButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentInput1.getText().toString().trim();
                if (!comment.isEmpty()) {
                    addComment(commentsContainer1, comment);
                    commentInput1.setText(""); // Clear the input field
                }
            }
        });

        // Set comment functionality for Card 2
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentInput2.getText().toString().trim();
                if (!comment.isEmpty()) {
                    addComment(commentsContainer2, comment);
                    commentInput2.setText(""); // Clear the input field
                }
            }
        });

        return view;
    }

    // Method to add a comment to the container
    private void addComment(LinearLayout container, String commentText) {
        TextView comment = new TextView(getContext());
        comment.setText(commentText);
        comment.setTextSize(16);
        comment.setTextColor(getResources().getColor(R.color.blue));

        // Add some padding/margins
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(0, 8, 0, 8);
        comment.setLayoutParams(params);

        // Add the new comment to the container
        container.addView(comment);
    }
}
