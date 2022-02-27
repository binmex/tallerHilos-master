package control;

import modelo.Turno;
import persistencia.DaoAutorizaciones;
import persistencia.DaoTurnos;

import java.util.ArrayList;

public class Hilos{
    DaoTurnos hilo1 = new DaoTurnos();
    DaoAutorizaciones hilo2 = new DaoAutorizaciones();

    private ArrayList<Turno> ListadoTurnos;

    public Hilos(){
        ListadoTurnos = new DaoTurnos().mostrarTurnos();
    }
    int i = 1;
    int j = 1;
    Turno p = new Turno();
    Turno p2 = new Turno();

     public void agregarTurnoCitas(String id) {
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
    public void agregarTurnoAutorizaciones(String id) {
        p2.setCode("A" + j++);
        p2.setId(id);
        System.out.println(p2.getCode());

        try {
            hilo2.sleep(2000);
            getTurno();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hilo2.asignacioVariable(p2);
    }

    public String getTurno(){
        int posicion = hilo1.mostrarTurnos().size();
        System.out.println("tamaño Array citas: "+hilo1.mostrarTurnos().size());
        if (posicion <= 0){
            return "No se han asignado citas";
        }else {
            return hilo1.mostrarTurnos().get(posicion-1).getCode();
        }
    }

    public String getTurno2(){
        int posicion2 = hilo2.mostrarTurnos().size();
        System.out.println(hilo2.mostrarTurnos().size());
        if (posicion2 <= 0){
            return "No se han asignado autorizaciones";
        }else {
            return hilo2.mostrarTurnos().get(posicion2-1).getCode();
        }
    }
    

     public void iniciosHilos1(){
        hilo1.start();
    }

     public void iniciosHilos2(){
        hilo2.start();
    }

}
