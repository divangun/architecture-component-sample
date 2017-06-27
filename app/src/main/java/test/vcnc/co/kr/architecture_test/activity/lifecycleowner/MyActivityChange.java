package test.vcnc.co.kr.architecture_test.activity.lifecycleowner;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import test.vcnc.co.kr.architecture_test.R;
import test.vcnc.co.kr.architecture_test.listener.TestListenerChange;
import test.vcnc.co.kr.architecture_test.utils.Utils;

public class MyActivityChange extends AppCompatActivity implements LifecycleRegistryOwner {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);

        TestListenerChange testListener = new TestListenerChange(getLifecycle(), state -> {
            // update Ui
        });
    }
}

