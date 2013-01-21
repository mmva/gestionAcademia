package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set;

public class Aula implements MetodosAsignaturas {
    private String idAula;
    private int capacidad;
    private boolean tieneProyector;
    private Set<Asignatura> asignaturasAula;
    
    public Aula( int capacidad, boolean tieneProyector ){
        this.capacidad = capacidad;
        this.tieneProyector = tieneProyector;
        this.idAula = Secuencial.getSecuencialAula();
        this.asignaturasAula = new HashSet();
    }

    public String getIdAula() {
        return this.idAula;
    }
    
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public boolean getTieneProyector() {
        return this.tieneProyector;
    }
    
    public void mostrarAsignaturas() {
        System.out.println( "\nASIGNATURAS AULA" ); 
        System.out.println( "\nid\tnombre\ttipo\thoras semanales" ); 
        for ( Asignatura asig : asignaturasAula ) {
            System.out.println( asig.getIdAsignatura() + "\t" + asig.getNombre() + "\t" + asig.getTipo() + "\t" + asig.getHorasSemana() );
        }
    }

    public void cargaAsignatura(Asignatura asignatura) {
        this.asignaturasAula.add(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.asignaturasAula.remove(asignatura);
    }
}
