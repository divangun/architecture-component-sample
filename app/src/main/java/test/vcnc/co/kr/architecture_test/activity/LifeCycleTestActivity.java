package test.vcnc.co.kr.architecture_test.activity;

import android.arch.lifecycle.LifecycleRegistry;
import android.arch.lifecycle.LifecycleRegistryOwner;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import test.vcnc.co.kr.architecture_test.R;
import test.vcnc.co.kr.architecture_test.listener.LifeCycleTestListener;
import test.vcnc.co.kr.architecture_test.viewmodel.LifecycleViewModel;

public class LifeCycleTestActivity extends AppCompatActivity implements LifecycleRegistryOwner {

    private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);

    @Override
    public LifecycleRegistry getLifecycle() {
        return lifecycleRegistry;
    }

    @BindView(R.id.result_text) TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        ButterKnife.bind(this);

        final LifecycleViewModel viewModel = ViewModelProviders.of(this).get(LifecycleViewModel.class);
        subscribeUi(viewModel);

        LifeCycleTestListener testListener = new LifeCycleTestListener(getLifecycle(), state -> viewModel.addState(state));
    }

    private void subscribeUi(LifecycleViewModel viewModel) {
        // Update the list when the data changes
        viewModel.getStateString().observe(this, result -> {
            textView.setText(result);
        });
    }

}

