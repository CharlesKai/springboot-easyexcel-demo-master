package link.lycreate.springbooteasyexceldemo.aspect;

import java.lang.annotation.*;

/**
 * @ClassName LogFilter
 * @Description 自定义日志注解类$
 * @Author charlesYan
 * @Date 2020/10/11 17:59
 * @Version 1.0
 **/

@Target(ElementType.METHOD)//Target注解决定LogFilter注解可以加在哪些成分上，如加在类身上，或者属性身上，或者方法身上等成分
@Retention(RetentionPolicy.RUNTIME)//Retention注解括号中的"RetentionPolicy.RUNTIME"意思是让LogFilter这个注解的生命周期一直程序运行时都存在
@Documented
public @interface LogFilter {

    String value() default "";
}
