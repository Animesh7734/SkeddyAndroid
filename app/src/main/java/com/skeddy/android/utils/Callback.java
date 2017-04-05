package com.skeddy.android.utils;

import android.support.annotation.Nullable;

/**
 * Created by will.davis on 4/4/17.
 */

public interface Callback<T> {
    /**
     * @param data      - the data supplied; if any, may be nullCallback
     * @param exception - the exception raised; if any, may be null
     */
    void onCallback(@Nullable T data, @Nullable Exception exception);
}