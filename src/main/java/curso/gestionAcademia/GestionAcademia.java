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
        /*academia.cargaAlumnoAcademia( new Alumno( "Alberto", "Csdfdsf" ) );
        academia.cargaProfesorAcademia( new Profesor( "Juan", "sdsddddddd" ) );
        academia.cargaAulaAcademia( new Aula( 25, true ) ); */
        academia.cargaAsignaturaAcademia( new Asignatura( "Java", "INF", 50 ) ); 
        academia.cargaAsignaturaAcademia( new Asignatura( "Frances", "IDI", 10 ) ); 
        academia.cargaAsignaturaAcademia( new Asignatura( "Ingles", "IDI", 23 ) ); 
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
            System.out.println( "9.- Asignaturas de un profesor" );
            System.out.println( "10.- Asignaturas de un aula" );
            System.out.println( "11.- Alumnos de un profesor" );
            System.out.println( "12.- Alumnos de una asignatura" );
            System.out.println( "13.- Aulas libres a una hora" );
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
            case 9:
                mostrarAsignaturasProfesor();
                break;
            case 10:
                mostrarAsignaturasAula();
                break;
            case 11:
                mostrarAlumnosProfesor();
                break;
            case 12:
                mostrarAlumnosAsignatura();
                break;
            case 13:
                mostrarAulasLibresHora();
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
        int opcion;
        System.out.println( "- FORMULARIO PROFESOR -" );
        System.out.print( "Introduzaca un nombre: " );
        String nombreProfesor = entrada.next();
        System.out.print( "Introduzaca una direccion: " );
        String direccionProfesor = entrada.next();
        Profesor profesor = new Profesor( nombreProfesor, direccionProfesor );
        
        // Asignar asignatura a profesor
        System.out.println( "ASIGNATURAS DISPONIBLES PARA ASIGNAR" );
        do {
            mostrarAsignaturas();
            System.out.print( "ESCRIBA EL CÓDIGO DE LA ASIGNATURA O < 0 > PARA SALIR: " );
            opcion = entrada.nextInt();
            // Si la clave escrita es correcta se realiza la matriculación
            if ( opcion != 0 && academia.mapAsignaturasAcademia.containsKey( opcion ) ) {
                // Añadir la asignatura al profesor
                Asignatura asignatura = academia.mapAsignaturasAcademia.get( opcion );
                profesor.cargaAsignatura( asignatura );
                asignatura.setProfesor( profesor ); 
                academia.cargaAsignaturaAcademia( asignatura );
            }
        } while ( opcion != 0 ); 
        // Se carga el profesor a la base de datos Academia
        academia.cargaProfesorAcademia( profesor );  
    }
    
    public void insertarAula() {
        int opcion;
        System.out.println( "- FORMULARIO AULA -" );
        System.out.print( "Introduzca la capacidad del aula: " );
        int capacidad = entrada.nextInt();
        System.out.print( "Tiene proyector < true / false >: " );
        boolean tieneProyector = entrada.nextBoolean();
        Aula aula = new Aula( capacidad, tieneProyector );
        
        // Insertar asignatura al aula
        System.out.println( "ASIGNATURAS DISPONIBLES PARA ASIGNAR AL AULA" );
        do {
            mostrarAsignaturas();
            System.out.print( "ESCRIBA EL CÓDIGO DE LA ASIGNATURA O < 0 > PARA SALIR: " );
            opcion = entrada.nextInt();
            // Si la clave escrita es correcta se asigna la asignatura al aula
            if ( opcion != 0 && academia.mapAsignaturasAcademia.containsKey( opcion ) ) {
                // Añadir la asignatura al aula
                Asignatura asignatura = academia.mapAsignaturasAcademia.get( opcion );
                aula.cargaAsignatura( asignatura );
                //asignatura.setAula( aula );
                // Se carga la asignatura a la base de datos
                academia.cargaAsignaturaAcademia( asignatura );
            }
        } while ( opcion != 0 );   
        // Se carga el aula a la base de datos Academia
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
                asignatura.cargaAlumno( alumno );
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
            System.out.println( "\n" + e.getKey() + "\t" + aula.getCapacidad() + "\t\t" + aula.getTieneProyector() );
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

    private void mostrarAsignaturasProfesor( ) {
        int codigo;
        Iterator coleccionProfesores = academia.mapProfesoresAcademia.entrySet().iterator(); 
        if ( !coleccionProfesores.hasNext() ) {
           System.out.println( "\nNO HAY PROFESORES\n" );
           return;
        } 
        
        mostrarProfesores();
        
        System.out.println( "ESCRIBA EL CÓDIGO DEL PROFESOR: " ); 
        codigo = entrada.nextInt();
        
        if (  academia.mapProfesoresAcademia.containsKey( codigo )) {
            Profesor profesor = academia.mapProfesoresAcademia.get( codigo );
            profesor.mostrarAsignaturas();    
        } 
        
        System.out.println();    
    }

    private void mostrarAsignaturasAula() {
        String codigo;
        Iterator coleccionAulas = academia.mapAulasAcademia.entrySet().iterator(); 
        if ( !coleccionAulas.hasNext() ) {
           System.out.println( "\nNO HAY AULAS\n" );
           return;
        } 
        
        mostrarAulas();
        
        System.out.println( "ESCRIBA EL CÓDIGO DEL AULA: " ); 
        codigo = entrada.next();
        
        if (  academia.mapAulasAcademia.containsKey( codigo )) {
            Aula aula = academia.mapAulasAcademia.get( codigo );
            aula.mostrarAsignaturas();    
        } 
        
        System.out.println();     
    }

    private void mostrarAlumnosProfesor() {
        
    }

    private void mostrarAlumnosAsignatura() {
        
    }

    private void mostrarAulasLibresHora() {
       
    }
}