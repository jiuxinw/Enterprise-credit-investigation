/**
 * Copyright (C), 2015-2021, XXX有限公司
 * FileName: run
 * Author:   liyou
 * Date:     2021/7/26 14:40
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 * <p>
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/26
 * @since 1.0.0
 */
/**
 * 〈一句话功能简述〉<br> 
 * 〈〉
 *
 * @author liyou
 * @create 2021/7/26
 * @since 1.0.0
 */
package com.cn.ecig.demo.comment.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class run {
    public static String getDate(String month,int num,String dateType,String flag) throws ParseException {
        month="20200601";
        num=1;
        dateType="2";
        flag="2";
        //指定日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date data = sdf.parse(month);
        int num1 = num;
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(data);
        if("1".equals(dateType)) {
            num1=num;
        }else if("2".equals(dateType)) {
            num1=num*3;
        }
        if("1".equals(flag)) {
        }else {
            num1=-num1;
        }
        rightNow.add(Calendar.MONTH,num1);//日期加几个月
        Date dt1=rightNow.getTime();
        String reStr = sdf.format(dt1);
        System.out.println(reStr);
        return reStr;
    }

    public static String[] getDATE(Date date) throws ParseException {

        SimpleDateFormat format =new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        date =new Date();
        //过去七天
        c.setTime(date);
        c.add(Calendar.DATE, -7);
        Date d = c.getTime();
        String day = format.format(d);
        //过去一月
        c.setTime(date);
        c.add(Calendar.MONTH, -1);
        Date m = c.getTime();
        String mon = format.format(m);
        //过去三个月
        c.setTime(date);
        c.add(Calendar.MONTH, -3);
        Date m3 = c.getTime();
        String mon3 = format.format(m3);
        //过去一年
        c.setTime(date);
        c.add(Calendar.YEAR, -1);
        Date y = c.getTime();
        String year = format.format(y);
        String [] res= {day,mon,mon3,year};
        return  res;
    }

//    public static void main(String[] args) throws ParseException {
//       String[] s= getDATE(new Date());
//        for (String c:s
//             ) {
//            System.out.println(c);
//
//        }
//    }
}
