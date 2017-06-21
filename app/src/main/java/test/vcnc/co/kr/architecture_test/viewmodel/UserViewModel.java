package test.vcnc.co.kr.architecture_test.viewmodel;

import android.arch.lifecycle.LiveData;

import test.vcnc.co.kr.architecture_test.db.AppDatabase;

public class UserViewModel {

    private LiveData<String> mLoansResult;

    private AppDatabase mDb;

}
