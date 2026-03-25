package cn.net.rjnetwork.qixiaozhu.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Declares license-gated capabilities on controller or service methods.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LicenseFeature {

    String[] value() default {};

    boolean anyMatch() default false;

    boolean requireAllowed() default true;

    String message() default "";
}
