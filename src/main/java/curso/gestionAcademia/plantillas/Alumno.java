package curso.gestionAcademia.plantillas;

import java.util.Set;

public class Alumno extends Persona {
    
    private Set<Asignatura> setAsignatura;
    
    public Alumno ( String nombre, String direccion ) {
        super( nombre, direccion );
    }
}
