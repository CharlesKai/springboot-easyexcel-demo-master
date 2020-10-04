package link.lycreate.springbooteasyexceldemo.service.proxy;

import link.lycreate.springbooteasyexceldemo.service.impl.CglibBean;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @ClassName CglibBeanProxy
 * @Description TODO 代理类$
 * @Author charlesYan
 * @Date 2020/9/30 14:36
 * @Version 1.0
 **/
public class CglibBeanProxy implements MethodInterceptor{

    private Object targetObject;

    public Object createProxyObject(Object targetObject){
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        CglibBean cglibBean = (CglibBean) this.targetObject;
        String name = cglibBean.getName();
        Object result = null;
        if (!StringUtils.isEmpty(name)) {
            result = method.invoke(targetObject,objects);
            System.out.println("执行代理方法...");
        }

        return result;
    }
}
