/*
 * Copyright (c) 2018. JE-Chen
 * Edit by JE 2020/1/1
 */

package com.je_chen.droidrat_je.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import static android.content.Context.MODE_PRIVATE;

public class FileIO {

    private String path = "null";
    private String fileName = "null";
    private File sdPath = null;

    //設置檔案路徑
    public void set_path(String path) {
        this.path = path;
    }

    //設置檔案檔名
    public void set_fileName(String fileName) {
        this.fileName = fileName;
    }

    //設置檔案路徑跟檔名
    public void set_pathFilename(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }

    public void set_sdPath(File sdPath) {
        this.sdPath = sdPath;
    }

    public void saveFile(String fileName, String data, Context activity) throws IOException {
        FileOutputStream out = activity.getApplicationContext().openFileOutput(fileName, MODE_PRIVATE);
        OutputStreamWriter sw = new OutputStreamWriter(out);
        sw.write(data);
        sw.flush();
        sw.close();
    }

    public String readFile(String fileName, int readBlockSize, Context activity) throws IOException {
        FileInputStream in = activity.openFileInput(fileName);
        InputStreamReader sr = new InputStreamReader(in);
        char[] buffer = new char[readBlockSize];
        StringBuilder readString = new StringBuilder(" ");
        int count;
        while ((count = sr.read(buffer)) > 0) {
            String s = String.copyValueOf(buffer, 0, count);
            readString.append(s);
            buffer = new char[readBlockSize];
        }
        sr.close();
        return readString.toString();
    }


    //搜尋檔案是否存在
    public boolean searchFile(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
        boolean file_exist = false;
        File exist = new File(path);
        if (exist.getName().equals(fileName)) {
            file_exist = exist.exists();
        }
        return file_exist;
    }

    //搜尋檔案是否存在
    public boolean searchFile(File sdPath, String fileName) {
        this.sdPath = sdPath;
        this.fileName = fileName;
        boolean file_exist = false;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            String search_path = (sdPath.getPath() + fileName);
            File search_file = new File(search_path);
            file_exist = search_file.exists();
        }
        return file_exist;
    }

    //搜尋檔案是否存在
    public boolean searchFile(String path, String fileName, File sdPath) {
        this.path = path;
        this.fileName = fileName;
        boolean file_exist = false;
        boolean sdCardExist = Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
        if (sdCardExist) {
            String search_path = (sdPath.getPath() + fileName);
            File search_out_file = new File(search_path);
            File search_in_file = new File(path + fileName);
            file_exist = search_out_file.exists() || search_in_file.exists();
        }

        return file_exist;
    }

    //是否安裝此檔案
    public boolean appInstalled(Context context, String name) {
        PackageManager manager = context.getPackageManager();
        List<PackageInfo> pkgList = manager.getInstalledPackages(0);
        for (int i = 0; i < pkgList.size(); i++) {
            PackageInfo pI = pkgList.get(i);
            if (pI.packageName.equalsIgnoreCase(name))
                return true;
        }
        return false;
    }

    public void listFile(String dirPath, ArrayList<File> files) {
        File directory = new File(dirPath);
        // get all the files from a directory
        File[] fileList = directory.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                listFile(file.getAbsolutePath(), files);
            }
        }
    }

}


