package test.vcnc.co.kr.architecture_test.core;

import android.app.Application;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;

import test.vcnc.co.kr.architecture_test.db.AppDatabase;

public class TestApplication extends Application {

    private static TestApplication testApplication;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();

        testApplication = this;
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "database-name")
                .addMigrations(MIGRATION_1_2)
                .build();
    }

    public static TestApplication getTestApplication() {
        return testApplication;
    }

    public AppDatabase getDatabase() {
        return database;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
        }
    };
}
