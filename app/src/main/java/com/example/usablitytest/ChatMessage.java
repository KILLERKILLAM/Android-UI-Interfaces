package com.example.usablitytest;

import android.graphics.Bitmap;

public class ChatMessage {
    private boolean isImage, isMine;
    private String content;
    private Bitmap bitmap;

    public ChatMessage(Bitmap bitmap ,String message, boolean mine, boolean image) {
        this.bitmap = bitmap;
        content = message;
        isMine = mine;
        isImage = image;
    }

    public String getContent() {
        return content;
    }
    public  Bitmap getImage(){return bitmap; }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setIsMine(boolean isMine) {
        this.isMine = isMine;
    }

    public boolean isImage() {
        return isImage;
    }

    public void setIsImage(boolean isImage) {
        this.isImage = isImage;
    }
}
