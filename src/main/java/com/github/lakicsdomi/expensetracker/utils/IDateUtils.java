package com.github.lakicsdomi.expensetracker.utils;

import java.util.Date;

public interface IDateUtils {
    String formatDate(Date date);
    Date parseDate(String dateString) throws Exception;
}
