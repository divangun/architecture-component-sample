package test.vcnc.co.kr.architecture_test.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;
import android.database.Cursor;

import java.util.List;

import io.reactivex.Flowable;
import test.vcnc.co.kr.architecture_test.entity.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    List<User> getAll();

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE name LIKE :first LIMIT 1")
    User findByName(String first);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(User... users);

    @Delete
    void delete(User user);

    @Update
    void updateUser(User user);

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAllSync();

    @Query("SELECT * FROM user WHERE id = :userId")
    LiveData<User> fetchUser(String userId);

    @Query("SELECT * from user where id = :id LIMIT 1")
    Flowable<User> loadUserByIdRx(int id);

    @Query("SELECT * FROM user WHERE age > :minAge LIMIT 5")
    Cursor loadRawUsersOlderThan(int minAge);

}
