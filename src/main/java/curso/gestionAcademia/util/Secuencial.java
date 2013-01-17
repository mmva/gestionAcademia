package curso.gestionAcademia.util;

/*
 * Secuencial: Lista de secuenciales
 */
public class Secuencial {
    private static long secuencialAsignatura = 0;
    private static long secuencialProfesor = 0;
    private static long secuencialAula = 0;
    private static long secuencialAlumno = 0;

    public static long getSecuencialAsignatura(String tipo) {
        String codSig = (String) Constantes.COD_ASIG.get(tipo) + (++Secuencial.secuencialAsignatura);
        Integer secAsigAux = new Integer(codSig);
        
        return secAsigAux.longValue();
    }

    public static long getSecuencialProfesor() {
        return ++Secuencial.secuencialProfesor;
    }

    public static String getSecuencialAula() {
        return Constantes.AULA + (++Secuencial.secuencialAula);
    }

    public static long getSecuencialAlumno() {
        return ++Secuencial.secuencialAlumno;
    }
}
