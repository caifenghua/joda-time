package com.cfh.test;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.ParseException;
import java.util.Date;

/**
 * @ClassName DateUtil
 * @Description: 时间工具类
 * @Author: bughua
 * @CreateDate: 2019/9/11 13:43
 */
public class DateUtil {
    /**
     * 英文简写 如：2010-12-01
     */
    public static String FORMAT_SHORT = "yyyy-MM-dd";
    /**
     * 英文全称（默认） 如：2010-12-01 23:15:06
     */
    public static String FORMAT_LONG = "yyyy-MM-dd HH:mm:ss";
    /**
     * 中文简写 如：2010年12月01日
     */
    public static String FORMAT_SHORT_CN = "yyyy年MM月dd日";
    /**
     * 中文全称 如：2010年12月01日 23时15分06秒
     */
    public static String FORMAT_LONG_CN = "yyyy年MM月dd日  HH时mm分ss秒";

    /***
     * 将string字符串转化为Date类型的字符串  默认格式为yyyy-MM-dd HH:mm:ss
     * @param dateTimeStr 需要转化的string类型的字符串
     * @return 返回转化后的Date类型的时间
     */
    public static Date strToDate(String dateTimeStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMAT_LONG);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /***
     * 将string字符串转化为Date类型的字符串
     * @param dateTimeStr 需要转化的string类型的字符串
     * @param formatStr 转化规则
     * @return 返回转化后的Date类型的时间
     */
    public static Date strToDate(String dateTimeStr, String formatStr){
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(formatStr);
        DateTime dateTime = dateTimeFormatter.parseDateTime(dateTimeStr);
        return dateTime.toDate();
    }

    /***
     * 将date类型的时间转化为string类型
     * @param date 需要转化的date类型的时间
     * @param formatStr 转化规则
     * @return 返回转化后的string类型的时间
     */
    public static String dateToStr(Date date,String formatStr){
        if(date == null){
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(formatStr);
    }

    /***
     * 将date类型的时间转化为string类型
     * @param date 需要转化的date类型的时间
     * @return 返回转化后的string类型的时间
     */
    public static String dateToStr(Date date){
        if(date == null){
            return "";
        }
        DateTime dateTime = new DateTime(date);
        return dateTime.toString(FORMAT_LONG);
    }

    // 测试合并部分代码 测试
    public static void main(String[] args) {
        Date date = strToDate("2019-09-11 03:55:55");
        Date date2 = strToDate("2019-09-12 03:55:55");
        System.out.println(dateToStr(strToDate("2019-09-11 03:55:55")));
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(FORMAT_LONG);
        DateTime dateTime9 = dateTimeFormatter.parseDateTime("2019-11-11 11:11:11");
        DateTime dateTime10 = dateTimeFormatter.parseDateTime("2019-11-12 11:11:11");
        if (dateTime9.isBefore(dateTime10)) {
            System.out.println("hha");
        }
    }
}
