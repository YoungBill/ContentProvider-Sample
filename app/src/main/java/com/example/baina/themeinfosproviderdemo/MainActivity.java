package com.example.baina.themeinfosproviderdemo;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String CONTENT_AUTHORITY = "com.cyou.privacy.themeprovider";
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
    public static final String PATH_THEMESINFO = "THEMES_INFOS";
    public static final Uri CONTENT_URI = BASE_CONTENT_URI.buildUpon().appendPath(PATH_THEMESINFO).build();

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "Uri:" + CONTENT_URI.toString());
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            Cursor cursor = getContentResolver().query(CONTENT_URI, null, null, null, null);
            if (cursor != null) {
                while (cursor.moveToNext()) {
                    Log.d(TAG, "主题id: " + cursor.getString(0) +
                            "主题更新时间: " + cursor.getLong(1) +
                            "主题包名: " + cursor.getString(7) +
                            "主题名字: " + cursor.getString(8) +
                            "主题封面: " + cursor.getString(10)
                    );
                }
                cursor.close();
            }
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }
}
