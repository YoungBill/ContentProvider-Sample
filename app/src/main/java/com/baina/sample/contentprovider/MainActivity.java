package com.baina.sample.contentprovider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.baina.sample.contentprovider.entity.Book;
import com.baina.sample.contentprovider.greendao.BookDao;

import java.util.List;
import java.util.Random;

import static com.baina.sample.contentprovider.Constants.KEY_SP;

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
                String sharedName = getPackageName() + "_preferences";
                SharedPreferences sharedPreferences = getSharedPreferences(sharedName, MODE_PRIVATE);
                sharedPreferences.edit().putString(KEY_SP, "这是内容").apply();
                break;
            case R.id.testCP:
                startActivity(new Intent(MainActivity.this, TestCPActivity.class));
                BookDao bookDao = DBManager.getBookDao();
                Book book = new Book();
                Random random = new Random();
                book.setCategory("开发" + random.nextInt(5));
                book.setBookName("PHP");
                bookDao.insert(book);
                List<Book> bookList = bookDao.queryBuilder().list();
                String str = "";
                for (Book book1 : bookList) {
                    str += "类别: " + book1.getCategory() + " 书名: " + book1.getBookName() + "\n";
                }
                Toast.makeText(MainActivity.this, "数据库里有:" + bookList.size() + "本书.分别是:\n" + str, Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
