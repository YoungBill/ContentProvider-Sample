package com.baina.sample.contentprovider;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.testSP:
                startActivity(new Intent(MainActivity.this, TestSPActivity.class));
                break;
            case R.id.testCP:
                startActivity(new Intent(MainActivity.this, TestCPActivity.class));
                break;
        }
    }
}
