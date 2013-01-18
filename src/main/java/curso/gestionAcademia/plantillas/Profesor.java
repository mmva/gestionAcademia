package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set;

public class Profesor extends Persona implements MetodosAsignaturas {
    private Integer idProfesor;
    private Set<Asignatura> setAsignatura;
    
    public Profesor ( String nombre, String direccion ) {
        super( nombre, direccion );
        this.setAsignatura = new HashSet<Asignatura>();
        this.idProfesor = Secuencial.getSecuencialProfesor();
    }

    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void cargaAsignatura(Asignatura asignatura) {
        this.setAsignatura.add( asignatura );
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.setAsignatura.remove( asignatura );
    }
}
