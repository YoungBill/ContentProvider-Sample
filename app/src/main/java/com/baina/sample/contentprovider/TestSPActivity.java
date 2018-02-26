package com.baina.sample.contentprovider;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import static com.baina.sample.contentprovider.Constants.KEY_SP;

/**
 * Created by baina on 18-2-26.
 * 测试SharedPreferences数据
 */

public class TestSPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_test);
    }

    @Override
    protected void onResume() {
        super.onResume();
        /**
         * 由于SP本质上并不是多进程安全的，所以还是无法保证数据的同步，因此该方法并没有使用，也不推荐使用。
         */
        String sharedName = getPackageName() + "_preferences";
        SharedPreferences sharedPreferences = getSharedPreferences(sharedName, MODE_PRIVATE);
        TextView contentTv = findViewById(R.id.contentTv);
        contentTv.setText(sharedPreferences.getString(KEY_SP, ""));
    }
}
