package com.sh4man.entitylogger;

import javax.swing.*;
import java.awt.*;

public class Window {
    private JTextArea textArea;

    public Window() {
        SwingUtilities.invokeLater(this::initWindow);
    }

    public void log(String message) {
        SwingUtilities.invokeLater(() -> {
            if (textArea != null) {
                textArea.setText(message);
            }
        });
    }

    private void initWindow() {
        JFrame frame = new JFrame("Entity Logger");
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setAlwaysOnTop(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.WHITE);
        textArea.setFont(new Font("Consolas", Font.PLAIN, 20));

        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);
    }
}
