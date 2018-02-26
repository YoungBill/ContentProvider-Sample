package com.baina.sample.contentprovider;

import android.app.Application;

/**
 * Created by baina on 18-2-26.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DBManager.init(this);
    }
}
