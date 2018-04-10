package com.deity.github.inject;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 上下文级别
 * Created by deity on 18-4-10.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationContext {
}
