package com.piotrklis.experiment;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.buttonConfirmEditText)
    Button button;
    @BindView(R.id.editText)
    EditText editText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.buttonConfirmEditText})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonConfirmEditText:
                String content = editText.getText().toString();
                Intent intent = prepareIntent(content);
                setResult(Activity.RESULT_OK, intent);
                finish();
                break;
        }
    }

    @NonNull
    private Intent prepareIntent(String content) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("content", content);
        return intent;
    }
}
