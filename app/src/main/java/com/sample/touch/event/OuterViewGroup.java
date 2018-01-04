package com.sample.touch.event;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.LinearLayout;


public class OuterViewGroup extends LinearLayout {

    private static final String TAG = "OuterViewGroup";

    public OuterViewGroup(Context context) {
        super(context);
    }

    public OuterViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private int onInterceptTouchEventReturnValue;

    public void setOnInterceptTouchEventReturnValue(int onInterceptTouchEventReturnValue) {
        this.onInterceptTouchEventReturnValue = onInterceptTouchEventReturnValue;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        String[] actions = {"ACTION_DOWN ", "ACTION_UP   ", "ACTION_MOVE ", "ACTION_CANCEL"};
        Log.e(TAG, actions[event.getAction()] + " onInterceptTouchEvent");

        switch (onInterceptTouchEventReturnValue) {
            case ReturnValue.TRUE:
                return true;
            case ReturnValue.FALSE:
                return false;
            case ReturnValue.SUPER:
                return super.onInterceptTouchEvent(event);
            default:
                throw new RuntimeException();
        }
    }

    private int onTouchEventReturnValue;

    public void setOnTouchEventReturnValue(int onTouchEventReturnValue) {
        this.onTouchEventReturnValue = onTouchEventReturnValue;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String[] actions = {"ACTION_DOWN ", "ACTION_UP   ", "ACTION_MOVE ", "ACTION_CANCEL"};
        Log.e(TAG, actions[event.getAction()] + "          onTouchEvent");

        switch (onTouchEventReturnValue) {
            case ReturnValue.TRUE:
                return true;
            case ReturnValue.FALSE:
                return false;
            case ReturnValue.SUPER:
                return super.onTouchEvent(event);
            default:
                throw new RuntimeException();
        }
    }

    private int dispatchTouchEventReturnValue;

    public void setDispatchTouchEventReturnValue(int returnValue) {
        dispatchTouchEventReturnValue = returnValue;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        String[] actions = {"ACTION_DOWN ", "ACTION_UP   ", "ACTION_MOVE ", "ACTION_CANCEL"};
        Log.e(TAG, actions[event.getAction()] + "    dispatchTouchEvent");

        if (ReturnValue.TRUE == dispatchTouchEventReturnValue)
            return true;
        else if (ReturnValue.FALSE == dispatchTouchEventReturnValue)
            return false;
        else
            return super.dispatchTouchEvent(event);
    }
}
