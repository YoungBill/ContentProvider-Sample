package com.baina.sample.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by baina on 18-2-26.
 */

public class BookProvider extends ContentProvider {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final UriMatcher mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int BOOK_URI_CODE = 0;

    public static final Uri BOOK_CONTENT_URI = Uri.parse(Constants.SCHEME + Constants.AUTHORITY + "/" + Constants.BOOK);

    static {
        mUriMatcher.addURI(Constants.AUTHORITY, Constants.BOOK, BOOK_URI_CODE);
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        String tableName = getTableName(uri);
        if (TextUtils.isEmpty(tableName)) {
            throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        Log.d(TAG, "-------ContentProvider-------query " + tableName);
        return DBManager.getOpenHelper().getWritableDatabase().query(tableName, projection, selection, selectionArgs, null, null, sortOrder, null);
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    private String getTableName(Uri uri) {
        String tableName = null;
        switch (mUriMatcher.match(uri)) {
            case BOOK_URI_CODE:
                tableName = Constants.BOOK;
                break;
            default:
                break;
        }
        return tableName;
    }
}
