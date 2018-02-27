package com.baina.sample.contentprovider;

import android.net.Uri;

/**
 * Created by baina on 18-2-26.
 */

public class Constants {

    public static final String KEY_SP = "key_sp";

    /**
     * ContentProvider格式
     * |------Scheme------|-----------------Authority-------------------|---资源路径---|---ID--|
     */
    public static final String SCHEME = "content://";
    public static final String AUTHORITY = "com.baina.sample.contentprovider";
    public static final String BOOK = "BOOK";
    public static final int BOOK_URI_CODE = 0;
    public static final Uri BOOK_CONTENT_URI = Uri.parse(SCHEME + AUTHORITY + "/" + BOOK);
}
