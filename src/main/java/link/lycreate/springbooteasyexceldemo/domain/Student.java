package link.lycreate.springbooteasyexceldemo.domain;

/**
 * @ClassName Student
 * @Description 学生实体类$
 * @Author charlesYan
 * @Date 2020/10/22 14:12
 * @Version 1.0
 **/
public class Student {

    // 无参构造方法
    public Student() {
        System.out.println("----调用了公有、无参构造方法----");
    }

    // 单参数构造方法
    public Student(char name) {
        System.out.println("姓名：" + name );
    }

    // 多参数构造方法
    public Student(String name,int age){
        System.out.println("姓名：" + name + " 年龄：" + age);
    }

    // 受保护构造方法
    protected Student(boolean flag){
        System.out.println("受保护的构造方法：" + flag);
    }

    // 默认构造方法
    Student(String name){
        System.out.println("默认的构造方法：" + name);
    }

    // 私有构造方法
    private Student(int age){
        System.out.println("私有构造方法：" + age);
    }
}
