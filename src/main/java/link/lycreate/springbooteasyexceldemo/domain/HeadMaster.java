package link.lycreate.springbooteasyexceldemo.domain;

/**
 * @ClassName HeadMaster
 * @Description 校长实体类$
 * @Author charlesYan
 * @Date 2020/10/22 17:32
 * @Version 1.0
 **/
public class HeadMaster {

    //**************成员方法***************//
    public void show1(String s){
        System.out.println("调用了：公有的，String参数的show1(): s = " + s);
    }
    protected void show2(){
        System.out.println("调用了：受保护的，无参的show2()");
    }
    void show3(){
        System.out.println("调用了：默认的，无参的show3()");
    }
    private String show4(int age){
        System.out.println("调用了，私有的，并且有返回值的，int参数的show4(): age = " + age);
        return "abcd";
    }

    public static void main(String[] args) {
        System.out.println("调用校长类中的main方法");
    }
}
