package com.example.zadanie6;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TaskFragment extends Fragment {
    private Task task;
    private EditText nameField;
    private Button dateButton;
    private CheckBox doneCheckBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        task = new Task();
    }

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_task, container, false);
        nameField = view.findViewById(R.id.task_name);
        nameField.addTextChangedListener (new TextWatcher(){
            @Override
            public void beforeTextChanged (CharSequence s, int start, int count, int after){

            }
            @Override
            public void  onTextChanged (CharSequence s, int start, int before, int count){
                task.setName(s.toString());
            }
            @Override
            public void afterTextChanged (Editable s){

            }
        });
        dateButton.setText(task.getDate().toString());
        dateButton.setEnabled(false);

        doneCheckBox.setChecked(task.isDone());
        doneCheckBox.setOnCheckedChangeListener(((buttonView, isChecked) -> task.setDone(isChecked)));
        return view;
    }


}
