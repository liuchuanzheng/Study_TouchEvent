package com.shilianyiliao.study_touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class Level2ViewGroup extends RelativeLayout{
    String TAG = "Level2ViewGroup";
    public Level2ViewGroup(Context context) {
        super(context);
    }

    public Level2ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent   -" + ParseEventStr.parseEventStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"onInterceptTouchEvent-" + ParseEventStr.parseEventStr(ev.getAction()));
        return super.onInterceptTouchEvent(ev);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent         -" + ParseEventStr.parseEventStr(event.getAction()));
        return super.onTouchEvent(event);
    }


}