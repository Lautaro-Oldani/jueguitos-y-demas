package aed;

public class Agenda {
    private ArregloRedimensionableDeRecordatorios recordatorios;
    private Fecha fecha;

    public Agenda(Fecha fechaActual) {
        this.fecha = fechaActual;
        this.recordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        this.recordatorios.agregarAtras(recordatorio);
    }

    @Override
    public String toString() {
        StringBuffer respuesta = new StringBuffer();

        respuesta.append(this.fecha.toString() + "\n=====\n" );
        for(int j=0; j < this.recordatorios.longitud(); j++) {
            if(this.fecha.equals(this.recordatorios.obtener(j).fecha())){
                respuesta.append(this.recordatorios.obtener(j).toString() + "\n");
        }
    }
        return respuesta.toString();
    }

    public void incrementarDia() {
        this.fecha.incrementarDia();
    }

    public Fecha fechaActual() {
        Fecha fechaActual = new Fecha(this.fecha);
        return fechaActual;
    }

}
