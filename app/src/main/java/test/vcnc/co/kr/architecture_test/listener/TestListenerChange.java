package test.vcnc.co.kr.architecture_test.listener;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

public class TestListenerChange implements LifecycleObserver {

    private TestCallback testCallback;
    private Lifecycle lifecycle;

    public TestListenerChange(Lifecycle lifecycle, TestCallback callback) {
        lifecycle.addObserver(this);
        this.lifecycle = lifecycle;
        this.testCallback = callback;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
        // start Event
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void pause() {
        // pause Event
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void clean() {
        lifecycle.removeObserver(this);
    }

    public interface TestCallback {
        void show(String state);
    }

}
