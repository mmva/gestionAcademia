package curso.gestionAcademia.plantillas;

import java.util.HashSet;
import java.util.Set;

public class Profesor extends Persona {
    
    private Set<Asignatura> setAsignatura;
    
    public Profesor ( String nombre, String direccion ) {
        super( nombre, direccion );
        this.setAsignatura = new HashSet<Asignatura>();
    }
}
