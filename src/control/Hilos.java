package control;

import modelo.Turno;
import persistencia.DaoTurnos;

import java.util.ArrayList;

public class Hilos{
    DaoTurnos hilo1 = new DaoTurnos();
    DaoTurnos hilo2 = new DaoTurnos();

    private ArrayList<Turno> ListadoTurnos;

    public Hilos(){
        ListadoTurnos = new DaoTurnos().mostrarTurnos();
    }
    int i = 1;
    int j = 1;
    Turno p = new Turno();
    Turno p2 = new Turno();

    synchronized public void agregarTurnoCitas(String id) {
        p.setCode("C"+i++);
        p.setId(id);
        System.out.println(p.getCode());
        System.out.println(Thread.currentThread().getName());
        try {
            hilo1.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo1.asignacioVariable(p);
        //ListadoTurnos = new DaoTurnos().mostrarTurnos();

    }
    synchronized public void agregarTurnoAutorizaciones(String id) {
        p2.setCode("A" + j++);
        p2.setId(id);
        System.out.println(p2.getCode());

        try {
            hilo2.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo2.asignacioVariable(p2);
        //ListadoTurnos = new DaoTurnos().mostrarTurnos();
    }
    

    synchronized public void iniciosHilos1(){
        hilo1.start();
    }

    synchronized public void iniciosHilos2(){
        hilo2.start();
    }

}
