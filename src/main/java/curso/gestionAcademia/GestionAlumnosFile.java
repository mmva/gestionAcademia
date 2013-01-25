package curso.gestionAcademia;

import curso.gestionAcademia.plantillas.Alumno;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GestionAlumnosFile {
    
    public static void existeCarpeta(String path, String carpeta){
        File f = new File(path + File.separator + carpeta);
        
        if(f.exists() && f.isDirectory()) {
            System.out.println("Ya existe la carpeta " + path + File.separator + carpeta);
        } else {
            System.out.println("Creamos la carpeta " + path + File.separator + carpeta);
            f.mkdir();
        }
    }
    
    public static void creaFicheros(String path, String carpeta, ArrayList<Alumno> alumnos) throws IOException{
        String nombreFicheroAlumno = "";
        for(Alumno alumno: alumnos){
            nombreFicheroAlumno = alumno.getIdAlumno() + "-" + alumno.getNombre() + ".data";            
            File f = new File(path + File.separator + carpeta + File.separator + nombreFicheroAlumno);
            if(f.exists()){
                System.out.println("El fichero " + f.getName() + " ya existe en el sistema");
            } else {
                System.out.println("Creamos el fichero " + f.getName());
                try{ 
                    FileOutputStream fs = new FileOutputStream(path + File.separator + carpeta + File.separator + nombreFicheroAlumno);
                    ObjectOutputStream os = new ObjectOutputStream(fs);
                    os.writeObject(alumno);
                    os.flush();
                    os.close();
                } catch(FileNotFoundException ffe){
                    System.out.println("FileNotFoundException: " + ffe.getMessage());
                } catch(IOException ioe){
                    System.out.println("IOException: " + ioe.getMessage());
                } catch(Exception ex) {
                    System.out.println("IOException: " + ex.getMessage());
                } finally {
                    System.out.println("Realizada ejecucion de creacion del fichero " +  f.getName());
                }                
            }
        }
    }
    
    public static void recuperaInfoFicheros(String path, String carpeta){
        File f = new File(path + File.separator + carpeta);
        Alumno alumno;
        
        if(f.exists() && f.isDirectory()) {
            File[] files = f.listFiles(new FilenameFilter() {
                // Funcion anonima
                public boolean accept(File dir, String name) {
                    return name.endsWith(".data");
                }
            });
            
            
           // Si existe, puedo buscar los diferentes ficheros y mostrar la info
           for(File file: files){
                try{
                    FileInputStream fis = new FileInputStream(path + File.separator + carpeta + File.separator + file.getName());
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    alumno = (Alumno) ois.readObject();
                    System.out.println("Alumno: " + alumno.getIdAlumno() + ", " + alumno.getNombre() + ", " + alumno.getDireccion());
                    ois.close();
                } catch(FileNotFoundException ffe){
                    System.out.println("FileNotFoundException: " + ffe.getMessage());
                } catch(IOException ioe){
                    System.out.println("IOException: " + ioe.getMessage());
                } catch(Exception ex) {
                    System.out.println("IOException: " + ex.getMessage());
                }               
                   }
                } else {
                    System.out.println("No existe la carpeta");
                } 
    }

    public static void main(String[] args) throws IOException {
        // Primero comprobamos existencia de la carpeta
        System.out.println("Creando la carpeta:");
        GestionAlumnosFile.existeCarpeta("C:", "alumnos");
        
        Alumno al1 = new Alumno("Mari Mar", "Nicolas Guillen 8");
        Alumno al2 = new Alumno("Hermenegildo", "Plaza del Pilar 1");
        Alumno al3 = new Alumno("Eustaquio", "San Vicente de Paul 5");
        
        ArrayList<Alumno> alAlumnos = new ArrayList();
        alAlumnos.add(al1);
        alAlumnos.add(al2);
        alAlumnos.add(al3);
        
        System.out.println();
        System.out.println("Guardando/Creando los ficheros");
        GestionAlumnosFile.creaFicheros("C:", "alumnos", alAlumnos);
 
        System.out.println();
        System.out.println("Recuperando los ficheros");
        GestionAlumnosFile.recuperaInfoFicheros("C:", "alumnos");
    }
}
