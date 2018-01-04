package com.sample.touch.event;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.outer_view_group)
    OuterViewGroup outerViewGroup;

    @BindView(R.id.inner_view_group)
    InnerViewGroup innerViewGroup;

    @BindView(R.id.view)
    InnerView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @SuppressWarnings("unused")
    @OnCheckedChanged({
            // Outer View Group
            R.id.outer_view_group_interception_true,
            R.id.outer_view_group_interception_false,
            R.id.outer_view_group_interception_super,

            R.id.outer_view_group_dispatch_event_true,
            R.id.outer_view_group_dispatch_event_false,
            R.id.outer_view_group_dispatch_event_super,

            R.id.outer_view_group_on_touch_true,
            R.id.outer_view_group_on_touch_false,
            R.id.outer_view_group_on_touch_super,

            // Inner View Group
            R.id.inner_view_group_interception_true,
            R.id.inner_view_group_interception_false,
            R.id.inner_view_group_interception_super,

            R.id.inner_view_group_dispatch_event_true,
            R.id.inner_view_group_dispatch_event_false,
            R.id.inner_view_group_dispatch_event_super,

            R.id.inner_view_group_on_touch_true,
            R.id.inner_view_group_on_touch_false,
            R.id.inner_view_group_on_touch_super,

            // View
            R.id.view_dispatch_event_true,
            R.id.view_dispatch_event_false,
            R.id.view_dispatch_event_super,

            R.id.view_on_touch_true,
            R.id.view_on_touch_false,
            R.id.view_on_touch_super,
    })
    public void onCheckedChanged(RadioButton radioButton, boolean isChecked) {
        if (!isChecked)
            return;

        int id = radioButton.getId();
        switch (id) {
            case R.id.outer_view_group_interception_true:
                outerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.outer_view_group_interception_false:
                outerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.outer_view_group_interception_super:
                outerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.SUPER);
                break;
            case R.id.outer_view_group_on_touch_true:
                outerViewGroup.setOnTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.outer_view_group_on_touch_false:
                outerViewGroup.setOnTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.outer_view_group_on_touch_super:
                outerViewGroup.setOnTouchEventReturnValue(ReturnValue.SUPER);
                break;
            case R.id.outer_view_group_dispatch_event_true:
                outerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.outer_view_group_dispatch_event_false:
                outerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.outer_view_group_dispatch_event_super:
                outerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.SUPER);
                break;

            // InnerViewGroup
            case R.id.inner_view_group_interception_true:
                innerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.inner_view_group_interception_false:
                innerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.inner_view_group_interception_super:
                innerViewGroup.setOnInterceptTouchEventReturnValue(ReturnValue.SUPER);
                break;
            case R.id.inner_view_group_on_touch_true:
                innerViewGroup.setOnTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.inner_view_group_on_touch_false:
                innerViewGroup.setOnTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.inner_view_group_on_touch_super:
                innerViewGroup.setOnTouchEventReturnValue(ReturnValue.SUPER);
                break;
            case R.id.inner_view_group_dispatch_event_true:
                innerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.inner_view_group_dispatch_event_false:
                innerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.inner_view_group_dispatch_event_super:
                innerViewGroup.setDispatchTouchEventReturnValue(ReturnValue.SUPER);
                break;

            // View
            case R.id.view_on_touch_true:
                view.setOnTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.view_on_touch_false:
                view.setOnTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.view_on_touch_super:
                view.setOnTouchEventReturnValue(ReturnValue.SUPER);
                break;
            case R.id.view_dispatch_event_true:
                view.setDispatchTouchEventReturnValue(ReturnValue.TRUE);
                break;
            case R.id.view_dispatch_event_false:
                view.setDispatchTouchEventReturnValue(ReturnValue.FALSE);
                break;
            case R.id.view_dispatch_event_super:
                view.setDispatchTouchEventReturnValue(ReturnValue.SUPER);
                break;
        }
    }
}
