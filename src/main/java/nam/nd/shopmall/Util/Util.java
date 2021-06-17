package nam.nd.shopmall.Util;


import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * @author nam.nd
 * @created 17/06/2021 - 8:08 PM
 */
public class Util implements Serializable {

    public final static String DATE_FORMATTER = "dd/MM/yyyy";

    public final static DateTimeFormatter STANDARD_DATE_FORMATTER = DateTimeFormatter
            .ofPattern(DATE_FORMATTER).withZone(ZoneId.from(ZoneOffset.UTC));

    public static String instantToString(Instant instant) {
        if (instant == null) {
            return null;
        }
        return STANDARD_DATE_FORMATTER.format(instant);
    }

    public static Instant stringToInstant(String strDate) {
        if (StringUtils.isEmpty(strDate)) {
            return null;
        }
        return Instant.from(STANDARD_DATE_FORMATTER.parse(strDate));
    }


    public static void trimStringValuesOfObject(Object model) {
        for (Field field : model.getClass().getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object value = field.get(model);
//                String fieldName = field.getName();
                if (value != null) {
                    if (value instanceof String) {
                        String trimmed = (String) value;
                        field.set(model, trimmed.trim());
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Long stringToLong(String value) {
        try {
            return Long.parseLong(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String longToString(Long l) {
        try {
            return String.valueOf(l);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static Double stringToDouble(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String doubleToString(Double number) {
        try {
            return String.valueOf(number);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static String getTextParam(String message, String... params) {
        return MessageFormat.format(message, (Object[]) params);
    }
}
