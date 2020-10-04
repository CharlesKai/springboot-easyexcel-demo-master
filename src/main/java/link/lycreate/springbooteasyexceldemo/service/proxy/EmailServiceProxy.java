package link.lycreate.springbooteasyexceldemo.service.proxy;

import link.lycreate.springbooteasyexceldemo.service.impl.EmailServiceImpl;
import org.springframework.util.StringUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName EmailServiceProxy
 * @Description TODO 邮件类代理对象$
 * @Author charlesYan
 * @Date 2020/9/29 18:36
 * @Version 1.0
 **/
public class EmailServiceProxy implements InvocationHandler {

    private Object targetObject;

    public EmailServiceProxy(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        EmailServiceImpl emailService = (EmailServiceImpl) this.targetObject;
        String account = emailService.getAccount();
        Object result = null;
        // 校验账户不为空则执行代理方法
        if (!StringUtils.isEmpty(account)) {
            result = method.invoke(targetObject,args);
            System.out.println("执行代理对象方法...");
        }
        return result;
    }
}
