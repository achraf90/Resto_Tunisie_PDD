/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package esprit.rt.dao;

import esprit.rt.entities.Reservation;
import esprit.rt.entities.Restaurant;
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
        
        String requete = "select reservation.id, reservation.date, reservation.nbr_place  from reservation , restaurant  where restaurant.id_restaurateur = ? and reservation.id_restaurant = restaurant.id";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ResultSet resultat = ps.executeQuery();
           
            while(resultat.next()){
                Reservation r =new Reservation();
                r.setId(resultat.getInt(1));
                r.setDate(resultat.getDate(2));
                r.setNbrPlace(resultat.getInt(3));
                listereservations.add(r);
            }
            return listereservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des réservations "+ex.getMessage());
            return null;
        }
    }
    public List<Reservation> getReservationsForIdEtat (int id_restaurateur, String etat)
    {
        List<Reservation> listereservations = new ArrayList<Reservation>();
        String requete = "select reservation.id, reservation.date, reservation.nbr_place  from reservation , restaurant  where restaurant.id_restaurateur = ? and reservation.id_restaurant = restaurant.id and reservation.etat = ?";
        try {
           PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           ps.setInt(1, SessionRestoTunisie.getId());
           ps.setString(2, etat);
           ResultSet resultat = ps.executeQuery();
          
            while(resultat.next()){
                Reservation r =new Reservation();
                r.setId(resultat.getInt(1));
                r.setDate(resultat.getDate(2));
                r.setNbrPlace(resultat.getInt(3));

                listereservations.add(r);
            }
            return listereservations;
        } catch (SQLException ex) {
            System.out.println("erreur lors du chargement des réservations "+ex.getMessage());
            return null;
        }
    }
        public void deleteReservation(int id){
        String requete = "delete from reservation where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Reservation supprimée");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
          }
         public void updateReservationInterGestRes(int id, String etat){
        String requete = "update reservation set etat=? where reservation.id=?  ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.setString(2, etat);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
  
    }

}
