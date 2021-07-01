package com.je_chen.droidrat_je.rat.modules.appintent.setting;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

public class Setting {

    public void toPackageSetting(Context context,String packageName){
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package", packageName, null);
        intent.setData(uri);
        context.startActivity(intent);
    }

}
