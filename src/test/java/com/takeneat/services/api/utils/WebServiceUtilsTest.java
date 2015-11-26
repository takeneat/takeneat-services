package com.takeneat.services.api.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author paoesco
 */
public class WebServiceUtilsTest {

    private static final String TEST_STRING_DATE = "2015-01-01 23:55:10";

    @Test
    public void testFormatDateNull() {
        String result = WebServiceUtils.formatDate(null);
        Assert.assertNull(result);
    }

    @Test
    public void testFormatDateOK() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(WebServiceUtils.DATE_FORMAT);
        Date date = sdf.parse(TEST_STRING_DATE);
        String result = WebServiceUtils.formatDate(date);
        Assert.assertNotNull(result);
        Assert.assertEquals(TEST_STRING_DATE, result);
    }

    @Test
    public void testToDateNull() {
        Date result = WebServiceUtils.toDate(null);
        Assert.assertNull(result);
    }

    @Test
    public void testToDateWrongParameter() {
        Date result = WebServiceUtils.toDate("xxxx");
        Assert.assertNull(result);
    }

    @Test
    public void testToDateOK() {
        Date result = WebServiceUtils.toDate(TEST_STRING_DATE);
        Assert.assertNotNull(result);
        SimpleDateFormat sdf = new SimpleDateFormat(WebServiceUtils.DATE_FORMAT);
        String sDate = sdf.format(result);
        Assert.assertEquals(TEST_STRING_DATE, sDate);
    }

}
