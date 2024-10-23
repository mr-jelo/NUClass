package com.example.nutodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        CardView subjectCard1 = view.findViewById(R.id.subject1_card);
        subjectCard1.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_subject1Fragment);
        });

        CardView subjectCard2 = view.findViewById(R.id.subject2_card);
        subjectCard2.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_subject2Fragment);
        });

        CardView subjectCard3 = view.findViewById(R.id.subject3_card);
        subjectCard3.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_subject3Fragment);
        });

        CardView subjectCard4 = view.findViewById(R.id.subject4_card);
        subjectCard4.setOnClickListener(v -> {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_subject4Fragment);
        });

        return view;
    }
}
