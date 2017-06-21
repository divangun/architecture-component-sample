package test.vcnc.co.kr.architecture_test;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import test.vcnc.co.kr.architecture_test.db.AppDatabase;

public class MainActivity extends LifecycleActivity {

    @BindView(R.id.insert_button) Button insertButton;
    @BindView(R.id.load_button) Button loadButton;
    @BindView(R.id.result_textview) TextView resultView;

    AppDatabase appDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "test").build();
    }
}
