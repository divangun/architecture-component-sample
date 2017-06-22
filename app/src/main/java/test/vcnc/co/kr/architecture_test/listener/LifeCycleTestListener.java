package test.vcnc.co.kr.architecture_test.listener;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class LifeCycleTestListener implements LifecycleObserver {

    private TestCallback testCallback;
    private Lifecycle lifecycle;

    public LifeCycleTestListener(Lifecycle lifecycle, TestCallback callback) {
        lifecycle.addObserver(this);
        this.lifecycle = lifecycle;
        this.testCallback = callback;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {

        lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    void pause() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    void clean() {
        lifecycle.removeObserver(this);
    }

    public interface TestCallback {
        void show(String state);
    }

}
