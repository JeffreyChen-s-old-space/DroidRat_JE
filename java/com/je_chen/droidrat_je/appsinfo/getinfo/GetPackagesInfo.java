package com.je_chen.droidrat_je.appsinfo.getinfo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class GetPackagesInfo {

    private PackageManager packageManager;

    public GetPackagesInfo(PackageManager packageManager){
        this.packageManager=packageManager;
    }

    // 取得info
    public List<ResolveInfo> getResolveInfo(){
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        @SuppressLint("QueryPermissionsNeeded")
        List<ResolveInfo> packageAppsList = packageManager.queryIntentActivities( mainIntent, 0);
        return packageAppsList;
    }

    //取得所有安裝非系統的APP 名字
    public List getInstalledPackages() {
        List<String> installedApps = new ArrayList<>();
        @SuppressLint("QueryPermissionsNeeded")
        List<PackageInfo> packageAppsList = packageManager.getInstalledPackages(0);
        for (int i = 0; i < packageAppsList.size(); i++) {
            PackageInfo packInfo = packageAppsList.get(i);
            if ((packInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                String appName = packInfo.applicationInfo.loadLabel(packageManager).toString();
                installedApps.add(appName);
            }
        }
        return installedApps;
    }

    public int checkAnotherPermission(String permissionName, String packageName) {
        return this.packageManager.checkPermission(permissionName, packageName);
    }

    public int checkAnotherSignature(int uid1, int uid2) {
        return this.packageManager.checkSignatures(uid1, uid2);
    }

    public String getPackageInfo(String packageName) throws PackageManager.NameNotFoundException {
        return String.valueOf(packageManager.getPackageInfo(packageName,PackageManager.GET_PERMISSIONS));
    }

    public Drawable getApplicationIcon(String packageName) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationIcon(packageName);
    }

    public ApplicationInfo getApplicationInfo(String packageName, int flag) throws PackageManager.NameNotFoundException {
        return packageManager.getApplicationInfo(packageName,flag);
    }

}
