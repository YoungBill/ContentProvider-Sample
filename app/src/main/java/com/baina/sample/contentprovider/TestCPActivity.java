package com.baina.sample.contentprovider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by baina on 18-2-26.
 * 测试 ContentProvider数据
 * 参考 https://www.cnblogs.com/whoislcj/p/5651396.html
 */

public class TestCPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cp_test);
    }
}
