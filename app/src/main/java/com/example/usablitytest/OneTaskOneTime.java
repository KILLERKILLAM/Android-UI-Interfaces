package com.example.usablitytest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import com.google.android.material.tabs.TabLayout;

public class OneTaskOneTime extends AppCompatActivity {

    List<String> Questions;

    ViewPager viewPager;
    TabLayout indicator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_task_one_time);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        indicator = (TabLayout) findViewById(R.id.indicator);


        Questions = new ArrayList<>();
        Questions.add("Aadhaar ID");
        Questions.add("Name");
        Questions.add("Date Of Birth");
        Questions.add("Gender");
        Questions.add("Email ID");
        Questions.add("Mobile");
        Questions.add("Address");


        viewPager.setAdapter(new SliderAdapter(this , Questions));
        indicator.setupWithViewPager(viewPager, true);


    }


}
