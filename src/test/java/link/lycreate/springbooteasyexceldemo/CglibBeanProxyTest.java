package link.lycreate.springbooteasyexceldemo;

import link.lycreate.springbooteasyexceldemo.service.impl.CglibBean;
import link.lycreate.springbooteasyexceldemo.service.proxy.CglibBeanProxy;

/**
 * @ClassName CglibBeanProxyTest
 * @Description TODO Cglib动态代理测试类$
 * @Author charlesYan
 * @Date 2020/9/30 14:51
 * @Version 1.0
 **/
public class CglibBeanProxyTest {

    public static void main(String[] args) {
        System.out.println("证明执行代理方法...");
        CglibBean cglibBean = new CglibBean("李四");
        CglibBeanProxy cglibBeanProxy = new CglibBeanProxy();
        CglibBean newCglibBean = (CglibBean)cglibBeanProxy.createProxyObject(cglibBean);
        newCglibBean.doWork();

    }
}
