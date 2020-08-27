package com.cfh.test;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;

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
        System.out.println(dateTime);
        // 获取时区列表
        String[] zones = TimeZone.getAvailableIDs();
        for (String zone : zones) {
            System.out.println(zone);
        }
        // 美国纽约 时区
        String dateTime2 = new DateTime(DateTimeZone.forTimeZone(TimeZone.getTimeZone("America/New_York"))).toString("yyyy-MM-dd HH:mm:ss");
        System.out.println(dateTime2);
        //获取指定时区的当前时间
        DateTimeZone zone = DateTime.now().getZone();
        System.out.println(zone);
        //获取指定时区的当前时间
        DateTimeZone gmt = DateTimeZone.forID("America/New_York");
        DateTime dateTime3 = DateTime.now().toDateTime(gmt);
        System.out.println(dateTime3.toString("yyyy-MM-dd HH:mm:ss"));

        DateTime date = DateTime.parse("04/02/2011 20:27:05",
                DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss")).toDateTime(gmt);
        System.out.println(date.toDate().getTime());
        System.out.println(date.toString("yyyy-MM-dd HH:mm:ss"));
    }
}
