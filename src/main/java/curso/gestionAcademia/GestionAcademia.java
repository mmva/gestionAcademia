package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Asignatura;
import java.util.*;

public class GestionAcademia 
{
    public static void main( String[] args )
    {
        Map<Integer, Asignatura> mapAsignaturas = new HashMap<Integer, Asignatura>();
        Asignatura asignatura = new Asignatura("JAVA", "INF", 25);
        mapAsignaturas.put(asignatura.getIdAsignatura(), asignatura);
        
        System.out.println("Secuencial Asignatura: " + asignatura.getIdAsignatura());
        System.out.println("Asignatura: " + asignatura.getNombre());
    }
}
