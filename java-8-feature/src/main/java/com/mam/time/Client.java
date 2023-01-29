package com.mam.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * @Author Anmin
 * @Date 2023/01/29
 **/
public class Client {
    public static void main(String[] args) {
        getNowTime();
        System.out.println("=========");
        createTime();
        System.out.println("============");
        convertTime();
        System.out.println("==========");
        formatTime();
        System.out.println("============");
        diffTime();
        System.out.println("============");
        calc();
        System.out.println("===========");
        extend();
    }

    public static void getNowTime(){
        //获取精确时间
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前精确的时间：" + now);
        System.out.println("当前精确的时间:" + now.getYear() + "-" + now.getMonthValue() + "-" +
                now.getDayOfMonth() + "-" +now.getHour() + "-" +now.getMinute() + "-" + now.getSecond());
        //获取当前日期
        LocalDate date = LocalDate.now();
        System.out.println("当前日期为：" +date);
        System.out.println("当前日期为：" + date.getYear() + "-" + date.getMonthValue() + "-" + date.getDayOfMonth());

        //获取当天时间
        LocalTime time = LocalTime.now();
        System.out.println("当天时间：" + time);
        System.out.println("当天时间：" + time.getHour() + ":" + time.getMinute() + ":" + time.getSecond());

        //有时区的当前精确时间
        ZonedDateTime zonedDateTime = LocalDateTime.now().atZone(ZoneId.systemDefault());
        System.out.println("当前精确时间（有时区）：" + zonedDateTime);
        System.out.println("当前精确时间（有时区）：" + zonedDateTime.getYear() + "-" + zonedDateTime.getMonthValue() + "-"
                + zonedDateTime.getDayOfMonth() + " " + zonedDateTime.getHour() + "-" + zonedDateTime.getMinute() + "-"
                + zonedDateTime.getSecond());

    }

    /**
     * 时间创建
     */
    public static void createTime(){
        LocalDateTime localDateTime = LocalDateTime.of(2023, 1, 29, 14, 59, 00);
        System.out.println("当前创建的精确时间为：" + localDateTime);
        LocalDate localDate = LocalDate.of(2023, 1, 29);
        System.out.println("当前创建的日期为：" + localDate);
        LocalTime localTime = LocalTime.of(15, 01, 01);
        System.out.println("当前创建的时间为：" + localTime);
    }

    /**
     * 日期转换
     */
    public static void convertTime(){
        LocalDateTime localDateTime = LocalDateTime.parse("2023-01-29T14:59");
        System.out.println("字符串时间转换：" + localDateTime);

        LocalDate localDate = LocalDate.parse("20230129", DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println("字符串时间转换-指定格式：" + localDate);

        // Date 转换成 LocalDateTime
        Date date = new Date();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime instant = LocalDateTime.ofInstant(date.toInstant(), zoneId);
        System.out.println("Date 转换成 LocalDateTime：" + instant);

        // LocalDateTime 转换成 Date
        LocalDateTime now = LocalDateTime.now();
        Date from = Date.from(now.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println("LocalDateTime 转换成 Date：" + from);

    }

    /**
     * 格式化时间
     */
    public static void formatTime(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("当前时间：" + now);
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_DATE));
        System.out.println("格式化后：" + now.format(DateTimeFormatter.ISO_LOCAL_TIME));
        System.out.println("自定义格式化：" + now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    /**
     * 时间比较
     */
    public static void diffTime(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yesterday = now.minusDays(1);
        System.out.println(now + "在" + yesterday + "之后吗?" + now.isAfter(yesterday));
        System.out.println(now + "在" + yesterday + "之前吗?" + now.isBefore(yesterday));

        //时间差
        long day = yesterday.until(now, ChronoUnit.DAYS);
        long month = yesterday.until(now, ChronoUnit.MONTHS);
        long hours = yesterday.until(now, ChronoUnit.HOURS);
        long minutes = yesterday.until(now, ChronoUnit.MINUTES);
        System.out.println("相差月份" + month);
        System.out.println("相差天数" + day);
        System.out.println("相差小时" + hours);
        System.out.println("相差分钟" + minutes);

        //距离生日还有多少天
        LocalDate bir = LocalDate.of(2023, 4, 15);
        LocalDate now1 = LocalDate.now();
        long diff = now1.until(bir, ChronoUnit.DAYS);
        System.out.println("距离生日还有：" + diff +"天");

    }

    /**
     * 时间相减
     */
    public static void calc(){
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime diff = now.plusMonths(1).plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1);
        System.out.println("增加1月1天1小时1分钟1秒时间后：" + diff);
        //减少两个月
        LocalDateTime months = now.minusMonths(2);
        System.out.println("减少两个月：" + months);
    }

    /**
     * 扩展方法
     */
    public static void extend(){
        LocalDateTime now = LocalDateTime.now();
        System.out.println("本月第一天：" + now.withDayOfMonth(1));
        LocalDateTime lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println("本月最后一天:" + lastDay);
        System.out.println("今年是否闰年：" + Year.isLeap(now.getYear()));
    }
}
