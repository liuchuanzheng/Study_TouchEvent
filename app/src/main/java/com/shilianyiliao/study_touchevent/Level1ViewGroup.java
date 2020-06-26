package com.shilianyiliao.study_touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Level1ViewGroup extends RelativeLayout{
    String TAG = "Level1ViewGroup";
    public Level1ViewGroup(Context context) {
        super(context);
    }

    public Level1ViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
//        this.setOnTouchListener(new OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG,"onTouch              -" + ParseEventStr.parseEventStr(event.getAction()));
//                return false;//默认不消费,由系统往下分发
////                return true;//消费.不分发了
//            }
//        });
//        this.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //有个click其实就是默认有消费了,后续事件默认会走到此view,在up事件时回调此方法
//                //但是click事件是先看孩子的.孩子有先.孩子设置了click,父亲相当于没设
//                Log.e(TAG,"onClick              -");
//            }
//        });
    }



    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent   -" + ParseEventStr.parseEventStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);//由系统往下分发
//        return true;//我消费,不分发
//        return false;//我不消费,不分发,上级想法办去
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"onInterceptTouchEvent-" + ParseEventStr.parseEventStr(ev.getAction()));
        return super.onInterceptTouchEvent(ev);//我不消费,继续由系统往下走
//        return true;//我消费,分发给我的onTouchEvent
//        return false;//我不消费,往下走
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent         -" + ParseEventStr.parseEventStr(event.getAction()));
        return super.onTouchEvent(event);//我不消费,由系统往上分发 .默认情况下只有孩子都不要,才会向上传到这
//        return true;//我消费,都别动了
//        return false;//我不消费,往上分发
    }

}