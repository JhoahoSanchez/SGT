package org.clases;
public class Cuenta {
    private String correo;
    private String password;
    private ListaDeTarea listaDeTareas;
    public static ListaDeCategoria listaDeCategorias;

    public Cuenta(String correo, String password){
        this.correo =  correo;
        this.password = password;
        listaDeTareas = new ListaDeTarea();
        listaDeCategorias = new ListaDeCategoria();
    }

    public boolean validar(String correo, String password){
        //validar las credenciales de la cuenta
        return this.correo.equals(correo) && this.password.equals(password)?true:false;
    }

    public ListaDeTarea getListaTareas() {

        return listaDeTareas;
    }

    public ListaDeCategoria getListaCategorias() {
        return listaDeCategorias;
    }
     
    // public void registrarTarea(Tarea tarea) {
    //     listaDeTareas.agregarTarea(tarea);
    // }

}
