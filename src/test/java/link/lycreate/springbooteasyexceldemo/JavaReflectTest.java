package link.lycreate.springbooteasyexceldemo;

import link.lycreate.springbooteasyexceldemo.domain.Student;
import link.lycreate.springbooteasyexceldemo.domain.Teacher;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @ClassName JavaReflectTest
 * @Description 反射测试类$
 * @Author charlesYan
 * @Date 2020/10/22 14:37
 * @Version 1.0
 **/
public class JavaReflectTest extends SpringbootEasyexcelDemoApplicationTests {

    /**
     * @Author charlesYan
     * @Description //测试获取构造方法
     * @Date 14:42 2020/10/22
     * @Param []
     * @return void
     **/
   @Test
   public void testGetConstructorMethod() throws Exception {

        // 1.加载Class对象
        Class studentClass = Class.forName("link.lycreate.springbooteasyexceldemo.domain.Student");

        // 2.获取所有公有构造方法
        System.out.println("**********************所有公有构造方法*********************************");
        Constructor[] constructors = studentClass.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);

        // 3.获取所有构造方法(包括：私有、默认、受保护、公有)
        System.out.println("**********************获取所有构造方法(包括：私有、默认、受保护、公有)*********************************");
        Constructor[] declaredConstructors = studentClass.getDeclaredConstructors();
        Arrays.stream(declaredConstructors).forEach(System.out::println);

        // 4.获取公有、无参的构造方法
        System.out.println("*****************获取公有、无参的构造方法*******************************");

        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        Constructor nonParameterMethod = studentClass.getConstructor();
        System.out.println(nonParameterMethod);

        //3>、调用公有构造方法
        Student student = (Student)nonParameterMethod.newInstance();
        System.out.println("调用公有无参构造方法获取对象：" + student);

        // 5.获取私有构造方法
        System.out.println("******************获取私有构造方法*******************************");
        Constructor privateIntParameterMethod = studentClass.getDeclaredConstructor(int.class);
        System.out.println(privateIntParameterMethod);
        // 1>、调用私有构造方法
        privateIntParameterMethod.setAccessible(true);
        Object instance = privateIntParameterMethod.newInstance(15);
    }


    @Test
    public void testGetFields() throws Exception {

        // 1.获取Class对象
        Class teacherClass = Class.forName("link.lycreate.springbooteasyexceldemo.domain.Teacher");

        // 2.获取字段
        System.out.println("************获取所有公有的字段********************");
        Field[] fields = teacherClass.getFields();
        Arrays.stream(fields).forEach(System.out::println);

        System.out.println("************获取所有的字段(包括私有、默认、受保护、公共的)********************");
        Field[] declaredFields = teacherClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(System.out::println);

        // 3.调用字段设值
        System.out.println("*************获取公有字段**并调用***********************************");
        Field name = teacherClass.getField("name");
        System.out.println("获取公有字段信息：" + name);
        // 调用公有无参构造方法获取一个对象
        Object obj = teacherClass.getConstructor().newInstance();// 产生Student对象-->Student stu = new Student();
        // 为字段设值
        name.set(obj,"张伯军");// 为Student对象中的name属性赋值-->stu.name = "张伯军"
        // 验证
        Teacher teacher = (Teacher)obj;
        System.out.println("验证姓名：" + teacher);

        System.out.println("*************获取默认字段**并调用***********************************");
        Field age = teacherClass.getDeclaredField("age");
        System.out.println("获取默认字段信息：" + age);
        age.setAccessible(true);// 设置暴力反射，解除私有设定
        age.set(obj,18);
        System.out.println("验证电话：" + teacher);


    }


    @Test
    public void testGetMemberMethod() throws Exception {

        // 1. 获取Class对象
        Class masterClass = Class.forName("link.lycreate.springbooteasyexceldemo.domain.HeadMaster");


        System.out.println("***************获取所有的公有方法*******************");
        Method[] methods = masterClass.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        System.out.println("***************获取所有的方法，包括私有的*******************");
        Method[] declaredMethods = masterClass.getDeclaredMethods();
        Arrays.stream(declaredMethods).forEach(System.out::println);

        System.out.println("***************调用公有的show1()方法*******************");
        Method show1 = masterClass.getMethod("show1", String.class);
        System.out.println("获取公有成员方法信息：" + show1);
        Object obj = masterClass.getConstructor().newInstance();
        show1.invoke(obj,"方法一");

        System.out.println("***************调用私有的show4()方法******************");
        Method show4 = masterClass.getDeclaredMethod("show4", int.class);
        System.out.println("获取私有成员方法信息：" + show4);
        show4.setAccessible(true); // 设置暴力反射，解除私有限定
        Object result = show4.invoke(obj, 18);
        System.out.println("调用私有成员方法返回结果：" + result);
    }


    @Test
    public void testGetMainMethod() throws Exception {


        // 1.获取Class对象
        Class masterClass = Class.forName("link.lycreate.springbooteasyexceldemo.domain.HeadMaster");

        // 2.获取main方法
        Method main = masterClass.getMethod("main", String[].class);
        System.out.println("获取main方法信息：" + main);

        // 3.调用main方法
        // 第一个参数，对象类型，因为方法是static静态的，所以为null可以；第二个参数是String数组，这里要注意在jdk1.4时是数组，jdk1.5之后是可变参数
        // main.invoke(null,new String[]{"a","b","c"});
        // 这里拆的时候将  new String[]{"a","b","c"} 拆成3个对象。。。所以需要将它强转。
        main.invoke(null, (Object) new String[]{"a", "b", "c"}); // 方式一
        main.invoke(null, new Object[]{new String[]{"a", "b", "c"}}); // 方式二

    }


    @Test
    public void testGenericChecking() throws Exception {

        List<String> strs = new ArrayList<>();
        strs.add("a");
        strs.add("b");
        // 直接添加报错，编译期检查不通过
//        strs.add(5);

        Class clazz = Class.forName("java.util.ArrayList");
        Method add = clazz.getMethod("add", Object.class);
        Boolean flag = (boolean)add.invoke(strs, 5);
        System.out.println("是否添加成功：" + flag); // 是否添加成功：true
        System.out.println(strs); // [a, b, 5]
    }


    @Test
    public void testAnalyseConfiguration() throws Exception {

        Class studentClass = Class.forName("link.lycreate.springbooteasyexceldemo.domain.Student");
        String path = studentClass.getResource("/").getPath();
        // 拼接配置文件地址
        String profilePath = new File(path).getParent() + File.separator + "classes" + File.separator + "reflect.txt";
        FileReader in = new FileReader(profilePath);
        Properties properties = new Properties();
        properties.load(in);
        in.close();
        String className = (String)properties.get("className");
        String methodName = (String) properties.get("methodName");
        System.out.println("获取的配置文件信息：" + className + "--->" + methodName);
        // 根据配置信息利用反射执行相应方法
        Class masterClass = Class.forName(className);
        Method method = masterClass.getDeclaredMethod(methodName);
        method.setAccessible(true);
        Object obj = masterClass.getConstructor().newInstance();
        method.invoke(obj);
    }
}
