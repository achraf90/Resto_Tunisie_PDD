package esprit.rt.dao;

import esprit.rt.entities.Client;
import esprit.rt.utilities.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Pingouins du désert
 * 
 */

public class ClientDAO {
    public Client findByIdReservation(int id)
    {
        String requete = "select u.id,u.nom,u.prenom,u.email,u.password,u.date_naissance,u.num_tel,u.adresse,u.region,u.image,u.sexe,u.question_securite,u.reponse_securite,u.description,c.estbloque from utilisateur u, client c, reservation r where r.id = ? ";
        Client c =new Client();
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery(requete);
            while(resultat.next()){
                
                c.setId(resultat.getInt(1));
                c.setNom(resultat.getString(2));
                c.setPrenom(resultat.getString(3));
                c.setEmail(resultat.getString(4));
                c.setPassword(resultat.getString(5));
                c.setDateNaissance(resultat.getDate(6));
                c.setNumTel(resultat.getInt(7));
                c.setAdresse(resultat.getString(8));
                c.setRegion(resultat.getString(9));
                c.setImage(resultat.getString(10));
                c.setSexe(resultat.getString(11).charAt(0));
                c.setQuestionSecurite(resultat.getString(12));
                c.setReponseSecurite(resultat.getString(13));
                c.setDescription(resultat.getString(13));
                c.setEstBloque(resultat.getString(13).charAt(0));


            }
            return c;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
