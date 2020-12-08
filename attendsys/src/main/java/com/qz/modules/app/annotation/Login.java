package com.qz.modules.app.annotation;

import java.lang.annotation.*;

//需要加token的注解
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
}
