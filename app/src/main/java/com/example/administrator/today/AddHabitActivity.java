package com.example.administrator.today;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.example.administrator.fragment.AddHabit_Name;
import com.example.administrator.fragment.AddHabit_Rate;

import java.util.Timer;
import java.util.TimerTask;

public class AddHabitActivity extends AppCompatActivity {
    private EditText habitname;
    private Context mContext;
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
    }

    private void bindView(){
        addHabit_name = new AddHabit_Name();
        addHabit_rate = new AddHabit_Rate();
        setAddHabit_name(addHabit_name);
        setAddHabit_rate(addHabit_rate);
        setFragment(addHabit_name);
    }

    private void setDefaultView(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.habit_container,getFragment());
        transaction.commit();
    }

    public void next(View view){
        String habitName = habitname.getText().toString();
        if (!habitName.equals("")){
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            if(getFragment()==getAddHabit_name()){
                if( !getAddHabit_rate().isAdded()){
                    transaction.hide(getFragment()).add(R.id.habit_container,getAddHabit_rate());
                }
                else{
                    transaction.hide(getFragment()).show(getAddHabit_rate());
                }
                setFragment(getAddHabit_rate());
                transaction.commit();
            }
        }
        hintKb();
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
