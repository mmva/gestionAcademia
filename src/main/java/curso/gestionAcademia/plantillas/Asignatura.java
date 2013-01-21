package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAlumno;
import curso.gestionAcademia.util.Constantes;
import curso.gestionAcademia.util.Secuencial;
import java.util.Set;

public class Asignatura implements MetodosAlumno {
    private Integer idAsignatura;
    private String nombre;
    private String tipo; // INF, IDI
    private int horasSemana;
    private String idAula;
    private Set<Alumno> setAlumnos;
    
    // Constructor
    public Asignatura(String nombre, String tipo, int horasSemana){
        this.nombre = nombre;
        this.tipo = (tipo.equals(Constantes.TIP_INF) || tipo.equals(Constantes.TIP_IDI) )? tipo : Constantes.TIP_GEN;
        this.horasSemana = horasSemana;
        
        this.idAsignatura = Secuencial.getSecuencialAsignatura(tipo);
    }

    // Funciones para la recuperacion de la informacion del objeto
    public Integer getIdAsignatura() {
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

    public void cargaAlumno(Alumno alumno) {
        this.setAlumnos.add( alumno );
    }

    public void eliminarAlumno(Alumno alumno) {
        this.setAlumnos.remove( alumno );
    }
}
