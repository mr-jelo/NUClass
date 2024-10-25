package com.example.nutodo.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.nutodo.R;

public class DefaultTaskDeet extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate your layout for this fragment (e.g., fragment_default_task_deet.xml)
        return inflater.inflate(R.layout.fragment_default_task_deet, container, false);
    }
}
