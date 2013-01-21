package curso.gestionAcademia.interfaces;

import curso.gestionAcademia.plantillas.*;
import java.util.Map;

public interface ElementosAcademia {
    // Toda academia dispone de asignaturas, aulas, alumnos y profesores
    // Obligamos a que implemente los metodos
    public abstract void cargaAsignaturaAcademia(Asignatura asignatura);
    public abstract void cargaAulaAcademia(Aula aula);
    public abstract void cargaAlumnoAcademia(Alumno alumno);
    public abstract void cargaProfesorAcademia(Profesor profesor);
    
    public abstract void eliminaAsignaturaAcademia(Integer idAcademia);
    public abstract void eliminaAulaAcademia(String idAula);
    public abstract void eliminaAlumnoAcademia(Integer idAlumno);
    public abstract void eliminaProfesorAcademia(Integer idProfesor);    
}
