package com.spider.admur13assignment6;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by spider on 11/10/17.
 */

public class Admur13Assignment6 extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
    }
}
