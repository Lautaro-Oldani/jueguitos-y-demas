package aed;

public class Horario {
    private Integer hora;
    private Integer minutos;

    public Horario(int hora, int minutos) {
        this.hora = hora;
        this.minutos = minutos;
    }

    public int hora() {
        return this.hora;
    }

    public int minutos() {
        return this.minutos;
    }

    @Override
    public String toString() {
        StringBuffer respuesta = new StringBuffer();

        respuesta.append(this.hora.toString());
        respuesta.append(":");
        respuesta.append(this.minutos.toString());

        return respuesta.toString();
    }

    @Override
    public boolean equals(Object otro) {
        if (otro.getClass() != this.getClass()){
            return false;
        }
        Horario otroHorario = (Horario) otro;
        
        if (otroHorario.hora == this.hora && otroHorario.minutos == this.minutos){
            return true;
        } else {
            return false;
        }
    }

}
