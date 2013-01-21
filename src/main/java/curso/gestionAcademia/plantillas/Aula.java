package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set;

public class Aula implements MetodosAsignaturas {
    private String idAula;
    private int capacidad;
    private boolean tieneProyector;
    Set<Asignatura> asignaturasAula;
    
    public Aula( int capacidad, boolean tieneProyector ){
        this.capacidad = capacidad;
        this.tieneProyector = tieneProyector;
        this.idAula = Secuencial.getSecuencialAula();
        this.asignaturasAula = new HashSet();
    }

    public String getIdAula() {
        return idAula;
    }
    
    public int getCapacidad() {
        return this.capacidad;
    }
    
    public boolean getTieneProyector() {
        return this.tieneProyector;
    }

    public void cargaAsignatura(Asignatura asignatura) {
        this.asignaturasAula.add(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.asignaturasAula.remove(asignatura);
    }
}
