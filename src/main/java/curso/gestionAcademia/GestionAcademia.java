package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Asignatura;
import java.util.*;

/**
 * Hello world!
 *
 */
public class GestionAcademia 
{
    public static void main( String[] args )
    {
        Map<Integer, Asignatura> mapAsignaturas = new HashMap<Integer, Asignatura>();
        Asignatura asignatura = new Asignatura("JAVA", "INF", 25);
        mapAsignaturas.put(asignatura.getIdAsignatura(), asignatura);
    }
}
