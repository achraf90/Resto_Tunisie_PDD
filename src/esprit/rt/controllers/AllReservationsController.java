package esprit.rt.controllers;

import esprit.rt.dao.ReservationDAO;
import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Reservation;
import esprit.rt.entities.Restaurant;
import esprit.rt.utilities.SessionRestoTunisie;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pingouins de désert
 * 
 */

public class AllReservationsController extends AbstractTableModel{

    String[] headers = {"Id","Date", "Nombre place"};
    List<Reservation> listeReservations = new ArrayList<Reservation>();
    
    public AllReservationsController() {

        ReservationDAO reservationDAO = new ReservationDAO();
        listeReservations = reservationDAO.getReservationsForId(SessionRestoTunisie.getId());
    }
    
    @Override
    public int getRowCount() {
        return listeReservations.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex)
        {
            case 0:
                return listeReservations.get(rowIndex).getId();
            case 1:
                return listeReservations.get(rowIndex).getDate();
            case 2:
                return listeReservations.get(rowIndex).getNbrPlace();
            default:
                return "erreur";
        }
    }
    
    @Override
    public String getColumnName(int column)
    {
        return headers[column];
    }
    
   
}
