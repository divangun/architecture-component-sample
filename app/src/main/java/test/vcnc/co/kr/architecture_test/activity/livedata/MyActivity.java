package test.vcnc.co.kr.architecture_test.activity.livedata;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.MutableLiveData;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class MyActivity extends LifecycleActivity{

    MutableLiveData<String> stateData = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        stateData.observe(this, result -> {
            // update UI
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        stateData.postValue("Start");
    }

    @Override
    protected void onStop() {
        super.onStop();
        stateData.setValue("Stop");
    }
}
