package test.vcnc.co.kr.architecture_test.db;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import test.vcnc.co.kr.architecture_test.converter.Converters;
import test.vcnc.co.kr.architecture_test.entity.Book;
import test.vcnc.co.kr.architecture_test.entity.User;

@Database(entities = {User.class, Book.class}, version = 1)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    public abstract BookDao bookDao();

}
