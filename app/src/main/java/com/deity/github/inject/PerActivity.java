package com.deity.github.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 自定义scope,provides和component同时使用会有单例的效果
 * Created by deity on 18-4-10.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
