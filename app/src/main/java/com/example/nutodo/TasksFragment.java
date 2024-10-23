package com.example.nutodo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutodo.R;

public class TasksFragment extends Fragment {

    private Button buttonAssigned;
    private Button buttonMissing;
    private Button buttonComplete;
    private LinearLayout contentContainer;
    private TextView assignedContent;
    private TextView missingContent;
    private TextView completeContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        // Initialize views
        buttonAssigned = view.findViewById(R.id.buttonAssigned);
        buttonMissing = view.findViewById(R.id.buttonMissing);
        buttonComplete = view.findViewById(R.id.buttonComplete);
        contentContainer = view.findViewById(R.id.contentContainer);
        assignedContent = view.findViewById(R.id.assignedContent);
        missingContent = view.findViewById(R.id.missingContent);
        completeContent = view.findViewById(R.id.completeContent);

        // Set default visibility
        contentContainer.setVisibility(View.VISIBLE);
        assignedContent.setVisibility(View.VISIBLE);

        // Set button click listeners
        buttonAssigned.setOnClickListener(v -> showContent("assigned"));
        buttonMissing.setOnClickListener(v -> showContent("missing"));
        buttonComplete.setOnClickListener(v -> showContent("complete"));

        return view;
    }

    private void showContent(String type) {
        // Reset button styles
        resetButtonStyles();

        // Show appropriate content based on button clicked
        switch (type) {
            case "assigned":
                assignedContent.setVisibility(View.VISIBLE);
                buttonAssigned.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case "missing":
                missingContent.setVisibility(View.VISIBLE);
                buttonMissing.setTextColor(getResources().getColor(R.color.yellow));
                break;
            case "complete":
                completeContent.setVisibility(View.VISIBLE);
                buttonComplete.setTextColor(getResources().getColor(R.color.yellow));
                break;
        }

        // Set the yellow border for the clicked button
        switch (type) {
            case "assigned":
                buttonAssigned.setBackgroundResource(R.drawable.button_background);
                break;
            case "missing":
                buttonMissing.setBackgroundResource(R.drawable.button_background);
                break;
            case "complete":
                buttonComplete.setBackgroundResource(R.drawable.button_background);
                break;
        }
    }

    private void resetButtonStyles() {
        // Reset the text color and background of all buttons
        buttonAssigned.setTextColor(getResources().getColor(android.R.color.white));
        buttonMissing.setTextColor(getResources().getColor(android.R.color.white));
        buttonComplete.setTextColor(getResources().getColor(android.R.color.white));

        buttonAssigned.setBackgroundResource(R.drawable.button_background);
        buttonMissing.setBackgroundResource(R.drawable.button_background);
        buttonComplete.setBackgroundResource(R.drawable.button_background);

        // Hide all content
        assignedContent.setVisibility(View.GONE);
        missingContent.setVisibility(View.GONE);
        completeContent.setVisibility(View.GONE);
    }
}
