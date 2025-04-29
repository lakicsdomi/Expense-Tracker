package com.github.lakicsdomi.expensetracker.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils implements IDateUtils{
    private static final SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public String formatDate(Date date) {
        return formatter.format(date);
    }

    @Override
    public Date parseDate(String dateString) throws Exception {
        return formatter.parse(dateString);
    }
}
