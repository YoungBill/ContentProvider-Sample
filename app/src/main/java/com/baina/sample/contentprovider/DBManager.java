package com.baina.sample.contentprovider;

import android.content.Context;

import com.baina.sample.contentprovider.greendao.BookDao;
import com.baina.sample.contentprovider.greendao.DaoMaster;
import com.baina.sample.contentprovider.greendao.DaoSession;

/**
 * Created by baina on 18-2-26.
 * 数据库操作类
 */

public class DBManager {

    private static final String DBNAME = "test_db";

    private static DaoMaster.DevOpenHelper mOpenHelper;
    private static DaoMaster mDaoMaster;
    private static DaoSession mDaoSession;
    private static BookDao mBookDao;

    public static void init(Context context) {
        mOpenHelper = new DaoMaster.DevOpenHelper(context, DBNAME, null);
    }

    /**
     * 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
     * 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
     * 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
     * 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
     *
     * @return
     */
    //
    public static BookDao getBookDao() {
        if (mDaoMaster == null)
            mDaoMaster = new DaoMaster(mOpenHelper.getWritableDatabase());
        if (mDaoSession == null)
            mDaoSession = mDaoMaster.newSession();
        if (mBookDao == null)
            mBookDao = mDaoSession.getBookDao();
        return mBookDao;
    }
}
