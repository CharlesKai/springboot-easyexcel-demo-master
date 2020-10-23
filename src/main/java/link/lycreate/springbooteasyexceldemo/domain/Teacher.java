package link.lycreate.springbooteasyexceldemo.domain;

/**
 * @ClassName Teacher
 * @Description 教师实体类$
 * @Author charlesYan
 * @Date 2020/10/22 16:08
 * @Version 1.0
 **/
public class Teacher {

    public Teacher() {
    }

    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }



}
