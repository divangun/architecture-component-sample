package test.vcnc.co.kr.architecture_test.activity.viewmodel;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.vcnc.co.kr.architecture_test.R;
import test.vcnc.co.kr.architecture_test.entity.User;
import test.vcnc.co.kr.architecture_test.viewmodel.UserListViewModel;
import test.vcnc.co.kr.architecture_test.viewmodel.UserViewModel;

public class InsertActivity extends LifecycleActivity {

    @BindView(R.id.insert_button) Button insertButton;
    @BindView(R.id.load_button) Button loadButton;
    @BindView(R.id.input_text) EditText inputText;
    @BindView(R.id.result_textview) TextView resultTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert_activity);
        ButterKnife.bind(this);

        final UserListViewModel viewModel = ViewModelProviders.of(this).get(UserListViewModel.class);
        subscribeUi(viewModel);

        insertButton.setOnClickListener(v -> {
            User user = new User();
            user.setName(inputText.getText().toString());
            user.setCreatedTime(System.currentTimeMillis());
            viewModel.insertUser(user);
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    private void subscribeUi(UserListViewModel viewModel) {
        // Update the list when the data changes

        viewModel.getUsers().observe(this, users -> {
            if(users != null){
                resultTextView.setText("User Count : " + users.size());
            }
        });
    }
}
