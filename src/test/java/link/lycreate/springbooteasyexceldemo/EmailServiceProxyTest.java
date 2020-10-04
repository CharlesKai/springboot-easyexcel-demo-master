package link.lycreate.springbooteasyexceldemo;

import link.lycreate.springbooteasyexceldemo.service.IEmailService;
import link.lycreate.springbooteasyexceldemo.service.impl.EmailServiceImpl;
import link.lycreate.springbooteasyexceldemo.service.proxy.EmailServiceProxy;

import java.lang.reflect.Proxy;

/**
 * @ClassName EmailServiceProxyTest
 * @Description TODO 邮件接口代理测试类$
 * @Author charlesYan
 * @Date 2020/9/30 11:19
 * @Version 1.0
 **/
public class EmailServiceProxyTest {

    public static void main(String[] args) {

        System.out.println("证明执行代理方法...");
        EmailServiceImpl emailService = new EmailServiceImpl("张三");
        EmailServiceProxy emailServiceProxy = new EmailServiceProxy(emailService);
        //生成代理对象
        IEmailService proxyObject = (IEmailService) Proxy.newProxyInstance(emailService.getClass().getClassLoader(),
                emailService.getClass().getInterfaces(),
                emailServiceProxy);
        proxyObject.sendEmail();

        System.out.println("证明不执行代理方法...");
        EmailServiceImpl service = new EmailServiceImpl();
        EmailServiceProxy serviceProxy = new EmailServiceProxy(service);
        // 生成代理对象
        IEmailService proxyInstance = (IEmailService) Proxy.newProxyInstance(service.getClass().getClassLoader(), service.getClass().getInterfaces(), serviceProxy);
        proxyInstance.sendEmail();


    }
}
