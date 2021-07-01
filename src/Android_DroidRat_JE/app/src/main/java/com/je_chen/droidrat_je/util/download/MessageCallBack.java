package com.je_chen.droidrat_je.util.download;

import java.io.File;

public interface MessageCallBack {

    void onDownloadStarted(long totalLength);

    void onDownloadProgress(long downloadedLength);

    void onDownloadComplete(File file);

    void onDownloadError(Exception e);

}
