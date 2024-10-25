package com.example.nutodo.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.nutodo.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task1Deet extends Fragment {

    private TextView notTurnedInText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task1_deet, container, false);

        // Back button click listener
        view.findViewById(R.id.backButton).setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_task1Deet_to_tasksFragment));

        // Reference 1 click listener
        view.findViewById(R.id.ref1_card).setOnClickListener(v ->
                Toast.makeText(getContext(), "Reference 1 shown", Toast.LENGTH_SHORT).show());

        // Reference 2 click listener
        view.findViewById(R.id.ref2_card).setOnClickListener(v ->
                Toast.makeText(getContext(), "Reference 2 shown", Toast.LENGTH_SHORT).show());

        // Attach or Create click listener
        view.findViewById(R.id.add_card).setOnClickListener(v ->
                Toast.makeText(getContext(), "Attach or Create file", Toast.LENGTH_SHORT).show());

        // Mark as Done click listener
        view.findViewById(R.id.submit_card).setOnClickListener(v -> {
            // Change the text of "Not Turned In"
            notTurnedInText = view.findViewById(R.id.not_turned_in_text); // Assuming you have given an ID to the Not Turned In TextView
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            String currentTime = sdf.format(new Date());
            // Inside the submit click listener
            TextView submissionTimeText = view.findViewById(R.id.submission_time_text);
            submissionTimeText.setText("Submitted at " + currentTime);


            // Remove add_card and update submit_card appearance
            view.findViewById(R.id.add_card).setVisibility(View.GONE);
            updateSubmitCard(view);
        });

        return view;
    }

    private void updateSubmitCard(View view) {
        CardView submitCard = view.findViewById(R.id.submit_card);
        submitCard.setBackgroundColor(getResources().getColor(R.color.yellow));

        LinearLayout submitLayout = (LinearLayout) submitCard.getChildAt(0);
        ImageView submitIcon = (ImageView) submitLayout.getChildAt(0);
        submitIcon.setImageResource(R.drawable.ic_cross);

        TextView submitText = (TextView) submitLayout.getChildAt(1);
        submitText.setText("Unsubmit");

        // Optional: Add click listener for unsubmit action if needed
        submitCard.setOnClickListener(v -> {
            // Logic to handle unsubmit action (e.g., changing back the text and restoring add_card)
            notTurnedInText.setText("Not Turned In");
            view.findViewById(R.id.add_card).setVisibility(View.VISIBLE);
            // Resetting submit card to original state
            submitText.setText("Submit");
            submitIcon.setImageResource(R.drawable.ic_check);
        });
    }
}
