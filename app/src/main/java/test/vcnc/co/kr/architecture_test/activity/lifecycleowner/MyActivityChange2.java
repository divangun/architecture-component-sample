package test.vcnc.co.kr.architecture_test.activity.lifecycleowner;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import test.vcnc.co.kr.architecture_test.R;
import test.vcnc.co.kr.architecture_test.listener.TestListenerChange;
import test.vcnc.co.kr.architecture_test.utils.Utils;

public class MyActivityChange2 extends LifecycleActivity {

    private TestListenerChange testListener;

    @Override
    protected void onStart() {
        super.onStart();

        Utils.checkUserStatus(state -> {
            if (state.equals("OK") && getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
                testListener.start();
            }
        });
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        testListener = new TestListenerChange(getLifecycle(), state -> {
            // update UI
        });
    }
}

