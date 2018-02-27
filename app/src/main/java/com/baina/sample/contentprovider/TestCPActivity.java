package com.baina.sample.contentprovider;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.baina.sample.contentprovider.entity.Book;

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
        TextView contentTv = findViewById(R.id.contentTv);

        String content = "";
        Uri bookUri = Constants.BOOK_CONTENT_URI;
        Cursor bookCursor = getContentResolver().query(bookUri, null, null, null, null);
        if (bookCursor != null) {
            while (bookCursor.moveToNext()) {
                Book book = new Book();
                book.setCategory(bookCursor.getString(1));
                book.setBookName(bookCursor.getString(2));
                content += "类别: " + book.getCategory() + " 书名: " + book.getBookName() + "\n";
                contentTv.setText(content);
            }
            bookCursor.close();
        }
    }
}
