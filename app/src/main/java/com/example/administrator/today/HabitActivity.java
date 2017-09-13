package com.example.administrator.today;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.fragment.Habit_all;
import com.example.administrator.fragment.Habit_today;

public class HabitActivity extends AppCompatActivity {
    private TextView tv_today,tv_all;
    private Habit_today habit_today;
    private Habit_all habit_all;
    private Fragment fragment;

    public Habit_today getHabit_today() {
        return habit_today;
    }

    public void setHabit_today(Habit_today habit_today) {
        this.habit_today = habit_today;
    }

    public Habit_all getHabit_all() {
        return habit_all;
    }

    public void setHabit_all(Habit_all habit_all) {
        this.habit_all = habit_all;
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
        setContentView(R.layout.activity_habit);
        bindView();
        setDefaultView();
        TextView gosetting= (TextView) findViewById(R.id.goSetting);
        //HabitActivity设置按钮跳转SettingActivity
        gosetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(HabitActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });

    }

    private void bindView(){
        habit_today = new Habit_today();
        habit_all = new Habit_all();
        setHabit_today(habit_today);
        setHabit_all(habit_all);
        setFragment(habit_today);

        tv_today = (TextView)findViewById(R.id.tv_today);
        tv_all = (TextView)findViewById(R.id.tv_all);
        //data = (TextView)findViewById(R.id.data);
    }

    private void setDefaultView(){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.add(R.id.framelayout_container,getFragment());
        transaction.commit();
    }

    public void OnClick(View view){
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        switch (view.getId()){
            case R.id.tv_today:
                tv_today.setBackgroundResource(R.drawable.today_on_shape);
                tv_all.setBackgroundResource(R.drawable.all_off_shape);
                tv_today.setTextColor(Color.parseColor("#000000"));
                tv_all.setTextColor(Color.parseColor("#ffffff"));

                if(getFragment() != getHabit_today()){
                    if( !getHabit_today().isAdded()){
                        transaction.hide(getFragment()).add(R.id.framelayout_container,getHabit_today());
                    }
                    else{
                        transaction.hide(getFragment()).show(getHabit_today());
                    }
                    setFragment(getHabit_today());
                    transaction.commit();
                }
                break;
            case R.id.tv_all:
                tv_all.setBackgroundResource(R.drawable.all_on_shape);
                tv_today.setBackgroundResource(R.drawable.today_off_shape);
                tv_today.setTextColor(Color.parseColor("#ffffff"));
                tv_all.setTextColor(Color.parseColor("#000000"));

                if(getFragment() != getHabit_all()){
                    if( !getHabit_all().isAdded()){
                        transaction.hide(getFragment()).add(R.id.framelayout_container,getHabit_all());
                    }
                    else{
                        transaction.hide(getFragment()).show(getHabit_all());
                    }
                    setFragment(getHabit_all());
                    transaction.commit();
                }
                break;
        }
    }

    public void GetData(View view){
        startActivity(new Intent(HabitActivity.this,DataActivity.class));
    }
    public void AddHabit(View view){
        startActivity(new Intent(HabitActivity.this,AddHabitActivity.class));
    }
}
