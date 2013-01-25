package curso.gestionAcademia.plantillas;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String direccion;
    
    public Persona ( String nombre, String direccion ) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
