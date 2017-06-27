package test.vcnc.co.kr.architecture_test.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import test.vcnc.co.kr.architecture_test.core.TestApplication;
import test.vcnc.co.kr.architecture_test.db.AppDatabase;
import test.vcnc.co.kr.architecture_test.db.UserDao;
import test.vcnc.co.kr.architecture_test.entity.User;

public class UserListViewModel extends AndroidViewModel {

    private LiveData<List<User>> users;
    private LiveData<User> userLiveData;

    private AppDatabase database;
    private UserDao userRepository;

    public UserListViewModel(Application application) {
        super(application);
        this.database = TestApplication.getTestApplication().getDatabase();
        this.userRepository = database.userDao();
    }

    public LiveData<List<User>> getUsers() {
        return database.userDao().getAllSync();
    }

    public LiveData<User> getUser(String userId) {
        if (userLiveData == null) {
            userLiveData = userRepository.fetchUser(userId);
        }

        return userLiveData;
    }

    public void insertUser(User user) {
        Flowable.just(user).observeOn(Schedulers.io()).subscribe(user1 -> database.userDao().insertAll(user1));
    }
}
