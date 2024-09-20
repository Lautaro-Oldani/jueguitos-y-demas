package aed;

public class Fecha {
    private Integer dia;
    private Integer mes;

    public Fecha(int dia, int mes) {
        this.dia = dia;
        this.mes = mes;
    }

    public Fecha(Fecha fecha) {
        this.dia = fecha.dia;
        this.mes = fecha.mes;

    }

    public Integer dia() {
        return this.dia;
    }

    public Integer mes() {
        return this.mes;
    }

    @Override
    public String toString() {
        StringBuffer respuesta = new StringBuffer();

        respuesta.append(this.dia.toString());
        respuesta.append("/");
        respuesta.append(this.mes.toString());

        return respuesta.toString();
    }

    @Override
    public boolean equals(Object otra) {
        if (otra.getClass() != this.getClass()){
            return false;
        }
        Fecha otraFecha = (Fecha) otra;
        
        if (otraFecha.dia == this.dia && otraFecha.mes == this.mes){
            return true;
        } else {
            return false;
        }
    }

    public void incrementarDia() {
        if (this.dia == diasEnMes(this.mes) && (this.mes == 12)) {
            this.dia = 1;
            this.mes = 1;

        } else if (this.dia == diasEnMes(this.mes)){
            this.dia = 1;
            this.mes += 1;
        } else {
            this.dia += 1;
        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}
