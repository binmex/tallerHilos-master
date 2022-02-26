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
            hilo1.sleep(1000);
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
            hilo2.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo2.asignacioVariable(p2);
        //ListadoTurnos = new DaoTurnos().mostrarTurnos();
    }

    public String getTurno(){
        int posicion = hilo1.mostrarTurnos().size();
        System.out.println(hilo1.mostrarTurnos().size());
        if (posicion <= 0){
            return "Esperando Turno";
        }else {
            return hilo1.mostrarTurnos().get(posicion-1).getCode();
        }
    }

    public String getTurno2(){
        int posicion2 = hilo2.mostrarTurnos().size();
        System.out.println(hilo2.mostrarTurnos().size());
        if (posicion2 <= 0){
            return "Esperando Turno";
        }else {
            return hilo2.mostrarTurnos().get(posicion2-1).getCode();
        }
    }
    

    synchronized public void iniciosHilos1(){
        hilo1.start();
    }

    synchronized public void iniciosHilos2(){
        hilo2.start();
    }

}
