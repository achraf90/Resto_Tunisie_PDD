/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Reservation;
import esprit.rt.utilities.MyConnection;
import esprit.rt.utilities.SessionRestoTunisie;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aditsan Kadmus
 */
public class ReservationDAO {
    public List<Reservation> getReservationsForId (int id_restaurateur)
    {
        List<Reservation> listereservations = new ArrayList<Reservation>();

        String requete = "select * from reservation r, restaurant res, s where res.id_restaurant = ? and r.id_restaurant = res.id";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ResultSet resultat = ps.executeQuery();
           Reservation r =new Reservation();
            while(resultat.next()){
                
                r.setId(resultat.getInt(1));

                listereservations.add(r);
            }
            return listereservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des restaurant "+ex.getMessage());
            return null;
        }
    }
}
