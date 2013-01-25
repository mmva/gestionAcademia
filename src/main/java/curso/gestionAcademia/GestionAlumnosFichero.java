package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Alumno;
import java.io.*;
import java.util.ArrayList;

public class GestionAlumnosFichero {
    
    // Guardamos el alumno serializado
    public static void guardaAlumnoFichero(ArrayList<Alumno> alumnos){  
        try{
            FileOutputStream fs = new FileOutputStream("docs/alumnos.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            os.writeObject(alumnos);
            os.flush();
            os.close();
        } catch(FileNotFoundException ffe){
            System.out.println("FileNotFoundException: " + ffe.getMessage());
        } catch(IOException ioe){
            System.out.println("IOException: " + ioe.getMessage());
        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    // Recupera el alumno
    public static void recuperaAlumnosFichero(){
        ArrayList<Alumno> alAlumnos = null;
        
        try{
            FileInputStream fis = new FileInputStream("docs/alumnos.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            alAlumnos = (ArrayList) ois.readObject();
            for (Alumno alumno: alAlumnos) {
                System.out.println("Alumno: " + alumno.getIdAlumno() + ", " + alumno.getNombre() + ", " + alumno.getDireccion());
            }
            ois.close();
        } catch(FileNotFoundException ffe){
            System.out.println("FileNotFoundException: " + ffe.getMessage());
        } catch(IOException ioe){
            System.out.println("IOException: " + ioe.getMessage());
        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }
    
    // Guarda objetos separados de tipo alumno
    public static void guardaAlumnoFicheroSep(ArrayList<Alumno> alumnos){ 
        try{
            FileOutputStream fs = new FileOutputStream("docs/alumnos.txt");
            ObjectOutputStream os = new ObjectOutputStream(fs);
            for(Alumno alumno: alumnos){
                os.writeObject(alumno);
            }
            os.flush();
            os.close();
        } catch(IOException ioe){
            System.out.println("IOException: " + ioe.getMessage());
        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }  
    
    // Recupera el alumno
    public static void recuperaAlumnosFicheroSep(){
        Alumno alumno;
        
        try{
            FileInputStream fis = new FileInputStream("docs/alumnos.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            while((alumno = (Alumno) ois.readObject())!=null){
                System.out.println("Alumno: " + alumno.getIdAlumno() + ", " + alumno.getNombre() + ", " + alumno.getDireccion());                
            }
            ois.close();
        } catch(FileNotFoundException ffe){
            System.out.println("FileNotFoundException: " + ffe.getMessage());
        } catch(EOFException eofe){ 
            System.out.println("Hemos llegado al final de la lista");
        } catch(IOException ioe){
            System.out.println("IOException: " + ioe.getMessage() + ", " + ioe.getCause() + ", " + ioe.getLocalizedMessage());
        } catch(Exception ex) {
            System.out.println("IOException: " + ex.getMessage());
        }
    }    

    public static void main(String[] args) {
        // Creamos nuevos alumnos serializados que guardaremos en un fichero
        Alumno al1 = new Alumno("Mari Mar", "Nicolas Guillen 8");
        Alumno al2 = new Alumno("Hermenegildo", "Plaza del Pilar 1");
        Alumno al3 = new Alumno("Eustaquio", "San Vicente de Paul 5");
        
        ArrayList<Alumno> alAlumnos = new ArrayList();
        alAlumnos.add(al1);
        alAlumnos.add(al2);
        alAlumnos.add(al3);
        
        System.out.println("Guardando un ArrayList");
        GestionAlumnosFichero.guardaAlumnoFichero(alAlumnos);
        GestionAlumnosFichero.recuperaAlumnosFichero();
        
        System.out.println();
        System.out.println("Guardando los objetos separados");
        GestionAlumnosFichero.guardaAlumnoFicheroSep(alAlumnos);
        GestionAlumnosFichero.recuperaAlumnosFicheroSep();
    }
    
}
