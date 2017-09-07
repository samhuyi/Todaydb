package com.example.administrator.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.today.R;

/**
 * Created by lenovo on 2017/9/6.
 */

public class Habit_today extends Fragment implements View.OnClickListener{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_habit_today,container,false);
        return view;
    }

    @Override
    public void onClick(View v) {
    }
}
