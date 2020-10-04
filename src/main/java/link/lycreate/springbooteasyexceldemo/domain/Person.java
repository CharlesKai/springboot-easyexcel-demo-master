package link.lycreate.springbooteasyexceldemo.domain;

import java.math.BigDecimal;

/**
 * @ClassName Person
 * @Description TODO 测试实体类$
 * @Author charlesYan
 * @Date 2020/9/26 17:51
 * @Version 1.0
 **/
public class Person {

    private String name;

    private String height;

    private BigDecimal money;

    public Person(String name, String height) {
        this.name = name;
        this.height = height;
    }

    public Person(String name, String height, BigDecimal money) {
        this.name = name;
        this.height = height;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
