package org.clases;

import org.example.CategoriaEntity;

public class ListaDeCategoria {
    private CategoriaEntity[] categorias;
    private final int NUM_MAXIMO_CATEGORIAS = 20;

    public ListaDeCategoria(){
        this.categorias = new CategoriaEntity[NUM_MAXIMO_CATEGORIAS];
    }

    public void agregarCategoria(CategoriaEntity categoria){
        categorias[obtenerNumeroDecategoria()] = categoria;
    }

    private int obtenerNumeroDecategoria() {
        int numeroDeCategoria = 0;
        for(CategoriaEntity categoria : categorias){
            if(categoria == null){
                break;
            }
            numeroDeCategoria++;
        }
        return numeroDeCategoria;
    }

    public void quitarCategoria(CategoriaEntity categoria){
        for(int i=0; i <= obtenerNumeroDecategoria();i++){
            if(categorias[i]!=null && categorias[i].equals(categoria)){
                categorias[i]=null;
                break;
            }
        }
    }

    public CategoriaEntity[] getListaCategorias(){
        return this.categorias;
    }

    public boolean buscarcategoria(CategoriaEntity categoria) {
        for(CategoriaEntity categorias : categorias){
            if(categorias != null && categorias == categoria){
                return true;
            }
        }
        return false;
    }
}
