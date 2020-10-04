package link.lycreate.springbooteasyexceldemo.service.impl;

import link.lycreate.springbooteasyexceldemo.service.IEmailService;

/**
 * @ClassName EmailServiceImpl
 * @Description TODO 解析邮件实现接口类$
 * @Author charlesYan
 * @Date 2020/9/29 15:54
 * @Version 1.0
 **/
public class EmailServiceImpl implements IEmailService {

    private String account;

    public EmailServiceImpl() {
    }

    public EmailServiceImpl(String account) {
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Override
    public void sendEmail() {
        System.out.println(account + "：发送系统邮件...");
    }
}
