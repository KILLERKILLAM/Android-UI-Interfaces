package com.example.usablitytest;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
public class ChatBot extends AppCompatActivity {

    private ListView mListView;
    private FloatingActionButton mButtonSend;
    private EditText mEditTextMessage;
    private ChatMessageAdapter mAdapter;
    String [] Questions = {"Enter Aadhaar ID","Enter Name ","Enter Gender ","Enter Email Id ","Enter Address ","Enter Mobile ","Enter Date of birth","Take a Picture and send it"};
    String [] Answers ;
    int Index = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_bot); mListView = (ListView) findViewById(R.id.listView);
        mButtonSend = (FloatingActionButton) findViewById(R.id.btn_send);
        mEditTextMessage = (EditText) findViewById(R.id.et_message);
        mAdapter = new ChatMessageAdapter(this, new ArrayList<ChatMessage>());
        mListView.setAdapter(mAdapter);
        mButtonSend.setImageDrawable(getResources().getDrawable( R.drawable.ic_send_24dp));

        mButtonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(Index<7)
                {
                    String message = mEditTextMessage.getText().toString();
                    if (TextUtils.isEmpty(message)) {
                        return;
                    }
                    sendMessage(message);
                    Index++;
                    mimicOtherMessage(Questions[Index]);
                    if(Index == 7)
                    {
                        mEditTextMessage.setFocusable(false);
                        mEditTextMessage.setEnabled(false);
                        mButtonSend.setImageDrawable(getResources().getDrawable( R.drawable.ic_camera));
                    }
                }
                else if(Index == 7)
                {
                    Index++;
                    dispatchTakePictureIntent();
                }
                mEditTextMessage.setText("");
                mListView.setSelection(mAdapter.getCount() - 1);
            }
        });
        mimicOtherMessage(Questions[Index]);
    }

    private void sendMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(null,message, true, false);
        mAdapter.add(chatMessage);

    }

    private void sendImage(Bitmap bitmap) {
        ChatMessage chatMessage = new ChatMessage(bitmap,null, true, true);
        mAdapter.add(chatMessage);

    }

    private void mimicOtherMessage(String message) {
        ChatMessage chatMessage = new ChatMessage(null,message, false, false);
        mAdapter.add(chatMessage);
    }

    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            sendImage(imageBitmap);
            mimicOtherMessage("Thank You");
        }
    }


}