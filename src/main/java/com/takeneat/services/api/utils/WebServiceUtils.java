package com.takeneat.services.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author paoesco
 */
public final class WebServiceUtils {

    public static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private WebServiceUtils() {
    }

    public static String formatDate(Date date) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public static Date toDate(String source) {
        if (Objects.isNull(source)) {
            return null;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.parse(source);
        } catch (ParseException ex) {
            Logger.getLogger(WebServiceUtils.class.getName()).log(Level.INFO, null, ex);
            return null;
        }
    }

}
