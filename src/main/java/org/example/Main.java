package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                CtripSearchTestGUI gui = new CtripSearchTestGUI();
                gui.setVisible(true);
            }
        });
    }
}