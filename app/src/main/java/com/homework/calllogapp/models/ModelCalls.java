package com.homework.calllogapp.models;

import android.provider.CallLog;
import android.telephony.PhoneNumberUtils;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ModelCalls {

    private String number, date, type;

    public ModelCalls(String number, String date, String type) {
        this.number = number;
        this.date = date;
        this.type = type;
    }

    public String getNumber() {
        if (null != number
                && !number.isEmpty()) {
            return PhoneNumberUtils.formatNumber(number, Locale.getDefault().getCountry());
        }
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDate() {
        return getDateFormat(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {

        return getCallType(type);
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDateFormat(String date) {
        Date callDateTime = new Date(Long.valueOf(date));
        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a M-dd-yy");
        String dateString = formatter.format(callDateTime);
        return dateString;
    }

    public String getCallType(String type) {
        String callType;
        switch(Integer.parseInt(type)) {
            case CallLog.Calls.OUTGOING_TYPE:
                callType = "Outgoing";
                break;

            case CallLog.Calls.INCOMING_TYPE:
                callType = "Incoming";
                break;

            case CallLog.Calls.MISSED_TYPE:
                callType = "Missed";
                break;

            default:
                callType = "Unknown";
                break;
        }
        return callType;
    }
}
