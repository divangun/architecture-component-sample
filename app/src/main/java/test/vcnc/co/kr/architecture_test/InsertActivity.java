package test.vcnc.co.kr.architecture_test;

import android.arch.lifecycle.LifecycleActivity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;

public class InsertActivity extends LifecycleActivity {

    @BindView(R.id.insert_button) Button insertButton;
    @BindView(R.id.load_button) Button loadButton;
    @BindView(R.id.result_textview) TextView resultView;
    @BindView(R.id.input_text) EditText inputText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
    }
}
