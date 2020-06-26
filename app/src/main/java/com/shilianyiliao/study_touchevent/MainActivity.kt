package com.shilianyiliao.study_touchevent

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity

/**
    super的意思是默认u型从上往下再往上走位
    true的意思是明确我消费了.以后明确走位到我这就可以了
    false的意思是明确我不消费,以后别往我这走位了,往回走吧

 1   public boolean dispatchTouchEvent(MotionEvent ev) 事件分发(如何分发,3种)
    return super.dispatchTouchEvent(ev)，(由系统默认往下分发)默认事件会自动的分发给当前 View 的 onInterceptTouchEvent 方法；
    return true，(我消费,不分发)事件会分发给当前 View 并由 dispatchTouchEvent 方法进行消费，同时事件会停止向下传递；
    return false，(我不消费,不分发,上级想法办去)会将事件返回给父的 onTouchEvent 进行消费；

  2  public boolean onInterceptTouchEvent(MotionEvent ev) 事件拦截
    return super.onInterceptTouchEvent(ev)，默认情况下会将事件进行拦截，并将拦截到的事件交由当前 View 的 onTouchEvent 进行处理；
    return true，同return super.onInterceptTouchEvent(ev)；
    return false，表示不拦截当前事件，当前 View 上的事件会被传递到子 View 上，再由子 View 的 dispatchTouchEvent 来开始这个事件的分发；

  3  setOnTouchListener onTouch

  4  public boolean onTouchEvent(MotionEvent event) 事件消费
    return super.onTouchEvent(ev)，默认将事件传递到上层View进行处理，如果上层也return false，则该事件消失；
    return true，会消费当前事件；
    return false，同return super.onTouchEvent(ev)；

  5  setOnClickListener onClick

    MainActivity -> Level1ViewGroup -> Level2ViewGroup ->Level3View
    1 默认都是super时
    E/MainActivity---: dispatchTouchEvent   -ACTION_DOWN
    E/Level1ViewGroup: dispatchTouchEvent   -ACTION_DOWN
    E/Level1ViewGroup: onInterceptTouchEvent-ACTION_DOWN
    E/Level2ViewGroup: dispatchTouchEvent   -ACTION_DOWN
    E/Level2ViewGroup: onInterceptTouchEvent-ACTION_DOWN
    E/Level3View-----: dispatchTouchEvent   -ACTION_DOWN
    E/Level3View-----: onTouchEvent         -ACTION_DOWN
    E/Level2ViewGroup: onTouchEvent         -ACTION_DOWN
    E/Level1ViewGroup: onTouchEvent         -ACTION_DOWN
    E/MainActivity---: onTouchEvent         -ACTION_DOWN
    E/MainActivity---: dispatchTouchEvent   -ACTION_MOVE
    E/MainActivity---: onTouchEvent         -ACTION_MOVE
    E/MainActivity---: dispatchTouchEvent   -ACTION_MOVE
    E/MainActivity---: onTouchEvent         -ACTION_MOVE
    E/MainActivity---: dispatchTouchEvent   -ACTION_UP
    E/MainActivity---: onTouchEvent         -ACTION_UP

    也就是说在down事件时系统会先从上到下过一遍,问问到底谁要这次事件,然而默认是所有的viewgroup和所有view
    都不要.就自己消费了这个down事件.后续的move和up等事件就没必要再问一遍孩子了,自己处理就好了.其实自己也
    没处理啥,只是把事件过了一下



 */


class MainActivity : AppCompatActivity() {
    var TAG = "MainActivity---"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun dispatchTouchEvent(ev: MotionEvent): Boolean {
        Log.e(TAG, "dispatchTouchEvent   -" + ParseEventStr.parseEventStr(ev.getAction()))
        return super.dispatchTouchEvent(ev) //分发往下走
//        return true //直接消费.连自己的onTouchEvent都不回调
//        return false //直接不消费.但也不分发
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        Log.e(TAG, "onTouchEvent         -" + ParseEventStr.parseEventStr(event.getAction()))
        return super.onTouchEvent(event)
    }
}