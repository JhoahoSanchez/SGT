package org.clases;

import org.example.CategoriaEntity;

public class Tarea {
    private Fecha fechaCreacion;
    private Fecha fechaVencimiento;
    private CategoriaEntity categoria;
    private RecordatorioTarea recordatorioTarea;
    private String descripcion;
    private Estado estado;

    public Tarea(String descripcion, Fecha fechaVencimiento, CategoriaEntity categoria, Estado estado){
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("No puede crear una tarea con descripcion nula");
        }
        this.descripcion = descripcion;

        this.fechaCreacion = new Fecha();
        if(fechaVencimiento == null){
            throw new IllegalArgumentException("Debe seleccionar la fecha de vencimiento");
        }
        this.fechaVencimiento = fechaVencimiento;
        if(categoria.getDescripcion().equals("")){
            throw new IllegalArgumentException("Debe ingresar una categoria para la tarea");
        }
        if(!existeCategoria(categoria)){
            throw new IllegalArgumentException("Debe ingresar el nombre la descripcion de una de las categorias registradas");
        }
        this.categoria =  categoria;
        this.estado = estado;
    }

    public Tarea(String descripcion, Fecha fechaVencimiento, RecordatorioTarea recordatorioTarea, CategoriaEntity categoria, Estado estado){
        if(descripcion.isEmpty()){
            throw new IllegalArgumentException("No puede crear una tarea con descripcion nula");
        }
        this.descripcion = descripcion;
        this.fechaCreacion = new Fecha();
        if(fechaVencimiento == null){
            throw new IllegalArgumentException("Debe seleccionar la fecha de vencimiento");
        }
        this.fechaVencimiento = fechaVencimiento;
        this.recordatorioTarea = recordatorioTarea;
        if(categoria.getDescripcion().equals("")){
            throw new IllegalArgumentException("Debe ingresar una categoria para la tarea");
        }

        if(!existeCategoria(categoria)){
            throw new IllegalArgumentException("Debe ingresar el nombre la descripcion de una de las categorias registradas");
        }
        this.categoria = categoria;
        this.estado = estado;
    }

    public void cambiarEstado() {
        if(this.estado.actualizar()){
            this.estado = new Completado();
        }else{ this.estado = new Pendiente();}

    }

    public void modificarFechaVencimiento(String nuevaFechaVencimiento) {
        if(recordatorioTarea == null){
            this.fechaVencimiento = new Fecha(nuevaFechaVencimiento);
        }else{
            if(recordatorioTarea.verificar(this, nuevaFechaVencimiento)){
                this.fechaVencimiento = new Fecha(nuevaFechaVencimiento);
            }else{System.out.println("No puede ingresar una fecha de vencimiento anterior a la ya establecida");}
        }
    }

    private boolean existeCategoria(CategoriaEntity categoria) {
        for(CategoriaEntity categorias : Cuenta.listaDeCategorias.getListaCategorias()){
            if( categorias != null && categoria.getDescripcion().equals(categorias.getDescripcion())){
                return true;
            }
        }
        return false;
    }

    public Fecha getFechaVencimiento() {
        return fechaVencimiento;
    }


    @Override
    public String toString() {
        return "Tarea  con fechaCreacion:" + fechaCreacion + ", fechaVencimiento:" + fechaVencimiento + ", categoria="
                + categoria + ", recordatorioTarea: " + recordatorioTarea + ", descripcion: " + descripcion + ", estado:"
                + estado;
    }


}
