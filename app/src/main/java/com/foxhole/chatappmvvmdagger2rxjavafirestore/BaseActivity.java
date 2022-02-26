package com.foxhole.chatappmvvmdagger2rxjavafirestore;

import android.content.Context;

import androidx.multidex.MultiDex;

import com.foxhole.chatappmvvmdagger2rxjavafirestore.di.DaggerAppComponent;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

public class BaseActivity extends DaggerApplication {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

        FirebaseFirestoreSettings settings = new FirebaseFirestoreSettings.Builder()
                .setPersistenceEnabled(true)
                .setCacheSizeBytes(FirebaseFirestoreSettings.CACHE_SIZE_UNLIMITED)
                .build();
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }
}
