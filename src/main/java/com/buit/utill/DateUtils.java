package com.buit.utill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 处理时间的常用工具类
 */
public class DateUtils {
    private static final Logger logger = LoggerFactory.getLogger(DateUtils.class);

    public static final String YEAR_MONTH_DAY = "yyyy-MM-dd";
    public static final String HOUR_MINUTE_SECOND = "HH:mm:ss";//24小时制
    public static final String HOUR_MINUTE = "HH:mm";//24小时制
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_SECOND = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取当前时间
     */
    public static Timestamp getNow() {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getMonthStartTime(Timestamp timeStamp) {
        if (null == timeStamp) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTimeInMillis(timeStamp.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    public static Timestamp getMonthEndTime(Timestamp timeStamp) {
        if (null == timeStamp) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTimeInMillis(timeStamp.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取一天的最小时间
     *
     * @param timeStamp
     * @param
     * @return
     */
    public static Timestamp getDailyStartTime(Long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取一天的最小时间
     *
     * @param date yyyy-mm-dd 格式字符串
     * @return
     */
    public static String getDailyStartTime(String date) {
        return date.trim() + " 0:00:00.000";
    }

    /**
     * 获取一天的最大时间
     *
     * @param timeStamp
     * @param
     * @return
     */
    public static Timestamp getDailyEndTime(Long timeStamp) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTimeInMillis(timeStamp);
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 获取一天的最大时间
     *
     * @param date yyyy-mm-dd 格式字符串
     * @return
     */
    public static String getDailyEndTime(String date) {
        return date.trim() + " 23:59:59.999";
    }

    /**
     * 时间字符串转换成Timestamp
     *
     * @param
     * @return
     * @throws ParseException
     */
    public static Timestamp convertTimestamp(String dateFormat, String s) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            logger.error("DateUtils.convertTimestamp error: dateFormat[" + dateFormat + "],s[" + s + "]", e);
            System.err.println(e.getStackTrace());
        }
        long ts = date.getTime();
        return new Timestamp(ts);
    }

    /**
     * 时间转换为对应格式的字符串
     *
     * @param date       时间
     * @param dateFormat 格式
     * @return 时间字符串
     */
    public static String format(Date date, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        return simpleDateFormat.format(date);
    }

    /**
     * 时间转换为yyyy-MM-dd HH:mm:ss时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatToDateTime(Date date) {
        return format(date, YEAR_MONTH_DAY_HOUR_MINUTE_SECOND);
    }

    /**
     * 时间转换为yyyy-mm-dd时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatToDate(Date date) {
        return format(date, YEAR_MONTH_DAY);
    }

    /**
     * 时间转换为HH-mm-ss时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatToTime(Date date) {
        return format(date, HOUR_MINUTE_SECOND);
    }

    /**
     * 时间转换为HH:mm时间字符串
     *
     * @param date 时间
     * @return 时间字符串
     */
    public static String formatToHour(Date date) {
        return format(date, HOUR_MINUTE);
    }

    /**
     * yyyy-mm-dd hh:mm:ss 时间字符串转换成Timestamp
     */
    public static Timestamp parseToDateTime(String s) {
        return convertTimestamp(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND, s);
    }

    /**
     * yyyy-mm-dd 时间字符串转换成Timestamp
     */
    public static Timestamp parseToDate(String s) {
        return convertTimestamp(YEAR_MONTH_DAY, s);
    }

    /**
     * 获取当前时间 返回字符串
     */
    public static String getNowTime() {
        Calendar now = Calendar.getInstance();
        now.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat dateFormat = new SimpleDateFormat(HOUR_MINUTE_SECOND);
        return dateFormat.format(now.getTime());
    }

    /**
     * 获取当天日期 返回字符串
     */
    public static String getToday() {
        Calendar now = Calendar.getInstance();
        now.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        SimpleDateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY);
        return dateFormat.format(now.getTime());
    }

    /**
     * 获取明天日期 返回字符串
     */
    public static String getTomorrow() {
        Calendar now = Calendar.getInstance();
        now.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        now.add(Calendar.DATE, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY);
        return dateFormat.format(now.getTime());
    }

    /**
     * 获取明天日期 返回字符串
     */
    public static String getTomorrow(String dateStr) {
        Timestamp date = parseToDate(dateStr);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.setTime(date);
        calendar.add(Calendar.DATE, 1);
        SimpleDateFormat dateFormat = new SimpleDateFormat(YEAR_MONTH_DAY);
        return dateFormat.format(calendar.getTime());
    }

    /**
     * 计算两个日期的差，参数null表示当前日期。
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDifferDays(Date date1, Date date2) {
        if (date1 != null && date2 != null) {
            return (int) ((date1.getTime() - date2.getTime()) / (24 * 60 * 60 * 1000));
        } else {
            return 0;
        }
    }

    /**
     * 计算两个日期的差，只看天数
     *
     * @param satrt
     * @param end
     * @return
     */
    public static int getDifferDate(String satrt, String end) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(parseToDate(satrt));
        calendar2.setTime(parseToDate(end));
        return calendar2.get(Calendar.DATE) - calendar1.get(Calendar.DATE);
    }

    /**
     * 日期加减
     *
     * @param date   需要加减的日期
     * @param offset 增加的天数
     */
    public static Timestamp dateAdd(Timestamp date, int offset) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.add(Calendar.DATE, offset);
        return new Timestamp(calendar.getTimeInMillis());
    }

    /**
     * 日期加减
     *
     * @param date   需要加减的日期
     * @param offset 增加的天数
     */
    public static String dateAdd(String date, int offset) {
        Timestamp timestamp = parseToDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(timestamp);
        calendar.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        calendar.add(Calendar.DATE, offset);
        return formatToDate(calendar.getTime());
    }


    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        System.out.println(formatToHour(timestamp));

    }


}
