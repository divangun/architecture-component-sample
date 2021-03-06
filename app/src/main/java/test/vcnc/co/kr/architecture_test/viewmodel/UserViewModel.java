package test.vcnc.co.kr.architecture_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import java.util.List;

import test.vcnc.co.kr.architecture_test.core.TestApplication;
import test.vcnc.co.kr.architecture_test.db.AppDatabase;
import test.vcnc.co.kr.architecture_test.entity.User;

public class UserViewModel extends AndroidViewModel{

    private MutableLiveData<List<User>> users;
    private AppDatabase database;

    private final String userId;

    public UserViewModel(Application application, String userId) {
        super(application);
        this.userId = userId;
        this.database = TestApplication.getTestApplication().getDatabase();
    }

    public LiveData<List<User>> getUsers(){
        return database.userDao().getAllSync();
    }

    public void insertUser(User user){
        database.userDao().insertAll(user);
    }
}
