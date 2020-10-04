package link.lycreate.springbooteasyexceldemo.service.impl;

/**
 * @ClassName CglibBean
 * @Description TODO 原始类$
 * @Author charlesYan
 * @Date 2020/9/30 14:33
 * @Version 1.0
 **/
public class CglibBean {

    private String name;

    public CglibBean() {
    }

    public CglibBean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doWork(){
        System.out.println(name + "在努力工作...");
    }
}
