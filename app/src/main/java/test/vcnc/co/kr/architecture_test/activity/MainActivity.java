package test.vcnc.co.kr.architecture_test.activity;

import android.arch.lifecycle.LifecycleActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.vcnc.co.kr.architecture_test.R;

public class MainActivity extends LifecycleActivity {

    @BindView(R.id.insert_button) Button insertButton;
    @BindView(R.id.user_button) Button loadButton;
    @BindView(R.id.life_cycle_button) Button lifeCycleButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        insertButton.setOnClickListener(v -> {
            startActivity(new Intent(this, InsertActivity.class));
        });

        lifeCycleButton.setOnClickListener(v -> {
            startActivity(new Intent(this, LifeCycleTestActivity.class));
        });

    }
}
