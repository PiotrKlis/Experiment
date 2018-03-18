package com.piotrklis.experiment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.piotrklis.experiment.util.IntentUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    private static final String SAVED_INSTANCE_CONSTANT = "SavedInstanceConstant";
    @BindView(R.id.buttonMain)
    Button buttonActivityForResult;
    @BindView(R.id.changableTextView)
    TextView changeableTextView;
    @BindView(R.id.buttonRx)
    Button buttonRx;

    String saveInstanceContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (savedInstanceState != null) {
            saveInstanceContent = savedInstanceState.getString(SAVED_INSTANCE_CONSTANT);
            setChangableTextView(saveInstanceContent);
        } else {
            saveInstanceContent = getString(R.string.main_changable_textview);
            setChangableTextView(saveInstanceContent);
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(SAVED_INSTANCE_CONSTANT, saveInstanceContent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra(IntentUtil.CONTENT);
                saveInstanceContent = result;
                setChangableTextView(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

    @OnClick({R.id.buttonMain, R.id.buttonRx})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonMain:
                startActivityForResult(new Intent(this, SecondActivity.class), REQUEST_CODE);
                break;
            case R.id.buttonRx:
                startActivity(new Intent(this, RxActivity.class));
        }
    }

    private void setChangableTextView(String content) {
        changeableTextView.setText(content);
    }
}
