package com.longdian.util;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtil {

    public static String formatNum(Float f, int keepCount) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < keepCount; i++) {
            s.append("0");
        }
        DecimalFormat format = new DecimalFormat("##0." + s.toString());
        return format.format(f);
    }

    public static String formatNum(String string, int keepCount) {
        return formatNum(Float.parseFloat(string), keepCount);
    }

    public static String extractFloat(String str) {
        Pattern p = Pattern.compile("(\\d+\\.\\d+)");
        //Matcher类的构造方法也是私有的,不能随意创建,只能通过Pattern.matcher(CharSequence input)方法得到该类的实例.
        Matcher m = p.matcher(str);
        //m.find用来判断该字符串中是否含有与"(\\d+\\.\\d+)"相匹配的子串
        if (m.find()) {
            //如果有相匹配的,则判断是否为null操作
            //group()中的参数：0表示匹配整个正则，1表示匹配第一个括号的正则,2表示匹配第二个正则,在这只有一个括号,即1和0是一样的
            str = m.group(1) == null ? "" : m.group(1);
        } else {
            //如果匹配不到小数，就进行整数匹配
            p = Pattern.compile("(\\d+)");
            m = p.matcher(str);
            if (m.find()) {
                //如果有整数相匹配
                str = m.group(1) == null ? "" : m.group(1);
            } else {
                //如果没有小数和整数相匹配,即字符串中没有整数和小数，就设为空
                str = "0.0";
            }
        }
        return str;
    }
}
