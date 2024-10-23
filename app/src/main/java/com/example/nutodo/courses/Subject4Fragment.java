package com.example.nutodo.courses;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutodo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Subject4Fragment extends Fragment {

    private EditText commentInput1, commentInput2, commentInput3;
    private ImageView sendButton1, sendButton2, sendButton3;
    private LinearLayout commentsContainer1, commentsContainer2, commentsContainer3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_subject4, container, false);

        // Initialize views for Card 1
        commentInput1 = view.findViewById(R.id.commentInput1);
        sendButton1 = view.findViewById(R.id.sendButton1);
        commentsContainer1 = view.findViewById(R.id.commentsContainer1);

        // Initialize views for Card 2
        commentInput2 = view.findViewById(R.id.commentInput2);
        sendButton2 = view.findViewById(R.id.sendButton2);
        commentsContainer2 = view.findViewById(R.id.commentsContainer2);

        // Initialize views for Card 3
        commentInput3 = view.findViewById(R.id.commentInput3);
        sendButton3 = view.findViewById(R.id.sendButton3);
        commentsContainer3 = view.findViewById(R.id.commentsContainer3);

        // Set send button click listener for Card 1
        sendButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentInput1.getText().toString().trim();
                if (!TextUtils.isEmpty(comment)) {
                    addComment(comment, commentsContainer1);
                    commentInput1.setText(""); // Clear the input field
                } else {
                    Toast.makeText(getContext(), "Comment cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set send button click listener for Card 2
        sendButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentInput2.getText().toString().trim();
                if (!TextUtils.isEmpty(comment)) {
                    addComment(comment, commentsContainer2);
                    commentInput2.setText(""); // Clear the input field
                } else {
                    Toast.makeText(getContext(), "Comment cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set send button click listener for Card 3
        sendButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = commentInput3.getText().toString().trim();
                if (!TextUtils.isEmpty(comment)) {
                    addComment(comment, commentsContainer3);
                    commentInput3.setText(""); // Clear the input field
                } else {
                    Toast.makeText(getContext(), "Comment cannot be empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    // Method to add a comment to the specified comments container
    private void addComment(String commentText, LinearLayout commentsContainer) {
        View commentView = LayoutInflater.from(getContext()).inflate(R.layout.comment_layout, commentsContainer, false);

        ImageView profileIcon = commentView.findViewById(R.id.profileIcon);
        TextView commentTextView = commentView.findViewById(R.id.commentTextView);
        TextView timestampTextView = commentView.findViewById(R.id.timestampTextView);

        // Set comment text and timestamp
        commentTextView.setText(commentText);
        String currentTime = new SimpleDateFormat("hh:mm a", Locale.getDefault()).format(new Date());
        timestampTextView.setText(currentTime);

        // Add the new comment view to the comments container
        commentsContainer.addView(commentView);
    }
}
