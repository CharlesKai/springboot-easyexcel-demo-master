package link.lycreate.springbooteasyexceldemo;

import link.lycreate.springbooteasyexceldemo.domain.Person;
import link.lycreate.springbooteasyexceldemo.utils.BigDecimalSummaryStatistics;
import link.lycreate.springbooteasyexceldemo.utils.DateUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static link.lycreate.springbooteasyexceldemo.utils.DateUtil.calculateResultOfPercent;

/**
 * @ClassName DateTest
 * @Description TODO 日期测试类$
 * @Author charlesYan
 * @Date 2020/9/15 9:37
 * @Version 1.0
 **/
public class DateTest extends SpringbootEasyexcelDemoApplicationTests {



    @Test
    public void test1(){
        System.out.println("------获取下个月第一天-------");
        String dateStr = DateUtil.getFirstDayOfNextMonth("20201215", "yyyyMMdd");
        System.out.println(dateStr);
    }

    @Test
    public void test2(){
        String quarter = DateUtil.getCurrQuarter();
        System.out.println(quarter);

        String[] quarter1 = DateUtil.getCurrQuarterRange(1);
        String[] quarter2 = DateUtil.getCurrQuarterRange(2);
        String[] quarter3 = DateUtil.getCurrQuarterRange(3);
        String[] quarter4 = DateUtil.getCurrQuarterRange(4);
        System.out.println(Arrays.toString(quarter1));
        String nextDate = DateUtil.addDay(quarter1[1], 1);
        System.out.println("指定日期下一天：" + nextDate);
        String nextQuarter1 = DateUtil.addMonth(quarter1[0], -3);
        String nextQuarter2 = DateUtil.addMonth(quarter1[1], -3);
        System.out.println("指定日期下一季度季初：" + nextQuarter1);
        System.out.println("指定日期下一季度季末：" + nextQuarter2);

    }

    @Test
    public void test3(){
        String[] currYearRange = DateUtil.getCurrYearRange("20200912");
        System.out.println(Arrays.toString(currYearRange));

        String dateQuarter = DateUtil.getDateQuarter("20200823");
        System.out.println("当前日期所属季度：" + dateQuarter);
    }

    @Test
    public void test4(){

        String dateStr = "20200918133323";
        String newDateStr = DateUtil.formateDateStr(dateStr, "yyyyMMddHHmmss", "yyyy-MM-dd HH:mm");
        System.out.println(dateStr + "--->" + newDateStr);
    }



    @Test
    public void test() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("zhangsan","180"));
        people.add(new Person("lisi", "175"));
        people.add(new Person("wangwu","178"));


        int sum = people.stream()
                .mapToInt(p -> Integer.parseInt(p.getHeight()))
                .sum();
        System.out.println("总身高：" + sum);
    }


    @Test
    public void testBigdecimal() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", "180", new BigDecimal(10.5)));
        list.add(new Person("lisi", "175", new BigDecimal(22.2)));
        list.add(new Person("wangwu", "178", new BigDecimal(15.54)));

        // reduce方法累加求和，给定初始值0
        BigDecimal amounts = list.stream().map(item -> item.getMoney())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        // 保留一位
        amounts = amounts.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println("总钱数:" + amounts);

        // 或者
        BigDecimal sum = list
                .stream()
                .map(Person::getMoney)
                .reduce(BigDecimal::add)
                .get();
        sum = sum.setScale(1, BigDecimal.ROUND_DOWN);
        System.out.println("Total of Money: " + sum);
    }


    @Test
    public void testDivision(){

        double b1 = 10;
        double b2 = 3;

        double average  = b1 / b2;
        double result = DateUtil.divide(b1, b2, 2);
        System.out.println("结果：" + average);
        System.out.println("结果：" + result);
    }

    @Test
    public void testDivisionUnnormal(){

        String cnt = "10|0.0";
        double[] doubles = Arrays.stream(cnt.split("\\|")).mapToDouble(s -> Double.parseDouble(s.trim())).toArray();

        double b1 = doubles[0];
        double b2 = doubles[1];

        double average  = b1 / b2;
        double result = DateUtil.divide(b1, b2, 2);
        System.out.println("结果：" + average);
        System.out.println("结果：" + result);
    }


    @Test
    public void testDecimalFormat(){
        String percent = calculateResultOfPercent(3, 8);
        System.out.println("百分比：" + percent);
    }



    @Test
    public void testSummaryStatistics() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", "180", new BigDecimal(10.5)));
        list.add(new Person("lisi", "175", new BigDecimal(22.2)));
        list.add(new Person("wangwu", "178", new BigDecimal(15.54)));

        IntSummaryStatistics heightStatistics = list.stream().mapToInt(p -> Integer.parseInt(p.getHeight())).summaryStatistics();
        double average = heightStatistics.getAverage();
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数
        String averageFormat = df.format(average);

        int max = heightStatistics.getMax();
        int min = heightStatistics.getMin();
        long sum = heightStatistics.getSum();
        System.out.println("平均数：" + averageFormat);
        System.out.println("最大数：" + max);
        System.out.println("最小数：" + min);
        System.out.println("总和：" + sum);
    }



    @Test
    public void testBigDecimalSummaryStatistics() {
        List<Person> list = new ArrayList<>();
        list.add(new Person("zhangsan", "180", new BigDecimal(10.5)));
        list.add(new Person("lisi", "175", new BigDecimal(22.2)));
        list.add(new Person("wangwu", "178", new BigDecimal(15.54)));

        BigDecimalSummaryStatistics collect = list.stream().map(item -> item.getMoney()).collect(BigDecimalSummaryStatistics.statistics());
        System.out.println("平均数：" + collect.getAverage(MathContext.DECIMAL128));

    }
}
