package com.skeddy.android.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by will.davis on 12/19/16.
 * <p>
 * This will tell a gson instance obtained via {@link GsonProvider#obtain()} to ignore this field for serialization and deserialization
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface GsonIgnoreField {}
