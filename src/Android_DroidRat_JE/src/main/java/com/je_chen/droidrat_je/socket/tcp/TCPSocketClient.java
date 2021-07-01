package com.je_chen.droidrat_je.util.socket.tcp;

import java.io.*;
import java.net.Socket;

public class TCPSocketClient implements Runnable{

    private Socket Client_Socket;
    private PrintWriter Client_Output;
    private BufferedReader Client_Input;
    private String Socket_ID;
    private String Server_IP;
    private int Server_Port;
    private int Test_Time = 1000;

    public TCPSocketClient(String ID, String Server_IP, int Server_Port){
        this.Socket_ID = ID;
        this.Server_IP = Server_IP;
        this.Server_Port = Server_Port;
    }

    public void SetSocket() throws IOException {
        Client_Socket = new Socket(this.Server_IP,this.Server_Port);
        Client_Output = new PrintWriter(Client_Socket.getOutputStream(),true);
        Client_Input = new BufferedReader(new InputStreamReader(Client_Socket.getInputStream()));
    }

    public String SendMessage(String Message) throws IOException {
        Client_Output.println(Message);
        return Client_Input.readLine();
    }

    public void Disconnect() throws IOException {
        Client_Output.close();
        Client_Input.close();
        Client_Socket.close();
    }

    public void Set_Test_Time(int Time){
        this.Test_Time = Time;
    }



    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Test_Time);
                this.SetSocket();
                System.out.println(this.SendMessage("Hello"));
                /* TODO 放在需要斷線的時候
                this.Disconnect();
                 */
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    this.Client_Socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
