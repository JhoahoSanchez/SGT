package org.clases;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ListaDeTarea{
    private Tarea[] tareas;
    private final int NUM_MAXIMO_TAREAS = 25;

    public ListaDeTarea(){
        this.tareas = new Tarea[NUM_MAXIMO_TAREAS];
    }

    public void agregarTarea(Tarea tarea){
        tareas[obtenerNumeroDeTarea()] = tarea;
    }

    private int obtenerNumeroDeTarea() {
        int numeroDeTarea = 0;
        for(Tarea tarea : tareas){
            if(tarea == null){
                break;
            }
            numeroDeTarea++;
        }
        return numeroDeTarea;
    }

    public void quitarTarea(Tarea tarea){
        for(int i=0; i <= obtenerNumeroDeTarea();i++){
            if(tareas[i]!=null && tareas[i].equals(tarea)){
                tareas[i]=null;
                break;
            }
        }
    }

    public Tarea[] getListaTareas(){
        return this.tareas;
    }

    public boolean buscarTarea(Tarea tarea) {
        for(Tarea tareas : tareas){
            if(tareas != null && tareas == tarea){
                return true;
            }
        }
        return false;
    }

    public Tarea[] buscarTareaPorFecha(String fecha) {
        Tarea[] tareasEncontradas = new Tarea[25];
        int numeroDeTarea = 0;
        LocalDate fechaT = LocalDate.parse(fecha, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        for(Tarea tareas : tareas){
            if(tareas != null && tareas.getFechaVencimiento().retornarFecha().equals(fechaT)){
                tareasEncontradas[numeroDeTarea] = tareas;
                numeroDeTarea++;
            }
        }
        return tareasEncontradas;
    }


}