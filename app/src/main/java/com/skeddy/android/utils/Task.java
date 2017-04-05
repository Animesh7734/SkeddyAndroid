package com.skeddy.android.utils;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by will.davis on 4/4/17.
 */

public class Task<T> extends AsyncTask<Object, Void, T> {

    private final Callback<T> mCallback;
    private final RunInBackground<T> mRunInBackground;
    protected Exception mException;

    /**
     * @param runInBackground
     * @param callback
     */
    public Task(@NonNull RunInBackground<T> runInBackground, @Nullable Callback<T> callback) {
        this.mCallback = callback;
        this.mRunInBackground = runInBackground;
    }

    @Override
    protected T doInBackground(Object... params) {
        try {
            return mRunInBackground.runInBackground();
        } catch (Exception e) {
            e.printStackTrace();
            this.mException = e;
            return null;
        }
    }

    @Override
    protected void onPostExecute(T data) {
        super.onPostExecute(data);
        if (!isCancelled() && mCallback != null) {
            mCallback.onCallback(data, mException);
        }
    }

    public interface RunInBackground<T> {
        T runInBackground() throws Exception;
    }

    public void execute() {
        super.execute();
    }

}
