package spring.aspect;


import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target( {ElementType.PARAMETER, ElementType.METHOD} )
@Retention( RetentionPolicy.RUNTIME )
@Documented
public @interface Perms {
    int read = 4;
    int write = 2;
    int delete = 1;

    int[] value() default 4;
}
