package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.ElementosAcademia;
import java.util.HashMap;
import java.util.Map;

public class Academia implements ElementosAcademia{
    Integer idAcademia;
    String nombreAcademia;
    String direccionAcademia;
    Map<Integer, Asignatura> mapAsignaturasAcademia;
    Map<String, Aula> mapAulasAcademia;
    Map<Integer, Alumno> mapAlumnosAcademia;
    Map<Integer, Profesor> mapProfesoresAcademia;
    
    public Academia(){
        this.mapAlumnosAcademia = new HashMap<Integer, Alumno>();
        this.mapAsignaturasAcademia = new HashMap<Integer, Asignatura>();
        this.mapAulasAcademia = new HashMap<String, Aula>();
        this.mapProfesoresAcademia = new HashMap<Integer, Profesor>();
    }

    public void cargaAsignaturaAcademia(Asignatura asignatura) {
        this.mapAsignaturasAcademia.put(asignatura.getIdAsignatura(), asignatura);
    }

    public void cargaAulaAcademia(Aula aula) {
        this.mapAulasAcademia.put(aula.getIdAula(), aula);
    }

    public void cargaAlumnoAcademia(Alumno alumno) {
        this.mapAlumnosAcademia.put(alumno.getIdAlumno(), alumno);
    }

    public void cargaProfesorAcademia(Profesor profesor) {
        this.mapProfesoresAcademia.put(profesor.getIdProfesor(), profesor);
    }

    public void eliminaAsignaturaAcademia(Integer idAcademia) {
        this.mapAsignaturasAcademia.remove(idAcademia);
    }

    public void eliminaAulaAcademia(Integer idAula) {
        this.mapAulasAcademia.remove(idAula);
    }

    public void eliminaAlumnoAcademia(Integer idAlumno) {
        this.mapAlumnosAcademia.remove(idAlumno);
    }

    public void eliminaProfesorAcademia(Integer idProfesor) {
        this.mapProfesoresAcademia.remove(idProfesor);
    }
    
}
