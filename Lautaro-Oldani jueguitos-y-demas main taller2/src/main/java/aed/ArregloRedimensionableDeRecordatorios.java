package aed;

class ArregloRedimensionableDeRecordatorios {
    private Integer longitud;
    private Recordatorio[] arreglo;


    public ArregloRedimensionableDeRecordatorios() {
        this.arreglo = new Recordatorio[0];
        this.longitud = 0;
    }

    public int longitud() {
        return this.longitud;
    }

    public void agregarAtras(Recordatorio i) {
        Recordatorio[] arreglo2 = new Recordatorio[this.longitud + 1];
        for (int j = 0; j < this.longitud; j++) {
            arreglo2[j] = this.arreglo[j];

        }
        arreglo2[this.longitud] = i;
        this.longitud = this.longitud + 1;
        this.arreglo = arreglo2;
    }

    public Recordatorio obtener(int i) {
        return this.arreglo[i];
    }

    public void quitarAtras() {
        Recordatorio[] arreglo2 = new Recordatorio[this.longitud - 1];
        for (int j = 0; j < this.longitud - 1; j++) {
            arreglo2[j] = this.arreglo[j];

        }
        this.longitud = this.longitud - 1;
        this.arreglo = arreglo2;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        this.arreglo[indice] = valor;
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        this.longitud = vector.longitud;
        this.arreglo = new Recordatorio[vector.longitud];
        for (int j = 0; j < vector.longitud; j++) {
            this.arreglo[j] = vector.obtener(j);
        }
        this.longitud = vector.longitud();
    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios res = new ArregloRedimensionableDeRecordatorios();
        for(int j = 0; j < this.longitud; j++){
            res.agregarAtras(this.arreglo[j]);
        }
        return res;
    }
}
