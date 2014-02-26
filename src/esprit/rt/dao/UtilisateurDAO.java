/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 *//*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author Aditsan Kadmus
 */
public class UtilisateurDAO {
    public int auth (String[] atr)
    {
        String requete = "select id from utilisateurs where email = ? and password = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setString(1, atr[0]);
           ps.setString(2, atr[1]);
            ResultSet resultat = ps.executeQuery();
            while(resultat.next()){
                return resultat.getInt(1);
            }
        }
        catch (Exception e)
        {
            System.out.println("REQUEST ERROR");
        }
        return -1;
    }
}
