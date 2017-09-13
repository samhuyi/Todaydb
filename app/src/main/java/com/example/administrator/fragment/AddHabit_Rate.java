package com.example.administrator.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.today.R;

/**
 * Created by lenovo on 2017/9/6.
 */

public class AddHabit_Rate extends Fragment implements View.OnClickListener{
    private TextView rate_01,rate_02,rate_03,rate_04,rate_05,rate_06,rate_07;
    private boolean[] isSelected;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_habit_rate,container,false);
        //bindView(view);
        return view;
    }

    private void bindView(View view){
        rate_01 = (TextView)view.findViewById(R.id.rate_01);
        rate_02 = (TextView)view.findViewById(R.id.rate_02);
        rate_03 = (TextView)view.findViewById(R.id.rate_03);
        rate_04 = (TextView)view.findViewById(R.id.rate_04);
        rate_05 = (TextView)view.findViewById(R.id.rate_05);
        rate_06 = (TextView)view.findViewById(R.id.rate_06);
        rate_07 = (TextView)view.findViewById(R.id.rate_07);

        rate_01.setOnClickListener(this);
        rate_02.setOnClickListener(this);
        rate_03.setOnClickListener(this);
        rate_04.setOnClickListener(this);
        rate_05.setOnClickListener(this);
        rate_06.setOnClickListener(this);
        rate_07.setOnClickListener(this);

        rate_01.setSelected(true);
        isSelected = new boolean[7];
        isSelected[0]=true;

    }



    @Override
    public void onClick(View v) {
//        switch (v.getId()){
//            case R.id.rate_01:
//                if (isSelected[0]==true){
//                    isSelected[0]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[0]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_02:
//                if (isSelected[1]==true){
//                    isSelected[1]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[1]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_03:
//                if (isSelected[2]==true){
//                    isSelected[2]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[2]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_04:
//                if (isSelected[3]==true){
//                    isSelected[3]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[3]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_05:
//                if (isSelected[4]==true){
//                    isSelected[4]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[4]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_06:
//                if (isSelected[5]==true){
//                    isSelected[5]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[5]=true;
//                    v.setSelected(true);
//                }
//                break;
//            case R.id.rate_07:
//                if (isSelected[6]==true){
//                    isSelected[6]=false;
//                    v.setSelected(false);
//                }
//                else {
//                    isSelected[6]=true;
//                    v.setSelected(true);
//                }
//                break;
//        }
    }
}
