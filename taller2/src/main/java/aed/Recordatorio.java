package aed;

public class Recordatorio {
    private String mensaje;
    private Fecha fecha;
    private Horario horario;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.horario = horario;
    }

    public Horario horario() {
        return this.horario;
    }

    public Fecha fecha() {
        return this.fecha;
    }

    public String mensaje() {
        return this.mensaje;
    }

    @Override
    public String toString() {
        StringBuffer respuesta = new StringBuffer();

        respuesta.append(this.mensaje.toString());
        respuesta.append(" @ ");
        respuesta.append(this.fecha.toString());
        respuesta.append(" ");
        respuesta.append(this.horario.toString());

        return respuesta.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if (otro.getClass() != this.getClass()){
            return false;
        }
        Recordatorio otroRecordatorio = (Recordatorio) otro;
        
        if (otroRecordatorio.mensaje == this.mensaje && otroRecordatorio.fecha == this.fecha && otroRecordatorio.horario == this.horario){
            return true;
        } else {
            return false;
        }
    }

}
