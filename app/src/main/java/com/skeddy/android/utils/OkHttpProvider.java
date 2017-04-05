package com.skeddy.android.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by will.davis on 4/4/17.
 */

public class OkHttpProvider extends OkHttpClient {
    private static final String TAG = OkHttpProvider.class.getSimpleName();
    private static final long TIME_OUT_IN_SECONDS = 20;
    private static final boolean ALLOW_LOGGING = true;
    private static OkHttpProvider _instance = null;
    private final OkHttpClient mOkHttpClient;


    public static OkHttpProvider instance() {
        if (_instance == null) {
            synchronized (OkHttpProvider.class) {
                if (_instance == null) {
                    _instance = new OkHttpProvider();
                }
            }
        }
        return _instance;
    }

    private OkHttpProvider() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.readTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        builder.writeTimeout(TIME_OUT_IN_SECONDS, TimeUnit.SECONDS);
        // don't even attach our logging interceptor if not allowed
        // we do not generally want to log our web requests outside of dev/debug
        if (ALLOW_LOGGING) {
            HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.d(TAG, message);
                }
            };
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(logger);
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        mOkHttpClient = builder.build();
    }

    public OkHttpClient getOkHttpClient() {
        return mOkHttpClient;
    }

}
