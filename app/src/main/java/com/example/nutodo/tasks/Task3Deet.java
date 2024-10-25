package com.example.nutodo.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.nutodo.R;

public class Task3Deet extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_task3_deet, container, false);

        // Back button click listener
        view.findViewById(R.id.backButton).setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_task3Deet_to_tasksFragment));

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
        view.findViewById(R.id.submit_card).setOnClickListener(v ->
                Toast.makeText(getContext(), "Task Submitted!", Toast.LENGTH_SHORT).show());

        return view;
    }
}

