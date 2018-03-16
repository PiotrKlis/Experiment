package com.piotrklis.experiment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;
    @BindView(R.id.buttonMain)
    Button button;
    @BindView(R.id.textView)
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                String result = data.getStringExtra("content");
                textView.setText(result);
            }
            if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
    }

    @OnClick({R.id.buttonMain})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.buttonMain:
                startActivityForResult(new Intent(this, SecondActivity.class), REQUEST_CODE);
                break;
        }
    }
}
