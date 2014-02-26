package esprit.rt.dao;

import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class RestaurateurDAO {
     public int auth (String[] atr)
    {
        int res = new UtilisateurDAO().auth(atr);
        if (res != -1)
        {
        String requete = "select * from restaurateur where id = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, res);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                return res;
            }
        }
        catch (Exception e)
        {
            System.out.println("REQUEST ERROR");
        }
        }
        return -1;
    }
}
