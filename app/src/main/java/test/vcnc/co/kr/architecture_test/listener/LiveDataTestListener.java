package test.vcnc.co.kr.architecture_test.listener;

import android.arch.lifecycle.LiveData;

/**
 * Created by plaz on 2017-06-22.
 */

public class LiveDataTestListener extends LiveData<String> {
    @Override
    protected void onActive() {
        super.onActive();
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }
}
