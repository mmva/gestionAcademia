package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import java.util.HashSet;
import java.util.Set;

public class Alumno extends Persona implements MetodosAsignaturas {
    
    private Set<Asignatura> setAsignatura;
    
    public Alumno ( String nombre, String direccion ) {
        super( nombre, direccion );
        this.setAsignatura = new HashSet<Asignatura>();
    }

    public void cargaAsignatura( Asignatura asignatura ) {
        setAsignatura.add( asignatura );    
    }

    public void eliminarAsignatura( Integer idAsignatura ) {
   
    }
}
