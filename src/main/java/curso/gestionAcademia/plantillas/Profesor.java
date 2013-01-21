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
    
    public void mostrarAsignaturas() {
        System.out.println( "\nASIGNATURAS PROFESOR" ); 
        System.out.println( "\nid\tnombre\ttipo\thoras semanales" ); 
        for ( Asignatura asig : setAsignatura ) {
            System.out.println( asig.getIdAsignatura() + "\t" + asig.getNombre() + "\t" + asig.getTipo() + "\t" + asig.getHorasSemana() );
        }
    }

    public void cargaAsignatura(Asignatura asignatura) {
        this.setAsignatura.add( asignatura );
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.setAsignatura.remove( asignatura );
    }
}
