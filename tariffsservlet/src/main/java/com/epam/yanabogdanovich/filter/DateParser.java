package com.epam.yanabogdanovich.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParser {
    private static final Logger LOGGER = LogManager.getLogger(DateParser.class);

    private static final String DEFAULT_PATTERN = "yyyy-MM-dd";

    private static SimpleDateFormat dateFormat = new SimpleDateFormat(DEFAULT_PATTERN);

    public static Date parseDate(String date) {
        Date date1 = null;
        try {
            date1 = dateFormat.parse(date);
        } catch (ParseException e) {
            LOGGER.error("Data format exception! ", e.getLocalizedMessage());
        }
        return date1;
    }
}
