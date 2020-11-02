package com.je_chen.droidrat_je.modules.appintent.mail;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class SendMail {

    public void sendMail(Context context,String to,String subject,String text){
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"+to));
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(intent);
    }
}
