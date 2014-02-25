package esprit.rt.utilities;

import java.util.Date;

/**
 *
 * @author Aditsan Kadmus
 * 
 */

public class SessionRestoTunisie {
    
    private static int id;
    private static float last_active;
    
    public SessionRestoTunisie()
    {
        this.last_active = new Date().getTime();
    }
    
    public SessionRestoTunisie(int id)
    {
        this.id = id;
        this.last_active = new Date().getTime();
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        SessionRestoTunisie.id = id;
    }

    public static float getLast_active() {
        return last_active;
    }

    public static void setLast_active(float last_active) {
        SessionRestoTunisie.last_active = last_active;
    }

    @Override
    public String toString() {
        return "SessionRestoTunisie{" +id+ '}';
    }
    
    
}
