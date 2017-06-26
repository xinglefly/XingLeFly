package com.xinglefly.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TimeUtil {


	// 时间计数器，最多只能到99小时，如需要更大小时数需要改改方法
	public static String getTimeCount(long time) {
		System.out.println("time=" + time);
		if (time >= 360000000) {
			return "00:00:00";
		}
		String timeCount = "";
		long hourc = time / 3600000;
		String hour = "0" + hourc;
		// System.out.println("hour=" + hour);
		hour = hour.substring(hour.length() - 2, hour.length());
		// System.out.println("hour2=" + hour);

		long minuec = (time - hourc * 3600000) / (60000);
		String minue = "0" + minuec;
		// System.out.println("minue=" + minue);
		minue = minue.substring(minue.length() - 2, minue.length());
		// System.out.println("minue2=" + minue);

		long secc = (time - hourc * 3600000 - minuec * 60000) / 1000;
		String sec = "0" + secc;
		// System.out.println("sec=" + sec);
		sec = sec.substring(sec.length() - 2, sec.length());
		// System.out.println("sec2=" + sec);
		timeCount = hour + ":" + minue + ":" + sec;
		// System.out.println("timeCount=" + timeCount);
		return timeCount;
	}

	public static String getFormatedDateTime(long dateTime) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sDateFormat.format(new Date(dateTime + 0));
	}

	public static String getSecondFormatedDateTime(long dateTime) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return sDateFormat.format(new Date(dateTime + 0));
	}

	public static String getFormatedDate(long dateTime) {
		SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return sDateFormat.format(new Date(dateTime + 0));
	}

    public static String getFormatedDateTimeHM(long dateTime) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return sDateFormat.format(new Date(dateTime * 1000 + 0));
    }

    public static int getCurrentDate() {
        Calendar c = Calendar.getInstance();
        StringBuffer dateStr = new StringBuffer();
        dateStr.append(c.get(Calendar.YEAR));
        dateStr.append(c.get(Calendar.MONTH) + 1);
        dateStr.append(c.get(Calendar.DATE));

        return Integer.parseInt(dateStr.toString());
    }


    /**
     * 根据当前日期格式化时间,返回昨天,前天或详细时间
     * 当日显示具体时间（时、分）；t+1显示昨天+时间；t+2至t+4显示星期数+时间；t+5及以上显示日期+时间
     *
     * @param dateTime 毫秒
     * @return
     */
    public static String getMessageTimeString(long dateTime) {
        String display = "";
        Date today = new Date();
        Date tDate = new Date(dateTime);

        SimpleDateFormat thisYearDf = new SimpleDateFormat("yyyy");
        SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd");

        long tMin = 60 * 1000;
        long tHour = 60 * tMin;
        long tDay = 24 * tHour;

        try {
            Date thisYear = new Date(thisYearDf.parse(thisYearDf.format(today)).getTime());
            Date yesterday = new Date(todayDf.parse(todayDf.format(today)).getTime());
            Date beforeYes = new Date(yesterday.getTime() - tDay);
            Date withinfourDays = new Date(yesterday.getTime() - tDay * 4);

            if (tDate != null) {
                long dTime = today.getTime() - tDate.getTime();
                if (tDate.before(thisYear)) {
                    display = new SimpleDateFormat("yyyy年MM月dd日 HH:mm").format(tDate);
                } else {
                    if (dTime < tDay && tDate.after(yesterday)) {
                        display = new SimpleDateFormat("HH:mm").format(tDate);
                    } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                        display = "昨天 " + new SimpleDateFormat("HH:mm").format(tDate);
                    } else if (tDate.after(withinfourDays) && tDate.before(beforeYes)) {
                        Calendar calendar = Calendar.getInstance();
                        Locale.setDefault(Locale.CHINA);
                        calendar.setTime(tDate);
                        display =getDayOfWeekString(calendar.get(Calendar.DAY_OF_WEEK)) + " " + new SimpleDateFormat("HH:mm").format(tDate);
                    }else{
                        display = new SimpleDateFormat("MM月dd日 HH:mm").format(tDate);
                    }
                }
            }
        } catch (Exception e) {
            return display;
        }

        return display;
    }
    /**
     * 根据当前日期格式化时间,返回昨天,前天或详细时间
     * 当日显示具体时间（时、分）；t+1显示昨天+时间；t+2至t+4显示星期数+时间；t+5及以上显示日期+时间
     *
     * @param dateTime 毫秒
     * @return
     */
    public static String getMessageTimeStringLikeWechat(long dateTime) {
        String display = "";
        Date today = new Date();
        Date tDate = new Date(dateTime);

        SimpleDateFormat thisYearDf = new SimpleDateFormat("yyyy");
        SimpleDateFormat todayDf = new SimpleDateFormat("yyyy-MM-dd");

        long tMin = 60 * 1000;
        long tHour = 60 * tMin;
        long tDay = 24 * tHour;

        try {
            Date thisYear = new Date(thisYearDf.parse(thisYearDf.format(today)).getTime());
            Date yesterday = new Date(todayDf.parse(todayDf.format(today)).getTime());
            Date beforeYes = new Date(yesterday.getTime() - tDay);
            Date withinfourDays = new Date(yesterday.getTime() - tDay * 4);

            if (tDate != null) {
                long dTime = today.getTime() - tDate.getTime();
                if (tDate.before(thisYear)) {
                    display = new SimpleDateFormat("yyyy/MM/dd HH:mm").format(tDate);
                } else {
                    if (dTime < tDay && tDate.after(yesterday)) {
                        display = new SimpleDateFormat("HH:mm").format(tDate);
                    } else if (tDate.after(beforeYes) && tDate.before(yesterday)) {
                        display = "昨天 " + new SimpleDateFormat("HH:mm").format(tDate);
                    } else if (tDate.after(withinfourDays) && tDate.before(beforeYes)) {
                        Calendar calendar = Calendar.getInstance();
                        Locale.setDefault(Locale.CHINA);
                        calendar.setTime(tDate);
                        display =getDayOfWeekString(calendar.get(Calendar.DAY_OF_WEEK)) + " " + new SimpleDateFormat("HH:mm").format(tDate);
                    }else{
                        display = new SimpleDateFormat("MM/dd HH:mm").format(tDate);
                    }
                }
            }
        } catch (Exception e) {
            return display;
        }

        return display;
    }

    private static String getDayOfWeekString(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
        }
        return "";
    }

}