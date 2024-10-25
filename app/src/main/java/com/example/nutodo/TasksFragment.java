package com.example.nutodo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.nutodo.tasks.DefaultTaskDeet;
import com.example.nutodo.tasks.Task1Deet;
import com.example.nutodo.tasks.Task2Deet;
import com.example.nutodo.tasks.Task3Deet;
import com.example.nutodo.tasks.Task4Deet;
import com.example.nutodo.tasks.Task5Deet;

import java.util.ArrayList;
import java.util.List;

public class TasksFragment extends Fragment {

    private CardView cardAssigned, cardMissing, cardComplete;
    private Spinner spinnerSubjects;
    private LinearLayout taskContainer;
    private List<Task> tasks = new ArrayList<>();
    private String selectedCategory = "Assigned";
    private String selectedSubject = "All Subjects";
    private String[] subjects = {"All Subjects", "Subject 1", "Subject 2", "Subject 3", "Subject 4"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        cardAssigned = view.findViewById(R.id.card_assigned);
        cardMissing = view.findViewById(R.id.card_missing);
        cardComplete = view.findViewById(R.id.card_complete);
        spinnerSubjects = view.findViewById(R.id.spinner_subjects);
        taskContainer = view.findViewById(R.id.task_container);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, subjects);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerSubjects.setAdapter(adapter);

        initializeTasks();

        spinnerSubjects.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                selectedSubject = subjects[position];
                displayTasks();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Default behavior
            }
        });

        cardAssigned.setOnClickListener(v -> {
            selectedCategory = "Assigned";
            updateCardAppearance(cardAssigned);
            displayTasks();
        });

        cardMissing.setOnClickListener(v -> {
            selectedCategory = "Missing";
            updateCardAppearance(cardMissing);
            displayTasks();
        });

        cardComplete.setOnClickListener(v -> {
            selectedCategory = "Completed";
            updateCardAppearance(cardComplete);
            displayTasks();
        });

        displayTasks();
        return view;
    }

    private void initializeTasks() {
        tasks.add(new Task("Subject 1", "Assessment", "Oct 29, 7:00am", "", "Assigned"));
        tasks.add(new Task("Subject 1", "Activity", "Oct 15, 1:00pm", "Oct 15, 11:27am", "Completed"));
        tasks.add(new Task("Subject 2", "Final Exam", "Oct 29, 7:00am", "", "Assigned"));
        tasks.add(new Task("Subject 3", "Project", "Oct 17, 7:00am", "", "Missing"));
        tasks.add(new Task("Subject 4", "Interim", "Oct 10, 3:00pm", "Oct 10, 2:51pm", "Completed"));
    }

    private void displayTasks() {
        taskContainer.removeAllViews();
        for (Task task : tasks) {
            if (shouldDisplayTask(task)) {
                View taskView = createTaskCard(task);
                taskContainer.addView(taskView);
            }
        }

        if (taskContainer.getChildCount() == 0) {
            TextView noTasksText = new TextView(getContext());
            noTasksText.setText("No Tasks");
            taskContainer.addView(noTasksText);
        }
    }

    private boolean shouldDisplayTask(Task task) {
        if (!selectedSubject.equals("All Subjects") && !task.getSubject().equals(selectedSubject)) {
            return false;
        }
        return task.getStatus().equals(selectedCategory);
    }

    private View createTaskCard(Task task) {
        View taskCard = LayoutInflater.from(getContext()).inflate(R.layout.task_card_layout, null);

        TextView taskName = taskCard.findViewById(R.id.tv_task_name);
        TextView taskDueOrSubmit = taskCard.findViewById(R.id.tv_due_submit);
        TextView taskSubject = taskCard.findViewById(R.id.tv_task_subject);

        taskName.setText(task.getTaskName());
        taskSubject.setText(task.getSubject());

        if (selectedCategory.equals("Assigned") || selectedCategory.equals("Missing")) {
            taskDueOrSubmit.setText("Due at " + task.getDueDate());
        } else if (selectedCategory.equals("Completed")) {
            taskDueOrSubmit.setText("Submitted at " + task.getSubmittedDate());
        }

        taskCard.setOnClickListener(v -> navigateToTaskDetail(task.getTaskName()));

        return taskCard;
    }

    private void navigateToTaskDetail(String taskName) {
        int actionId;

        switch (taskName) {
            case "Assessment":
                actionId = R.id.action_tasksFragment_to_task1Deet;
                break;
            case "Activity":
                actionId = R.id.action_tasksFragment_to_task2Deet;
                break;
            case "Final Exam":
                actionId = R.id.action_tasksFragment_to_task3Deet;
                break;
            case "Project":
                actionId = R.id.action_tasksFragment_to_task4Deet;
                break;
            case "Interim":
                actionId = R.id.action_tasksFragment_to_task5Deet;
                break;
            default:
                actionId = R.id.action_tasksFragment_to_defaultTaskDeet;
                break;
        }

        NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        navController.navigate(actionId);
    }

    private void updateCardAppearance(CardView selectedCard) {
        resetCardAppearance();
        selectedCard.setBackgroundResource(R.drawable.card_background_yellow);
    }

    private void resetCardAppearance() {
        cardAssigned.setBackgroundResource(R.drawable.card_background_blue);
        cardMissing.setBackgroundResource(R.drawable.card_background_blue);
        cardComplete.setBackgroundResource(R.drawable.card_background_blue);
    }
}
