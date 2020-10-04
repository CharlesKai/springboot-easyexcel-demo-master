package link.lycreate.springbooteasyexceldemo.utils;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description TODO 日期工具类$
 * @Author charlesYan
 * @Date 2020/9/15 10:19
 * @Version 1.0
 **/
public class DateUtil {

    /**

     * 获取指定日期下个月的第一天
     * @param dateStr
     * @param format
     * @return
     */
    public static String getFirstDayOfNextMonth(String dateStr,String format){
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            Date date = sdf.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            calendar.set(Calendar.DAY_OF_MONTH,1);
            calendar.add(Calendar.MONTH, 1);
            return sdf.format(calendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Author charlesYan
     * @Description //获取当前季度
     * @Date 10:34 2020/9/15
     * @Param []
     * @return java.lang.String
     **/
    public static String getCurrQuarter() {
        Calendar c = Calendar.getInstance();
        int month = c.get(c.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter + "";
    }

    /**
     * @Author charlesYan
     * @Description //获取指定日期季度
     * @Date 16:26 2020/9/15
     * @Param [date]
     * @return java.lang.String
     **/
    public static String getDateQuarter(String date) {

        Calendar c = Calendar.getInstance();
        c.setTime(parseDate(date,"yyyyMMdd"));
        int month = c.get(c.MONTH) + 1;
        int quarter = 0;
        if (month >= 1 && month <= 3) {
            quarter = 1;
        } else if (month >= 4 && month <= 6) {
            quarter = 2;
        } else if (month >= 7 && month <= 9) {
            quarter = 3;
        } else {
            quarter = 4;
        }
        return quarter + "";
    }


    /**
     * @Author charlesYan
     * @Description //获取指定季度的第一天和最后一天
     * @Date 10:46 2020/9/15
     * @Param [num]
     * @return java.lang.String[]
     *
     * @param num*/
    public static String[] getCurrQuarterRange(int num) {
        String[] s = new String[2];
        String str = "";
        // 设置本年的季
        Calendar quarterCalendar = null;
        switch (num) {
            case 1: // 本年到现在经过了一个季度，在加上前4个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 3);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyyMMdd");
                s[0] = str.substring(0, str.length() - 4) + "0101";
                s[1] = str;
                break;
            case 2: // 本年到现在经过了二个季度，在加上前三个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 6);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyyMMdd");
                s[0] = str.substring(0, str.length() - 4) + "0401";
                s[1] = str;
                break;
            case 3:// 本年到现在经过了三个季度，在加上前二个季度
                quarterCalendar = Calendar.getInstance();
                quarterCalendar.set(Calendar.MONTH, 9);
                quarterCalendar.set(Calendar.DATE, 1);
                quarterCalendar.add(Calendar.DATE, -1);
                str = formatDate(quarterCalendar.getTime(), "yyyyMMdd");
                s[0] = str.substring(0, str.length() - 4) + "0701";
                s[1] = str;
                break;
            case 4:// 本年到现在经过了四个季度
                quarterCalendar = Calendar.getInstance();
                str = formatDate(quarterCalendar.getTime(), "yyyyMMdd");
                s[0] = str.substring(0, str.length() - 4) + "1001";
                s[1] = str.substring(0, str.length() - 4) + "1231";
                break;
        }
        return s;
    }


    /**
     * 用途：以指定的格式格式化日期字符串
     * @param pattern 字符串的格式
     * @param currentDate 被格式化日期
     * @return String 已格式化的日期字符串
     * @throws NullPointerException 如果参数为空
     */
    public static String formatDate(Date currentDate, String pattern) {
        if (currentDate == null || "".equals(pattern) || pattern == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(currentDate);
    }

    /**
     * @Author charlesYan
     * @Description //将日期转换为指定格式
     * @Date 16:25 2020/9/15
     * @Param [currentDate, pattern]
     * @return java.util.Date
     **/
    public static Date parseDate(String currentDate, String pattern) {
        if (currentDate == null || "".equals(pattern) || pattern == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(currentDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @Author charlesYan
     * @Description //获得累加指定天数日期字符串
     * @Date 11:28 2020/9/15
     * @Param [date, day]
     * @return java.lang.String
     **/
    public static String addDay(String date,int day){
        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
        try {
            Date temp = dft.parse(date);
            Calendar cld = Calendar.getInstance();
            cld.setTime(temp);
            cld.add(Calendar.DATE, day);
            temp = cld.getTime();
            return dft.format(temp);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * @Author charlesYan
     * @Description //获得累加指定月数日期字符串
     * @Date 13:24 2020/9/15
     * @Param [inputDate, number]
     * @return java.lang.String
     **/
    public static String  addMonth(String inputDate,int number) {
        Calendar c = Calendar.getInstance();//获得一个日历的实例
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try{
            date = sdf.parse(inputDate);//初始日期
        }catch(Exception e){

        }
        c.setTime(date);//设置日历时间
        c.add(Calendar.MONTH,number);//在日历的月份上增加6个月
        String strDate = sdf.format(c.getTime());//的到你想要得6个月后的日期
        return strDate;
    }


    public static String[] getCurrYearRange1(String date) {
        String[] s = new String[2];
        String str = "";

        DateFormat dft = new SimpleDateFormat("yyyyMMdd");
        try {
            Date temp = dft.parse(date);
            Calendar cld = Calendar.getInstance();
            cld.setTime(temp);
            int year = cld.get(Calendar.YEAR);
            temp = cld.getTime();
            s[0] = str.substring(0, str.length() - 4) + "0101";
            s[1] = str.substring(0, str.length() - 4) + "1231";
            return s;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String[] getCurrYearRange2(String date) {
        String[] s = new String[2];
        String str = "";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate lastLocalDate = localDate.minusYears(1);
        str = lastLocalDate.format(DateTimeFormatter.BASIC_ISO_DATE);
        s[0] = str.substring(0, str.length() - 4) + "0101";
        s[1] = str.substring(0, str.length() - 4) + "1231";
        return s;

    }

    public static String[] getCurrYearRange(String date) {
        String[] s = new String[2];
        int lastYear = Integer.parseInt(date.substring(0, date.length() - 4)) - 1;
        s[0] = lastYear + "0101";
        s[1] = lastYear + "1231";
        return s;

    }

    /**
     * @Author charlesYan
     * @Description //将指定日期字符串转成指定日期字符串
     * @Date 13:32 2020/9/18
     * @Param [dateStr, source, target]
     * @return java.lang.String
     **/
    public static String formateDateStr(String dateTimeStr,String source,String target){

        DateTimeFormatter sourcePattern =   DateTimeFormatter.ofPattern(source);
        DateTimeFormatter targetPattern = DateTimeFormatter.ofPattern(target);

        LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, sourcePattern);
        String newDateTimeStr = dateTime.format(targetPattern);
        return newDateTimeStr;
    }



    public static double divide(double a, double b, int scale){
        BigDecimal bd1 = new BigDecimal(Double.toString(a));
        BigDecimal bd2 = new BigDecimal(Double.toString(b));
        if (bd1.compareTo(bd2) == 1) {
            System.out.println("分子大于分母");
        }
        // -1 - 小于，0 - 等于，1 - 大于
        if (BigDecimal.ZERO.compareTo(bd2) == 0) {
            return 0d;
        }
        return bd1.divide(bd2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * @Author charlesYan
     * @Description //计算两数相除求百分比并保留小数
     * @Date 21:31 2020/9/26
     * @Param [a, b]
     * @return java.lang.String
     **/
    public static String calculateResultOfPercent(Integer a, Integer b) {
        if (b == 0) {
            return "0%";
        }

        DecimalFormat df = new DecimalFormat("#.#%");
        return df.format((double) a / b);
    }
}
