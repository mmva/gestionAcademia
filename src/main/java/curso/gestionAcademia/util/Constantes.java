package curso.gestionAcademia.util;

import java.util.*;

/*
 * Constantes: Constantes 
 */
public final class Constantes {
    public static final String TIP_GEN    = "GEN";
    public static final String TIP_INF    = "INF";
    public static final String TIP_IDI    = "IDI";
    public static final Map COD_ASIG;
    public static final String AULA       = "AULA";
    
    static{
        COD_ASIG = new HashMap();
        COD_ASIG.put(TIP_INF, "201");
        COD_ASIG.put(TIP_IDI, "202");
        COD_ASIG.put(TIP_GEN, "200");
    }
}
