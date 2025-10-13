package be.iramps.ue1103.Helper;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.ANNOTATION_TYPE,ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface GeneratedIgnoreJacoco {
}