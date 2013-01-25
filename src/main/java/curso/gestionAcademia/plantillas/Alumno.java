package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Alumno extends Persona implements MetodosAsignaturas, Serializable {
    private Integer idAlumno;
    private Set<Integer> setAsignatura;
    
    public Alumno ( String nombre, String direccion ) {
        super( nombre, direccion );
        this.setAsignatura = new HashSet<Integer>();
        this.idAlumno = Secuencial.getSecuencialAlumno();
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void cargaAsignatura( Asignatura asignatura ) {
        this.setAsignatura.add( asignatura.getIdAsignatura() );    
    }

    public void eliminarAsignatura( Asignatura asignatura ) {
        this.setAsignatura.remove( asignatura.getIdAsignatura() );
    }
}
