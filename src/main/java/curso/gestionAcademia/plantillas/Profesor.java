package curso.gestionAcademia.plantillas;

import java.util.Set;

public class Profesor extends Persona {
    
    private Set<Asignatura> setAsignatura;
    
    public Profesor ( String nombre, String direccion ) {
        super( nombre, direccion );
    }
}
