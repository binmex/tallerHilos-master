package vista;

import javax.swing.*;

public class runTaller {
    public static void main(String[] args) {
        //guiModel gui = new guiModel();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new guiModel();
                frame.setSize(1000,600);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            }
        });
        new guiModel();
    }
}
