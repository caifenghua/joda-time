package com.cfh.test;

import org.apache.commons.lang3.time.FastDateFormat;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

/**
 * @描述
 * @创建人 caifenghua
 * @创建时间 dad$
 */
public class DateTimeZoneTest {

    public static void main(String[] args) {
        // 指定时区构造时间
        String dateTime = new DateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("Asia/Shanghai"))).toString("yyyy-MM-dd HH:mm:ss");
        String dateTimeGmt = new DateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+8"))).toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("上海时区时间：" + dateTime);
        System.out.println("北京时区时间：" + dateTimeGmt);
        // 获取时区列表
        String[] zones = TimeZone.getAvailableIDs();
       /* for (String zone : zones) {
            System.out.println(zone);
        }*/
        // 将美国时间转化为北京时间
        // 1、将北京时间转化成美国时间
        DateTimeZone usZone = DateTimeZone.forID("America/New_York");
        DateTime usDateTime = DateTime.now().toDateTime(usZone);
        String usDateTimeStr = usDateTime.toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("美国时间为 ： " + usDateTimeStr);
        // 2、将美国时间切换成中国时间
        DateTimeZone chinaZone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+8"));
        DateTime chinaDateTime = DateTime.parse(usDateTimeStr,
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDateTime(chinaZone);
        System.out.println("joda美国时间转中国时间 ： " + chinaDateTime.toString("yyyy-MM-dd HH:mm:ss"));

        // FastDateFormat 将美国时间转化为北京时间
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        FastDateFormat fdfh = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss", timeZone);
        Date beginDate = fdfh.parse("2020-09-03" + " " + "09:30:00", new ParsePosition(0));
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s1 = sdf.format(beginDate);
        System.out.println("FastDateFormat美国时间转中国时间 = " + s1);

        // joda 将字符串转为dateTime
        DateTime str2DateTime = DateTime.parse("2020-09-04 21:00:00",
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDateTime();
        System.out.println("[默认本地时区]字符串转joda时间：" + str2DateTime.toString("yyyy-MM-dd HH:mm:ss"));
        // joda 将字符串转为dateTime
        DateTime str2DateTimeUs = DateTime.parse("2020-09-04 21:00:00",
                DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")).toDateTime(usZone);
        System.out.println("[美国时区]字符串转joda时间：" + str2DateTimeUs.toString("yyyy-MM-dd HH:mm:ss"));

        // 将date时间+1天[美国时区]
        DateTime minus1DayTime = new DateTime(new Date(), usZone).minusDays(1);
        System.out.println("美国时区减去1天的时间为" + minus1DayTime.toString("yyyy-MM-dd HH:mm:ss"));
        // 测试 版本回退2

        // 测试undo commit
    }
}
