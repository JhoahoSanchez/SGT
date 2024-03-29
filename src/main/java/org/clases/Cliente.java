package org.clases;

import org.example.CategoriaEntity;

import java.util.Objects;

public class Cliente {
    private String nombre;
    private String apellido;
    private int edad;
    private Cuenta cuenta;

    public Cliente(String nombre, String apellido, int edad, Cuenta cuenta){
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cuenta = cuenta;
    }

    public boolean iniciarSesion(String correo, String password){
        return cuenta.validar(correo, password);
    }

    public void crearTarea(Tarea tarea) {
        cuenta.getListaTareas().agregarTarea(tarea);
    }

    public void quitarTarea(Tarea tarea) {
        cuenta.getListaTareas().quitarTarea(tarea);;
    }

    public void cambiarEstadoTarea(Tarea tarea) {
        if(cuenta.getListaTareas().buscarTarea(tarea)){
            tarea.cambiarEstado();
        }
    }

    public void crearCategoria(CategoriaEntity categoria) {
        cuenta.getListaCategorias().agregarCategoria(categoria);
    }

    public void modificarFechaVencimientoTarea(Tarea tarea, String nuevaFechaVencimiento) {
        if(cuenta.getListaTareas().buscarTarea(tarea)){
            tarea.modificarFechaVencimiento(nuevaFechaVencimiento);
        }

    }

    public void listarTarea() {
        Tarea[] listaDeTareas = cuenta.getListaTareas().getListaTareas();
        for(int i=0; i < listaDeTareas.length;i++){
            if(!Objects.isNull(listaDeTareas[i])){
                System.out.println(listaDeTareas[i]);
                System.out.println("--------------");
            }
        }
    }

    public void listarCategoria() {
        CategoriaEntity[] listaDeCategorias = cuenta.getListaCategorias().getListaCategorias();
        for(int i=0; i < listaDeCategorias.length;i++){
            if(!Objects.isNull(listaDeCategorias[i])){
                System.out.println(listaDeCategorias[i]);
                System.out.println("--------------");
            }
        }
    }

    public void buscarTareaPorFecha(String fecha) {
        Tarea[] tarea = cuenta.getListaTareas().buscarTareaPorFecha(fecha);
        for(int i=0;i<tarea.length;i++){
            if(tarea[i]!=null){
                System.out.println(tarea[i]);
            }
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public void setCuenta(Cuenta cuenta) {
        this.cuenta = cuenta;
    }  
}
