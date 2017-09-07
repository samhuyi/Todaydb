package com.example.administrator.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.administrator.today.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lenovo on 2017/9/6.
 */

public class AddHabit_Name extends Fragment implements View.OnClickListener{
    private EditText habitname;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_habit_name,container,false);
        bindView(view);
        popInput();
        return view;
    }

    private void bindView(View view){
        habitname = (EditText)view.findViewById(R.id.habitname);
        habitname.setOnClickListener(this);
    }

    /**
     * 强制弹出软键盘
     */
    private void popInput(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            public void run()
            {
                InputMethodManager inputManager =
                        (InputMethodManager)habitname.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputManager.showSoftInput(habitname, 0);
            }
        }, 400);
    }

    @Override
    public void onClick(View v) {
    }
}
