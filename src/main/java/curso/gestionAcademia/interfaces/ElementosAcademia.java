package curso.gestionAcademia.interfaces;

import curso.gestionAcademia.plantillas.*;
import java.util.Map;

public interface ElementosAcademia {
    // Toda academia dispone de asignaturas, aulas, alumnos y profesores
    // Obligamos a que implemente los metodos
    public abstract Map cargaAsignaturaAcademia(Asignatura asignatura);
    public abstract Map cargaAulaAcademia(Aula aula);
    public abstract Map cargaAlumnoAcademia(Alumno alumno);
    public abstract Map cargaProfesorAcademia(Profesor profesor);
    
    public abstract Map eliminaAsignaturaAcademia(Integer idAcademia);
    public abstract Map eliminaAulaAcademia(Integer idAula);
    public abstract Map eliminaAlumnoAcademia(Integer idAlumno);
    public abstract Map eliminaProfesorAcademia(Integer idProfesor);    
}
