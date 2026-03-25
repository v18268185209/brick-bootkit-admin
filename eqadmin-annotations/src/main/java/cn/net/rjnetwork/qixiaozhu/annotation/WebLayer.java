package cn.net.rjnetwork.qixiaozhu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares web-layer metadata used by permission, menu and audit systems.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface WebLayer {

    String name() default "";

    String code() default "";

    LayerType type() default LayerType.API;

    String parentCode() default "";

    String icon() default "";

    int order() default 0;

    String description() default "";

    boolean logEnabled() default true;

    boolean dataPermissionEnabled() default true;

    boolean cacheEnabled() default false;

    int cacheSeconds() default 60;

    enum LayerType {
        MENU,
        BUTTON,
        API,
        PAGE
    }
}
