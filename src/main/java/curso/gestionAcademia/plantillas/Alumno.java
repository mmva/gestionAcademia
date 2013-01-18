package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set;

public class Alumno extends Persona implements MetodosAsignaturas {
    private Integer idAlumno;
    private Set<Asignatura> setAsignatura;
    
    public Alumno ( String nombre, String direccion ) {
        super( nombre, direccion );
        this.setAsignatura = new HashSet<Asignatura>();
        this.idAlumno = Secuencial.getSecuencialAlumno();
    }

    public Integer getIdAlumno() {
        return idAlumno;
    }

    public void cargaAsignatura( Asignatura asignatura ) {
        this.setAsignatura.add( asignatura );    
    }

    public void eliminarAsignatura( Asignatura asignatura ) {
        this.setAsignatura.remove( asignatura );
    }
}
