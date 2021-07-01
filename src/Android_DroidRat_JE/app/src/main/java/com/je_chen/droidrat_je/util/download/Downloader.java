package com.je_chen.droidrat_je.util.download;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.UiThread;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okio.BufferedSink;
import okio.Okio;

public class Downloader {
    private static final long BUFFER_SIZE = 2048;
    private static final long FLUSH_SIZE = 1048 * 1048;    // 1MB
    private static final long UPDATE_RATE = 1000;

    private MessageCallBack callBack;

    private final ExecutorService mExecutorService;
    private final Handler mHandler;

    @UiThread
    public Downloader(int threadCount) {
        mExecutorService = Executors.newFixedThreadPool(threadCount);
        mHandler = new Handler(Objects.requireNonNull(Looper.myLooper()));
    }

    public void download(final String url, final String path, final String fileName, final MessageCallBack callback) {
        mExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                downloadFile(url, path, fileName, callback);
            }
        });
    }

    private void downloadFile(String url, String path, String fileName, MessageCallBack callback) {
        try {
            File downloadDir = new File(path);
            downloadDir.mkdirs();

            // Naively read filename from url

            File file = new File(downloadDir, fileName);

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder().url(url).build();
            Response response = null;

            response = client.newCall(request).execute();

            BufferedSink sink = Okio.buffer(Okio.sink(file));

            long totalLength = Objects.requireNonNull(response.body()).contentLength();
            notifyStarted(callback, totalLength);

            long downloadedLength = 0;
            long bufferSize = 0;
            long lastUpdate = 0;
            while (true) {
                long length = Objects.requireNonNull(response.body()).source().read(sink.getBuffer(), BUFFER_SIZE);

                if (length < 0) break;

                downloadedLength += length;
                bufferSize += length;

                // Avoid overflowing the cache
                if (bufferSize >= FLUSH_SIZE) {
                    sink.flush();
                    bufferSize = 0;
                }

                if (System.currentTimeMillis() > (lastUpdate + UPDATE_RATE)) {
                    notifyProgress(callback, downloadedLength);
                    lastUpdate = System.currentTimeMillis();
                }
            }

            sink.close();

            notifyComplete(callback, file);
        } catch (IOException e) {
            e.printStackTrace();
            notifyError(callback, e);
        }
    }

    private void notifyStarted(final MessageCallBack callback, final long totalLength) {
        mHandler.post(() -> callback.onDownloadStarted(totalLength));
    }

    private void notifyProgress(final MessageCallBack callback, final long downloadedLength) {
        mHandler.post(() -> callback.onDownloadProgress(downloadedLength));
    }

    private void notifyComplete(final MessageCallBack callback, final File file) {
        mHandler.post(() -> callback.onDownloadComplete(file));
    }

    private void notifyError(final MessageCallBack callback, final Exception e) {
        mHandler.post(() -> callback.onDownloadError(e));
    }
}