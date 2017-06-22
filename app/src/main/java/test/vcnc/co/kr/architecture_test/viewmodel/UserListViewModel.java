package test.vcnc.co.kr.architecture_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import test.vcnc.co.kr.architecture_test.core.TestApplication;
import test.vcnc.co.kr.architecture_test.db.AppDatabase;
import test.vcnc.co.kr.architecture_test.entity.User;

public class UserListViewModel extends AndroidViewModel{

    private MutableLiveData<List<User>> users;
    private AppDatabase database;

    public UserListViewModel(Application application) {
        super(application);
        this.database = TestApplication.getTestApplication().getDatabase();
    }

    public LiveData<List<User>> getUsers(){
        return database.userDao().getAllSync();
    }

    public void insertUser(User user){
        Flowable.just(user).observeOn(Schedulers.io()).subscribe(user1 -> database.userDao().insertAll(user1));
    }
}
