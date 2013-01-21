package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.interfaces.MetodosAlumno;
import curso.gestionAcademia.util.Constantes;
import curso.gestionAcademia.util.Secuencial;
import java.util.HashSet;
import java.util.Set; 

public class Asignatura implements MetodosAlumno {
    private Integer idAsignatura;
    private String nombre;
    private String tipo; // INF, IDI
    private int horasSemana;
    private String idAula;
    private Set<Alumno> setAlumnos;
    private Profesor profesor;
    
    // Constructor
    public Asignatura(String nombre, String tipo, int horasSemana){
        this.nombre = nombre;
        this.tipo = (tipo.equals(Constantes.TIP_INF) || tipo.equals(Constantes.TIP_IDI) )? tipo : Constantes.TIP_GEN;
        this.horasSemana = horasSemana;
        this.setAlumnos = new HashSet<Alumno>();
        this.idAsignatura = Secuencial.getSecuencialAsignatura(tipo);
    }
    
    public void mostrarAlumnos() {
        System.out.println( "\nALUMNOS ASIGNATURA" ); 
        System.out.println( "\nid\tnombre\tdireccion\t" ); 
        for ( Alumno alumno : setAlumnos ) {
            System.out.println( alumno.getIdAlumno() + "\t" + alumno.getNombre() + "\t" + alumno.getDireccion() );
        }
    }

    // Funciones para la recuperacion de la informacion del objeto
    public Integer getIdAsignatura() {
        return idAsignatura;
    }
   
    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getHorasSemana() {
        return horasSemana;
    }

    public String getIdAula() {
        return idAula;
    }
    
    public Profesor getProfesor() {
        return this.profesor;
    }
    
    public void setProfesor( Profesor profesor ) {
        this.profesor = profesor;
    }

    // Establecemos el aula
    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }

    public void cargaAlumno(Alumno alumno) {
        this.setAlumnos.add( alumno );
    }

    public void eliminarAlumno(Alumno alumno) {
        this.setAlumnos.remove( alumno );
    }
}
