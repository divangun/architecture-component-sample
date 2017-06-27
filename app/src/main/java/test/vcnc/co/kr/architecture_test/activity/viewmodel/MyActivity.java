package test.vcnc.co.kr.architecture_test.activity.viewmodel;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;

import test.vcnc.co.kr.architecture_test.core.TestApplication;
import test.vcnc.co.kr.architecture_test.db.AppDatabase;
import test.vcnc.co.kr.architecture_test.entity.User;
import test.vcnc.co.kr.architecture_test.viewmodel.UserListViewModel;

public class MyActivity extends LifecycleActivity {

    LiveData<User> userData = new MutableLiveData<>();
    AppDatabase appDatabase = TestApplication.getTestApplication().getDatabase();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String userId = getIntent().getStringExtra("USER_ID");
        ViewModelProviders.of(this)
                .get(UserListViewModel.class)
                .getUser(userId)
                .observe(this, user -> {
                    //update UI
                });
    }
}
