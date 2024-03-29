package com.je_chen.droidRat.gui.sensorgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SensorGui extends GuiFather implements GuiFatherInterface {
    private static SensorGui Instance;
    private JPanel jPanel;

    public static synchronized SensorGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new SensorGui();
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
