package test.vcnc.co.kr.architecture_test.listener;

import android.arch.lifecycle.MutableLiveData;

public class StateChangeListener extends MutableLiveData<String> {
    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
