package link.lycreate.springbooteasyexceldemo.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName LogAspect
 * @Description 日志切面类
 * @Author charlesYan
 * @Date 2020/10/9 12:53
 * @Version 1.0
 **/
@Aspect  // 声明是一个切面组件
@Component // 加入到IOC容器
@Slf4j  // 等同于 private final Logger logger = LoggerFactory.getLogger(XXX.class);
public class LogAspect {

    /**
     * @Author charlesYan
     * @Description // 指定切入点表达式，拦截那些方法，即为哪些类生成代理对象
     *      第一*表示匹配任何返回值的方法
     *      第二*表示匹配service包下的所有类
     *      第三*表示匹配类下的所有方法
     *      ..表示任何个数参数，和如何类型的参数
     **/
//    @Pointcut("execution(* link.lycreate.springbooteasyexceldemo.controller.*.*(..))")
    @Pointcut("@annotation(link.lycreate.springbooteasyexceldemo.aspect.LogFilter)")
    public void logPointCut(){}

    /**
     * @Author charlesYan
     * @Description //前置通知：在目标方法执行前调用
     **/
    @Before("logPointCut()")
    public void before(JoinPoint joinPoint){
        System.out.println("---------------Before Begin CurrentTime = " + System.currentTimeMillis());
        /*获取当前请求的HttpServletRequest*/
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();

        log.info("URL-->"+request.getRequestURL().toString());
        log.info("IP-->"+request.getRemoteAddr());
        log.info("HTTP_Method-->"+request.getMethod());
        log.info("Request_args-->"+ Arrays.toString(joinPoint.getArgs()));

        System.out.println("---------------Before End CurrentTime = " + System.currentTimeMillis());

    }

    /**
     * @Author charlesYan
     * @Description //返回通知 在目标方法执行后调用，若目标方法出现异常，则不执行
     **/
    @AfterReturning(value = "logPointCut()",returning = "obj")
    public void afterReturning(JoinPoint joinPoint,Object obj){
        System.out.println("---------------AfterReturn CurrentTime = " + System.currentTimeMillis());

    }

    /**
     * @Author charlesYan
     * @Description //后置通知：无论目标方法在执行过程中是否出现异常都会在它之后调用
     **/
    @After("logPointCut()")
    public void after(JoinPoint joinPoint){
        System.out.println("---------------After CurrentTime = " + System.currentTimeMillis());
    }

    /**
     * @Author charlesYan
     * @Description //异常通知：目标方法抛出异常时执行
     **/
    @AfterThrowing(value = "logPointCut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint,Exception ex){
        System.out.println("---------------AfterThrowing CurrentTime = " + System.currentTimeMillis());
    }

    /**
     * @Author charlesYan
     * @Description //环绕通知：是前面四个通知的结合体
     *         需要在方法之前执行，可以写在joinPoint.procedd();之前
     *         需要在方法之后执行，可以写在joinPoint.procedd();之后
     **/
    @Around("logPointCut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {

        // 获取目标方法的名称
        String methodName = joinPoint.getSignature().getName();
        // 获取方法传入参数
        Object[] params = joinPoint.getArgs();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        // 获取方法上LogFilter注解
        LogFilter logFilter = method.getAnnotation(LogFilter.class);
        String value = logFilter.value() ;
        log.info("模块描述:"+value);
        System.out.println("---------------Around Before CurrentTime = " + System.currentTimeMillis() + " method name：" + methodName + " args：" + params[0]);
        // 执行源方法
        joinPoint.proceed();
        System.out.println("---------------Around After CurrentTime = " + System.currentTimeMillis() + " method name：" + methodName + " args：" + params[0]);
        // 模拟进行验证
    }
}
