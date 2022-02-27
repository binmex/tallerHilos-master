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

                    if (tldAutorizaciones.getText().length()==0){
                        //JOptionPane.showMessageDialog(null,"esta vacio");
                        turnoAutorizaciones.setText("No se han asignado Autorizaciones");
                    }else {
                        turnoAutorizaciones.setText(envio.getTurno2());
                        envio.agregarTurnoAutorizaciones(tldAutorizaciones.getText());
                        tldAutorizaciones.setText("");
                    }


            }
        });
        envio.iniciosHilos2();

        aceptarButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tIdCitas.getText().length() == 0){
                    turnoCitas.setText("No se han asignado citas");
                }else {
                    turnoCitas.setText(envio.getTurno());
                    envio.agregarTurnoCitas(tIdCitas.getText());
                    tIdCitas.setText("");
                }


            }
        });

    }

    public  void addComponents(){
        setContentPane(panelPrincipal);
    }

}
