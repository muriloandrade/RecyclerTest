package com.example.murilo.recyclertest;

import android.content.Context;
import android.widget.TextView;

/**
 * Created by Murilo on 16/12/2014.
 */
public class MyCellView {

    private TextView mTextView;
    private int mSize;

    public MyCellView(Context context, int mSize)
    {
        this.mTextView = new TextView(context);
        this.mSize = mSize;
    }

    public String getText() {
        return mTextView.getText().toString();
    }

    public void setText(String text) {
        this.mTextView.setText(text);
    }

    public int getSize() {
        return mSize;
    }
}
