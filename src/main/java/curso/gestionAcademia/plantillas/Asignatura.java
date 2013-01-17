package curso.gestionAcademia.plantillas;

import curso.gestionAcademia.util.Secuencial;
import java.util.ArrayList;

public class Asignatura {
    private long idAsignatura;
    private String nombre;
    private String tipo; // INF, IDI
    private int horasSemana;
    private String idAula;
    private ArrayList<String> temario = new ArrayList<String>();
    private ArrayList<String> bibliografia = new ArrayList<String>();
    
    // Constructor
    public Asignatura(String nombre, String tipo, int horasSemana){
        this.nombre = nombre;
        this.tipo = tipo;
        this.horasSemana = horasSemana;
        
        this.idAsignatura = Secuencial.getSecuencialAsignatura(tipo);
    }

    // Funciones para la recuperacion de la informacion del objeto
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

    public ArrayList getTemario() {
        return temario;
    }

    public ArrayList getBibliografia() {
        return bibliografia;
    }

    // Establecemos el aula
    public void setIdAula(String idAula) {
        this.idAula = idAula;
    }
    
    // Agregamos temario
    public void agregarTema(String tema){
        this.temario.add(tema);
    }
    
    // Agregamos bibliografia
    public void agregarBibliografia(String libro){
        this.bibliografia.add(libro);
    }
}
