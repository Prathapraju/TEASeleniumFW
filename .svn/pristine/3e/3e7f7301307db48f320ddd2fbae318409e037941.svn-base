/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package us.tx.state.tea.seleniumfw.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang3.time.DateUtils;

/**
 *
 * @author ckutac
 */
public class CreateDate {
    static Locale currentLocale = Locale.US;
    static Date today;
    static String output;
    static SimpleDateFormat formatter;
    
    static public String newDate(String pattern) {
        formatter = new SimpleDateFormat(pattern, currentLocale);
        today = new Date();
        output = formatter.format(today);
        return output;
    }
    
    static public String newDate(String pattern, String days) {
        formatter = new SimpleDateFormat(pattern, currentLocale);
        today = new Date();
        Date newdate = DateUtils.addDays(today, Integer.valueOf(days));
        output = formatter.format(newdate);
        return output;
    }
    
}
