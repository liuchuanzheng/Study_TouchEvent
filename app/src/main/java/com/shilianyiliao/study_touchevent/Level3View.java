package com.shilianyiliao.study_touchevent;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;

public class Level3View extends View {
    String TAG = "Level3View-----";
    public Level3View(Context context) {
        super(context);
    }

    public Level3View(Context context, AttributeSet attrs) {
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
//                Log.e(TAG,"onClick              -");
//            }
//        });
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"dispatchTouchEvent   -" + ParseEventStr.parseEventStr(ev.getAction()));
        return super.dispatchTouchEvent(ev);//我不消费,由系统分发给我的onTouchEvent
//        return true;//我消费,不分发了
//        return false;//我不消费,往上分发
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.e(TAG,"onTouchEvent         -" + ParseEventStr.parseEventStr(event.getAction()));
        // 让父类不要拦截该view的事件
        // 这句话的在父控件是scrollview这种标准写法时才生效.因为他们根本就没拦截事件
        // 而是跟孩子商量是否拦截.所以这句话能调用生效.
//        getParent().requestDisallowInterceptTouchEvent(true);
        return super.onTouchEvent(event);//我不消费,由系统往上分发
//        return true;//我消费,不分发了
//        return false;//我不消费,由系统往上分发
    }

}