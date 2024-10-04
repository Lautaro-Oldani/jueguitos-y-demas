package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primero;
    private Nodo ultimo;
    private int largo;

    private class Nodo {
        T valor;
        Nodo sig;
        Nodo ant;

        Nodo(T v) { valor = v; }
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null;
        largo = 0;
        
    }

    public int longitud() {
        return largo;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (largo == 0){
            primero = nuevo;
            ultimo = nuevo;
        } else {
            primero.ant = nuevo
            nuevo.sig = primero
            primero = nuevo
        }
        largo += 1;
    }

    public void agregarAtras(T elem) {
        Nodo nuevo = new Nodo(elem);
        if (largo == 0) {
            primero = nuevo
            ultimo = nuevo
        } else {
            ultimo.sig = nuevo;
            nuevo.ant = ultimo;
            ultimo = nuevo;
           
        } 
        largo += 1;
    }

    public T obtener(int i) {
       Nodo posicion = primero;
       int j = 0;
       while (j != i){
        posicion = posicion.sig;
        j += 1;
       }
       return posicion.valor;
    }

    public void eliminar(int i) {
        Nodo posicion = primero;

        int j = 0;
        if (i == 0){
            primero = posicion.sig;
        } else if (i == largo - 1){
            while(j != i-1){
             posicion = posicion.sig;
             j += 1;
            }
            posicion.sig = null;
        } else {
            while(j != i){
             posicion = posicion.sig;
             j += 1;
            actual.ant.sig = actual.sig;
            actual.sig.ant = actual.ant;
        }
        largo -= 1;
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nuevo = new Nodo(elem);
        Nodo posicion = primero;
        int j = 0

        while(j != i){
             posicion = posicion.sig;
             j += 1;
        }
        posicion.valor = nuevo.valor;

    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
    }
    
    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ListaIterador implements Iterador<T> {
    	// Completar atributos privados

        public boolean haySiguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        
        public boolean hayAnterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }

        public T siguiente() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
        

        public T anterior() {
	        throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
	    throw new UnsupportedOperationException("No implementada aun");
    }

}
