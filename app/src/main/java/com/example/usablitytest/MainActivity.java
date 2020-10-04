package com.example.usablitytest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button_one_task_one_time,button_chat_bot,button_scroll_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_one_task_one_time = (Button) findViewById(R.id.button_one_task_one_time);
        button_chat_bot = (Button) findViewById(R.id.button_chat_bot);
        button_scroll_view = (Button) findViewById(R.id.button_scroll_view);

        button_one_task_one_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openOneTaskOneTime();
            }
        });

        button_chat_bot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openChatBot();
            }
        });

        button_scroll_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openScrowView();
            }
        });
    }

    public void openChatBot(){
        Intent intent = new Intent(this, ChatBot.class );
        startActivity(intent);
    }

    public void openScrowView()
    {
        Intent intent = new Intent(this,ScrollView.class );
        startActivity(intent);
    }

    public void openOneTaskOneTime()
    {
        Intent intent = new Intent(this, OneTaskOneTime.class);
        startActivity(intent);
    }
}
