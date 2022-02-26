package vista;

import control.Hilos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.awt.*;

public class guiModel extends JFrame {
    Hilos envio = new Hilos();

    private JPanel izqPanel;
    private JPanel derPanel;
    private JPanel panelPrincipal;


    private JTextField tIdCitas;
    private JTextField tldAutorizaciones;

    private JLabel lCitas;
    private JLabel lId;
    private JLabel turnoCitas;
    private JLabel lAutorizaciones;
    private JLabel labelIdAutorizaciones;
    private JLabel turnoAutorizaciones;

    private JButton aceptar2;
    private JButton aceptarButton1;


    public guiModel() {
        addComponents();
        envio.iniciosHilos1();

        aceptar2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                turnoAutorizaciones.setText(envio.getTurno());
                envio.agregarTurnoAutorizaciones(tldAutorizaciones.getText());
                panelPrincipal.updateUI();
                panelPrincipal.invalidate();
                panelPrincipal.validate();
                panelPrincipal.repaint();
                //envio.agregarTurnoCitas(turnoAutorizaciones.getText());
                //JOptionPane.showMessageDialog(null,"envio exitoso");
                tldAutorizaciones.setText("");
            }
        });
        envio.iniciosHilos2();

        aceptarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(tIdCitas.getText());
                turnoCitas.setText(envio.getTurno2());

                //turnoAutorizaciones.setText(envio.getTurno());
                envio.agregarTurnoCitas(tIdCitas.getText());
                panelPrincipal.invalidate();
                panelPrincipal.validate();
                panelPrincipal.repaint();
                panelPrincipal.updateUI();
                //JOptionPane.showMessageDialog(null, "Registro Actualizado"+ tIdCitas.getText());
                tIdCitas.setText("");
            }
        });

    }

    public  void addComponents(){
        setContentPane(panelPrincipal);
    }

}
