package com.homework.calllogapp;

import com.homework.calllogapp.models.ModelCalls;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CallLogUnitTest {
    @Test
    public void modelCalls_getDateTest() {
        /* Validate getDataFormat() method */
        String number = "1234567890";
        String date = "1584285853686"; /* 8:24 AM 3-15-20 */
        String type = "2";
        String result;
        ModelCalls modelCalls = new ModelCalls(number, date, type);
        result = modelCalls.getDate(); /* via getDateFormat */
        assertEquals("8:24 AM 3-15-20", result);
    }
    @Test
    public void modelCalls_getDateFormatTest() {

        String dateInput = "1584287014157";
        String dateOutput;

        ModelCalls modelCalls = new ModelCalls("123", "123456", "3");
        dateOutput = modelCalls.getDateFormat(dateInput);
        assertEquals("8:43 AM 3-15-20", dateOutput);
    }
}
