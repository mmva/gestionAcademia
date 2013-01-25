package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Alumno;
import java.io.IOException;
import java.io.InputStreamReader;
import static java.lang.System.*;
import java.util.ArrayList;
import java.util.Scanner;

public class GestionAlumnos {
   private static final int FIN = 3;
   
    // Seleccion de una opcion
    public static void seleccionOpcion(){
        out.println("Selecciona una accion: ");
        out.println("\t1.- Listar Alumnos");  
        out.println("\t2.- Crear Alumno");
        out.println("\t3.- Salir");
        out.print("\t[1, 2, 3]> ");
    }
   
    public static void creaFicheroAlumno(Scanner scan) throws IOException{
        out.print("Nombre: ");
        String nombre = scan.nextLine();
        out.println();
        out.print("Direccion: ");
        String direccion = scan.nextLine();
        out.println();     
        Alumno alumno = new Alumno(nombre, direccion);
        ArrayList<Alumno> alAlumnos = new ArrayList<Alumno>();
        alAlumnos.add(alumno);
        
        GestionAlumnosFile.creaFicheros("C:", "alumnos", alAlumnos);
    }

    public static void main(String[] args) throws IOException {
        // Esperamos la opcion a leer
        InputStreamReader isr = new InputStreamReader(System.in);
        Scanner scanner = new Scanner(isr);
        
        int opcion = 0;
        
        do{            
            GestionAlumnos.seleccionOpcion();
            opcion = (new Integer(scanner.nextInt())).intValue();
            
            switch(opcion){
                case 1:
                    GestionAlumnosFile.recuperaInfoFicheros("C:", "alumnos");
                    break;
                case  2:
                    scanner.nextLine();
                    GestionAlumnos.creaFicheroAlumno(scanner);
                    break;
                default:
                    break;
            }
        } while(opcion != GestionAlumnos.FIN);
        
    }
}
