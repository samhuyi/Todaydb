package com.example.administrator.today;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.fragment.AddHabit_Name;
import com.example.administrator.fragment.AddHabit_Rate;

import java.util.Timer;
import java.util.TimerTask;

public class AddHabitActivity extends AppCompatActivity {
    private EditText habitname;//习惯名称
    private TextView rate_01,rate_02,rate_03,rate_04,rate_05,rate_06,rate_07;
    private boolean[] isSelected;
    private AddHabit_Name addHabit_name;
    private AddHabit_Rate addHabit_rate;
    private Fragment fragment;

    public AddHabit_Name getAddHabit_name() {
        return addHabit_name;
    }

    public void setAddHabit_name(AddHabit_Name addHabit_name) {
        this.addHabit_name = addHabit_name;
    }

    public AddHabit_Rate getAddHabit_rate() {
        return addHabit_rate;
    }

    public void setAddHabit_rate(AddHabit_Rate addHabit_rate) {
        this.addHabit_rate = addHabit_rate;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_habit);
        bindView();
        setDefaultView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        /**
         * 可以直接通过findViewById()获取fragment的组件，因为fragment本身就是Activity的一部分（“碎片”/“片段”）；
         * 因为Activity和fragment要从fragment的onActivityCreate()生命周期方法之后才能相互获取对方布局中的组件，
         *      所以在fragment中获取Activity的组件最早只能在onActivityCreate()中获取，而Activity最早只能在onStart()中获取；
         */
        habitname =(EditText)findViewById(R.id.habitname);

        rate_01 = (TextView)findViewById(R.id.rate_01);
        rate_02 = (TextView)findViewById(R.id.rate_02);
        rate_03 = (TextView)findViewById(R.id.rate_03);
        rate_04 = (TextView)findViewById(R.id.rate_04);
        rate_05 = (TextView)findViewById(R.id.rate_05);
        rate_06 = (TextView)findViewById(R.id.rate_06);
        rate_07 = (TextView)findViewById(R.id.rate_07);

        rate_01.setSelected(true);
        isSelected = new boolean[7];
        isSelected[0]=true;
    }

    private void bindView(){
        addHabit_name = new AddHabit_Name();
        addHabit_rate = new AddHabit_Rate();
        setAddHabit_name(addHabit_name);
        setAddHabit_rate(addHabit_rate);
    }

    //选择习惯的频率
    public void chooseRate(View v) {
        switch (v.getId()){
            case R.id.rate_01:
                if (isSelected[0]==true){
                    isSelected[0]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[0]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_02:
                if (isSelected[1]==true){
                    isSelected[1]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[1]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_03:
                if (isSelected[2]==true){
                    isSelected[2]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[2]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_04:
                if (isSelected[3]==true){
                    isSelected[3]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[3]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_05:
                if (isSelected[4]==true){
                    isSelected[4]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[4]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_06:
                if (isSelected[5]==true){
                    isSelected[5]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[5]=true;
                    v.setSelected(true);
                }
                break;
            case R.id.rate_07:
                if (isSelected[6]==true){
                    isSelected[6]=false;
                    v.setSelected(false);
                }
                else {
                    isSelected[6]=true;
                    v.setSelected(true);
                }
                break;
        }
    }

    //设置默认的view
    private void setDefaultView(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.habit_container,getAddHabit_name());
        transaction.add(R.id.habit_container,getAddHabit_rate());
        transaction.hide(getAddHabit_rate()).show(getAddHabit_name());
        transaction.commit();
        setFragment(getAddHabit_name());
    }

    //下一步
    public int next(View view){
        if (getFragment()==getAddHabit_name()){
            String habitName = habitname.getText().toString();
            if (!habitName.equals("")){
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.hide(getFragment()).show(getAddHabit_rate());
                transaction.commit();
                setFragment(getAddHabit_rate());
                //关闭软键盘
                hintKb();
            }
            return 0;
        }
        else{
            boolean secected=false;
            for (int i =0;i<7;i++){
                if (isSelected[i]==true){
                    secected = true;
                }
            }
            if(secected==true){
                startActivity(new Intent(AddHabitActivity.this,HabitActivity.class));
            }
        }
        return 0;
    }

    //关闭软键盘
    private void hintKb() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        if(imm.isActive()&&getCurrentFocus()!=null){
            if (getCurrentFocus().getWindowToken()!=null) {
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            }
        }
    }

    public void back(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        if(getFragment()==getAddHabit_name()){
            this.finish();
        }
        if(getFragment()==getAddHabit_rate()){
            transaction.hide(getFragment()).show(getAddHabit_name());
            setFragment(getAddHabit_name());
            transaction.commit();
        }

    }
}
