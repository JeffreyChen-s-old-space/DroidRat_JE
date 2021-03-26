package com.je_chen.droidrat_je.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPSocketClient {

    private DatagramSocket datagramSocket;
    private InetAddress address;
    private int port;
    private byte[] buffer;

    public UDPSocketClient(int port) throws SocketException {
        datagramSocket = new DatagramSocket();
        this.port = port;
    }

    public void sendMessage(String message) throws IOException {
        //send data
        address = InetAddress.getLocalHost();
        buffer = message.getBytes();
        DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length, address, this.port);
        datagramSocket.send(datagramPacket);
    }

    public void disconnect() {
        datagramSocket.disconnect();
    }

    public void close() {
        datagramSocket.close();
    }

}
