package com.sample.touch.event;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

class InnerView extends android.support.v7.widget.AppCompatTextView {

    private static final String TAG = "InnerView:::::";

    public InnerView(Context context) {
        super(context);
    }

    public InnerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
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
