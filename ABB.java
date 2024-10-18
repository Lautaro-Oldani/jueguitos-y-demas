package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    // Agregar atributos privados del Conjunto

    private class Nodo {
        public Nodo padre;
        public Nodo izq;
        public Nodo der;
        public T valor;

        public Nodo (T data) {
            this.valor = data;
            this.izq = null;
            this.der = null;
            this.padre = null;
        }
    }
    
    public Nodo raiz;
    private int elementos;

    public ABB() {
        raiz = null;
        elementos = 0;
    }

    public int cardinal() {
        return elementos;
    }

    public T minimo(){
        Nodo actual = raiz;
        if (raiz == null) {
            return null;
        }
        while (actual.izq != null){
            actual = actual.izq;
        }
        return actual.valor;
    }

    public T maximo(){
        Nodo actual = raiz;
        if (raiz == null) {
            return null;
        }
        while (actual.der != null){
            actual = actual.der;
        }
        return actual.valor;
    }

    public void insertar(T elem){
        Nodo actual = raiz;
        if (raiz == null) {
            raiz = new Nodo(elem);
            elementos += 1;
        } else if (this.pertenece(elem) == false){
            while(true){
                if (actual.valor.compareTo(elem) > 0){
                    if (actual.izq == null){
                        actual.izq = new Nodo(elem);
                        actual.izq.padre = actual;
                        elementos += 1;
                        break;
                    } else {
                        actual = actual.izq;
                    }
                } else{
                    if (actual.der == null){
                        actual.der = new Nodo(elem);
                        actual.der.padre = actual;
                        elementos += 1;
                        break;
                    } else{
                        actual = actual.der;
                }
            }
        }
    }
            
    }

    public boolean pertenece(T elem){
        Nodo actual = raiz;
        while (actual != null){
            if (actual.valor.compareTo(elem) == 0){
                return true;
            } else if(actual.valor.compareTo(elem) > 0){
                actual = actual.izq;
            } else {
                actual = actual.der;
            }
        }
        return false;
    }

    public void eliminar(T elem){
        Nodo actual = raiz;
        if(this.pertenece(elem)){
            
        }
    }

    public String toString(){
        throw new UnsupportedOperationException("No implementada aun");
    }

    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public boolean haySiguiente() {            
            throw new UnsupportedOperationException("No implementada aun");
        }
    
        public T siguiente() {
            throw new UnsupportedOperationException("No implementada aun");
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }

}
