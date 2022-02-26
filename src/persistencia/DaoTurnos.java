package persistencia;

import java.util.ArrayList;
import modelo.Turno;
import utilidades.Archivo;

public class DaoTurnos extends Thread{
    Turno en;
    private String RUTA = "Recursos/Turno.txt";

    @Override
    public void run(){
        guardarTurno();
    }
    /**
     * metodo para agregar datos al archivo plano
     */
    public void asignacioVariable(Turno f){
        System.out.println(f.getId());
        System.out.println(f.getCode());
        this.en=f;
        //guardarTurno();
        run();
    }
    synchronized void guardarTurno() {
        if (en == null){
            //System.out.println("esta vacio");
        }else {
            System.out.println("contenido en duardar turno" + en.getId());
            new Archivo().AgregarContenido(RUTA, en.getId() + "," + en.getCode());
        }
    }

    /**
     * metodo que retorna un listado con los datos del archivo plano
     * @return retorna un Arraylist  cargado con los datos del archivo plano
     */
    public ArrayList<Turno> mostrarTurnos() {
        ArrayList<String> datos = new Archivo().ContenidoArchivo(RUTA);

        ArrayList<Turno> listadoTurnos = new ArrayList<Turno>();

        for (int i = 0; i < datos.size(); i++) {
            Turno f = new Turno();

            // Separo cada linea de datos en atributos
            String Linea[] = datos.get(i).split(",");

            f.setId(Linea[0]);
            f.setCode(Linea[1].replace(";", ""));


            listadoTurnos.add(f);

        }

        return listadoTurnos;

    }


}
