package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.util.Constantes;
import curso.gestionAcademia.util.Secuencial;

public class Asignatura {
    private long idAsignatura;
    private String nombre;
    private String tipo; // INF, IDI
    private int horasSemana;
    private String idAula;
    
    // Constructor
    public Asignatura(String nombre, String tipo, int horasSemana){
        this.nombre = nombre;
        this.tipo = (tipo.equals(Constantes.TIP_INF) || tipo.equals(Constantes.TIP_IDI) )? tipo : Constantes.TIP_GEN;
        this.horasSemana = horasSemana;
        
        this.idAsignatura = Secuencial.getSecuencialAsignatura(tipo);
    }

    // Funciones para la recuperacion de la informacion del objeto
    public long getIdAsignatura() {
        return idAsignatura;
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public String getIdAula() {
        return idAula;
    }

    // Establecemos el aula
    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }
}
