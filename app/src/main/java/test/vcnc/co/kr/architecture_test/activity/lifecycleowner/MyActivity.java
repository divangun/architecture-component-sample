package test.vcnc.co.kr.architecture_test.activity.lifecycleowner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import test.vcnc.co.kr.architecture_test.listener.TestListener;

public class MyActivity extends AppCompatActivity {

    private TestListener testListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        testListener = new TestListener();
    }

    @Override
    protected void onStart() {
        super.onStart();
        testListener.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        testListener.start();
    }
}
