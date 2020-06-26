package com.shilianyiliao.study_touchevent;

import android.view.MotionEvent;

public class ParseEventStr {

        public static String parseEventStr(int actionId) {
            String actionName = "";
            switch (actionId) {
                case MotionEvent.ACTION_DOWN:
                    actionName = "ACTION_DOWN";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionName = "ACTION_MOVE";
                    break;
                case MotionEvent.ACTION_UP:
                    actionName = "ACTION_UP";
                    break;
                case MotionEvent.ACTION_CANCEL:
                    actionName = "ACTION_CANCEL";
                    break;
                case MotionEvent.ACTION_OUTSIDE:
                    actionName = "ACTION_OUTSIDE";
                    break;
            }
            return actionName;
        }

    }