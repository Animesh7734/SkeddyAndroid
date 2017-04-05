package com.skeddy.android.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by will.davis on 4/4/17.
 */

public class GsonProvider {

    private static Gson _gson;

    private static void initialize() {
        GsonBuilder builder = new GsonBuilder();
        builder.addSerializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                if (f.getAnnotation(GsonIgnoreField.class) != null) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        builder.addDeserializationExclusionStrategy(new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                if (f.getAnnotation(GsonIgnoreField.class) != null) {
                    return true;
                }
                return false;
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        });
        _gson = builder.create();
    }

    public static Gson obtain() {
        if (_gson == null) {
            synchronized (GsonProvider.class) {
                if (_gson == null) {
                    initialize();
                }
            }
        }
        return _gson;
    }
}
