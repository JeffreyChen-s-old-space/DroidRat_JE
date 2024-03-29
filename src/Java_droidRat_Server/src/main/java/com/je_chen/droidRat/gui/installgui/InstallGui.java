package com.je_chen.droidRat.gui.installgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InstallGui extends GuiFather implements GuiFatherInterface {
    private static InstallGui Instance;
    private JPanel jPanel;

    public static synchronized InstallGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new InstallGui();
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
