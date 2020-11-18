package com.cfh.test;

import com.github.benmanes.caffeine.cache.Cache;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName Test
 * @Description: 时间测试
 * @Author: bughua
 * @CreateDate: 2019/9/10 14:02
 */
public class Test {


    private static Cache<String, Object> ipInfoCaffeine;

    public Test(@Qualifier("ipInfoCaffeine")Cache<String, Object> ipInfoCaffeine) {
        Test.ipInfoCaffeine = ipInfoCaffeine;
    }

    public static void main(String[] args) {
        // 获取当前时间
        DateTime dateTime = new DateTime();
        // 获取指定时间
        DateTime dateTime2 = new DateTime(2019,9,15,15,30,0);
        System.out.println("获取到的指定时间是" + dateTime2);
        // 替换时间年（会将2月29自己替换成2月28日）
        DateTime dateTime2000Year = new DateTime(2000,2,29,0,0,0);
        System.out.println(dateTime2000Year);
        DateTime dateTime1997Year =
                dateTime2000Year.withYear(1997);
        System.out.println("将2000年替换成1997年的结果是" + dateTime1997Year); // out: 1997-02-28T00:00:00.000+08:00
        // 时间相加减
        DateTime tomorrow = dateTime.plusDays(1);
        System.out.println("当前时间加一天的时间是" + tomorrow.toString("yyyy-MM-dd"));
        DateTime lastMonth = dateTime.minusMonths(1);
        System.out.println("当前时间减一个月的时间是" + lastMonth.toString("yyyy-MM-dd HH:mm:ss"));
        // 返回属性信息
        String monthChina = dateTime.monthOfYear().getAsText();
        String month = dateTime.monthOfYear().getAsText(Locale.ENGLISH);
        System.out.println("获取到的月份(中文)是：" + monthChina + " 英文为;" + month);
        String weekChina = dateTime2.dayOfWeek().getAsShortText();
        String week = dateTime2.dayOfWeek().getAsShortText(Locale.ENGLISH);
        System.out.println("获取到的星期(中文)是：" + weekChina + " 英文为;" + week);
        // 有时我们需要对一个DateTime的某些属性进行置0操作。
        // 比如，我想得到当天的0点时刻
        DateTime dateTime3 = dateTime.dayOfWeek().roundCeilingCopy();// 返回不小于value 的下一个整数
        System.out.println("明天0点时间为：" + dateTime3.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime dateTime4 = dateTime.dayOfWeek().roundFloorCopy();
        System.out.println("今天天0点时间为：" + dateTime4.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime dateTime5 = dateTime.minuteOfDay().roundFloorCopy();
        System.out.println("秒设置为0为：" + dateTime5.toString("yyyy-MM-dd HH:mm:ss"));
        DateTime dateTime6 = dateTime.secondOfMinute().roundFloorCopy();
        System.out.println("毫秒设置为0为：" + dateTime6.toString("yyyy-MM-dd HH:mm:ss"));
        // dateTime.year().isLeap() 判断是不是闰年
        System.out.println("今年是闰年吗？" + dateTime.year().isLeap());
        // 获取当天开始时间和结束时间
        String startTimeOfDay = dateTime.withTimeAtStartOfDay().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天开始时间是:"+ startTimeOfDay);
        String endTimeOfDay = dateTime.millisOfDay().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("今天结束时间是:"+ endTimeOfDay);
        // 求一周的开始时间和结束时间
        String startTimeOfWeek =  dateTime.withDayOfWeek(DateTimeConstants.MONDAY).withTimeAtStartOfDay().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("本周开始时间是:"+ startTimeOfWeek);
        String endTimeOfWeek = dateTime.withDayOfWeek(DateTimeConstants.SUNDAY).millisOfDay().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("本周结束时间是:"+ endTimeOfWeek);
        // 求一月的开始时间和结束时间
        String startTimeOfMonth = dateTime.withDayOfMonth(DateTimeConstants.MONDAY).withTimeAtStartOfDay().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("本月开始时间是:"+ startTimeOfMonth);
        String endTimeOfMonth = dateTime.dayOfMonth().withMaximumValue().millisOfDay().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("本月结束时间是:"+ endTimeOfMonth);
        // 求上周开始时间和结束时间
        String startTimeOfLastWeek =  dateTime.minusWeeks(1).withDayOfWeek(DateTimeConstants.MONDAY).withTimeAtStartOfDay().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("上周开始时间是:"+ startTimeOfLastWeek);
        String endTimeOfLastWeek = dateTime.minusWeeks(1).withDayOfWeek(DateTimeConstants.SUNDAY).millisOfDay().withMaximumValue().toString("yyyy-MM-dd HH:mm:ss");
        System.out.println("上周结束时间是:"+ endTimeOfLastWeek);
        // 获取当天指定时间 17 ： 00
        DateTime dateTime7 = dateTime.withTime(8, 59, 59, 0);
        System.out.println("当天15点时间为" + dateTime7.toString("yyyy-MM-dd HH:mm:ss"));
        // 获取本周周五 17：00
        DateTime dateTime8 = dateTime.withDayOfWeek(DateTimeConstants.FRIDAY).withTime(17, 30, 0, 0);
        System.out.println("本周周五15点时间为" + dateTime8.toString("yyyy-MM-dd HH:mm:ss"));
        // 获取当天是一周的第几天
        int dayOfWeek = dateTime.withDayOfWeek(DateTimeConstants.SUNDAY).getDayOfWeek();
        System.out.println(dayOfWeek);
    }

}
