package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAsignaturas;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set;

public class Aula implements MetodosAsignaturas {
    String idAula;
    int capacidad;
    boolean tieneProyector;
    Set asignaturasAula;
    
    public Aula(){
        this.idAula = Secuencial.getSecuencialAula();
        this.asignaturasAula = new HashSet();
    }

    public String getIdAula() {
        return idAula;
    }

    public void cargaAsignatura(Asignatura asignatura) {
        this.asignaturasAula.add(asignatura);
    }

    public void eliminarAsignatura(Asignatura asignatura) {
        this.asignaturasAula.remove(asignatura);
    }
}
