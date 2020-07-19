package com.inovasiti.intermediate_android_kotlin.views;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.inovasiti.intermediate_android_kotlin.R;
import com.inovasiti.intermediate_android_kotlin.model.Todo;

public class TodoView extends ConstraintLayout {


    private CheckBox checkBox;
    private TextView descTextView;

    public TodoView(Context context) {
        super(context);
    }

    public TodoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TodoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Todo todo) {
        //need to set desc & textview & checkbox
        checkBox = findViewById(R.id.checkbox);
        descTextView = findViewById(R.id.desc);

        descTextView.setText(todo.getDescription());
        checkBox.setChecked(todo.isComplete());

        if (todo.isComplete()) {
            createStrikeThrough();
        }
        setCheckStateListener();
    }

    public void setCheckStateListener() {
        //available in java 8
        checkBox.setOnCheckedChangeListener((button, isChecked) -> {
        });

        //old
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    createStrikeThrough();
                } else {
                    removeStrikeThrough();
                }
            }
        });
    }

    private void createStrikeThrough() {
        descTextView.setPaintFlags(descTextView.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
    }

    private void removeStrikeThrough() {
        descTextView.setPaintFlags(descTextView.getPaintFlags() & ~(Paint.STRIKE_THRU_TEXT_FLAG));
    }
}
