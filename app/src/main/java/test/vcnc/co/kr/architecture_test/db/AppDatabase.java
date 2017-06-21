package test.vcnc.co.kr.architecture_test.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import test.vcnc.co.kr.architecture_test.entity.User;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
