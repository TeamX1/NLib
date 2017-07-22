package com.nufflee.nlib.mod.loader;

import com.nufflee.nlib.enums.LoaderType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Loader {
    LoaderType type();
}
