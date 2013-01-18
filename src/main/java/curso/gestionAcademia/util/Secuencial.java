package curso.gestionAcademia.util;

/*
 * Secuencial: Lista de secuenciales
 */
public class Secuencial {
    private static Integer secuencialAsignatura = 0;
    private static Integer secuencialProfesor = 0;
    private static Integer secuencialAula = 0;
    private static Integer secuencialAlumno = 0;

    public static Integer getSecuencialAsignatura(String tipo) {
        String codSig = (String) Constantes.COD_ASIG.get(tipo) + (++Secuencial.secuencialAsignatura);
        Integer secAsigAux = new Integer(codSig);
        
        return secAsigAux;
    }

    public static Integer getSecuencialProfesor() {
        return ++Secuencial.secuencialProfesor;
    }

    public static String getSecuencialAula() {
        return Constantes.AULA + (++Secuencial.secuencialAula);
    }

    public static Integer getSecuencialAlumno() {
        return ++Secuencial.secuencialAlumno;
    }
}
