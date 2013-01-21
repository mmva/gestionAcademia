package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Academia;
import curso.gestionAcademia.plantillas.Alumno;
import curso.gestionAcademia.plantillas.Asignatura;
import curso.gestionAcademia.plantillas.Aula;
import curso.gestionAcademia.plantillas.Profesor;
import java.util.*;

public final class GestionAcademia {
    private Academia academia;
    private Scanner entrada;
    
    public GestionAcademia() {
        academia = new Academia();
        entrada = new Scanner( System.in );
        academia.cargaAlumnoAcademia( new Alumno( "Alberto", "Csdfdsf" ) );
        academia.cargaProfesorAcademia( new Profesor( "Juan", "sdsddddddd" ) );
        academia.cargaAulaAcademia( new Aula( 25, true ) ); 
        academia.cargaAsignaturaAcademia( new Asignatura( "Java", "INF", 50 ) ); 
        mostrarMenu();
    }
    
    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println( "\n- GESTION ACADEMIA -" );
            System.out.println( "***AGREGAR REGISTROS***" );
            System.out.println( "1.- Agregar asignatura" );
            System.out.println( "2.- Agregar profesor" );
            System.out.println( "3.- Agregar aula" );
            System.out.println( "4.- Agregar alumno" );
            System.out.println( "***MOSTRAR REGISTROS***" );
            System.out.println( "5.- Mostrar asignatura/s" );
            System.out.println( "6.- Mostrar profesor/es" );
            System.out.println( "7.- Mostrar aula/s" );
            System.out.println( "8.- Mostrar alumno/s" );
            System.out.println( "\n0.- Salir" );
            System.out.print( "\nSELECCIONE UNA OPCION: " );
            opcion = entrada.nextInt();
            realizarOperaciones( opcion );   
        } while ( opcion != 0 );     
    }
    
    public static void main( String[] args ) {
        GestionAcademia gA = new GestionAcademia();
       /* Map<Integer, Asignatura> mapAsignaturas = new HashMap<Integer, Asignatura>();
        Asignatura asignatura = new Asignatura("JAVA", "INF", 25);
        mapAsignaturas.put(asignatura.getIdAsignatura(), asignatura);
        
        System.out.println("Secuencial Asignatura: " + asignatura.getIdAsignatura());
        System.out.println("Asignatura: " + asignatura.getNombre());*/       
    }
    
    public void realizarOperaciones( int opcion ) {
        switch ( opcion ) {
            case 1:
                insertarAsignatura();      
                break;
            case 2:
                insertarProfesor();  
                break;
            case 3:
                insertarAula(); 
                break;
            case 4:
                insertarAlumno();
                break;
            case 5:
                mostrarAsignaturas();
                break;
            case 6:
                mostrarProfesores();
                break;
            case 7: 
                mostrarAulas();
                break;
            case 8:
                mostrarAlumnos();
                break;
        }
    }
    
    public void insertarAsignatura() {
        System.out.println( "- FORMULARIO ASIGNATURA -" );
        System.out.print( "Introduzaca un nombre: " );
        String nombreAsignatura = entrada.next();
        System.out.print( "Introduzaca un tipo < INF o IDI >: " );
        String tipoAsignatura = entrada.next();
        System.out.print( "Introduzaca horas semanales: " );
        int horasSemana = entrada.nextInt();
        Asignatura asignatura = new Asignatura( nombreAsignatura, tipoAsignatura, horasSemana );
        academia.cargaAsignaturaAcademia( asignatura );  
    }
    
    public void insertarProfesor() {
        System.out.println( "- FORMULARIO PROFESOR -" );
        System.out.print( "Introduzaca un nombre: " );
        String nombreProfesor = entrada.next();
        System.out.print( "Introduzaca una direccion " );
        String direccionProfesor = entrada.nextLine();
        Profesor profesor = new Profesor( nombreProfesor, direccionProfesor );
        academia.cargaProfesorAcademia( profesor );  
    }
    
    public void insertarAula() {
        System.out.println( "- FORMULARIO AULA -" );
        System.out.print( "Introduzca la capacidad del aula: " );
        int capacidad = entrada.nextInt();
        System.out.print( "Tiene proyector < true / false >: " );
        boolean tieneProyector = entrada.nextBoolean();
        Aula aula = new Aula( capacidad, tieneProyector );
        academia.cargaAulaAcademia( aula );  
    }
    
    public void insertarAlumno() {
        int opcion;
        System.out.println( "- FORMULARIO ALUMNO -" );
        System.out.print( "Introduzaca un nombre: " );
        String nombreAlumno = entrada.next();
        System.out.print( "Introduzaca una direccion: " );
        String direccionAlumno = entrada.next();
        Alumno alumno = new Alumno( nombreAlumno, direccionAlumno );
        
        // Matricular el alumno en alguna asignatura
        System.out.println( "ASIGNATURAS DISPONIBLES PARA MATRICULAR" );
        do {
            mostrarAsignaturas();
            System.out.print( "ESCRIBA EL CÓDIGO DE LA ASIGNATURA O < 0 > PARA SALIR: " );
            opcion = entrada.nextInt();
            // Si la clave escrita es correcta se realiza la matriculación
            if ( opcion != 0 && academia.mapAsignaturasAcademia.containsKey( opcion ) ) {
                // Añadir la asignatura al alumno
                Asignatura asignatura = academia.mapAsignaturasAcademia.get( opcion );
                alumno.cargaAsignatura( asignatura );
                // Añadir el alumno a la asignatura
                // Se carga la asignatura con el alumno añadido a la base de datos de academia
                academia.cargaAsignaturaAcademia( asignatura );
            }
        } while ( opcion != 0 );
        // Se carga el alumno a la base de datos de academia
        academia.cargaAlumnoAcademia( alumno ); 
    }

    private void mostrarAsignaturas() {
        Iterator coleccionAsignaturas = academia.mapAsignaturasAcademia.entrySet().iterator(); 
        if ( !coleccionAsignaturas.hasNext() ) {
           System.out.println( "\nNO HAY ASIGNATURAS\n" );
           return;
        }
        
        System.out.println( "\nASIGNATURAS" );
        
        System.out.println( "id\tnombre\ttipo\thoras" );
        while ( coleccionAsignaturas.hasNext() ) {
            Map.Entry e = (Map.Entry)coleccionAsignaturas.next();
            Asignatura asig = (Asignatura)e.getValue();
            System.out.println( "\n" + e.getKey() + "\t" + asig.getNombre() + "\t" + asig.getTipo() + "\t" + asig.getHorasSemana() );
        }
        System.out.println();
    }
    
    private void mostrarProfesores() {
        Iterator coleccionProfesores = academia.mapProfesoresAcademia.entrySet().iterator(); 
        if ( !coleccionProfesores.hasNext() ) {
           System.out.println( "\nNO HAY PROFESORES\n" );
           return;
        }    
        
        System.out.println( "\nPROFESORES" );
        
        System.out.println( "id\tnombre\tdireccion\t" );
        while ( coleccionProfesores.hasNext() ) {
            Map.Entry e = (Map.Entry)coleccionProfesores.next();
            Profesor prof = (Profesor)e.getValue();
            System.out.println( "\n" + e.getKey() + "\t" + prof.getNombre() + "\t" + prof.getDireccion() );
        }
        System.out.println();
    }

    private void mostrarAulas() {
        Iterator coleccionAulas = academia.mapAulasAcademia.entrySet().iterator(); 
        if ( !coleccionAulas.hasNext() ) {
           System.out.println( "\nNO HAY AULAS\n" );
           return;
        }
        
        System.out.println( "\nAULAS" );
        
        System.out.println( "id\tcapacidad\ttieneProyector\t" );
        while ( coleccionAulas.hasNext() ) {
            Map.Entry e = (Map.Entry)coleccionAulas.next();
            Aula aula = (Aula)e.getValue();
            System.out.println( "\n" + e.getKey() + "\t" + aula.getCapacidad() + "\t" + aula.getTieneProyector() );
        }
        System.out.println();
    }
    
    private void mostrarAlumnos() {
        Iterator coleccionAlumnos = academia.mapAlumnosAcademia.entrySet().iterator(); 
        if ( !coleccionAlumnos.hasNext() ) {
           System.out.println( "\nNO HAY ALUMNOS\n" );
           return;
        } 
        
        System.out.println( "\nALUMNOS" );
        
        System.out.println( "id\tnombre\tdireccion\t" );
        while ( coleccionAlumnos.hasNext() ) {
            Map.Entry e = (Map.Entry)coleccionAlumnos.next();
            Alumno alumno = (Alumno)e.getValue();
            System.out.println( "\n" + e.getKey() + "\t" + alumno.getNombre() + "\t" + alumno.getDireccion() );
        }
        System.out.println();
    }
}