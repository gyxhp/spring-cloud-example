package com.gyx.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hp on 2018/7/11.
 */

public class test {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date parse = simpleDateFormat.parse("1111年01月01日");
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat1.format(parse);
        System.out.println(format);
    }
}
