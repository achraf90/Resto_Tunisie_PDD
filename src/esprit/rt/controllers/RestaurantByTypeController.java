package esprit.rt.controllers;

import esprit.rt.dao.RestaurantDAO;
import esprit.rt.entities.Restaurant;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Pingouins de désert4
 * 
 */

public class RestaurantByTypeController extends AbstractTableModel{
    
    String[] headers = {"Id", "Nom", "Adresse", "Cordonnee", "Numéro téléphone", "Description", "URL", "Type"};
    List<Restaurant> listeRestaurants = new ArrayList<Restaurant>();
    private String type;
    public RestaurantByTypeController(String type) {

        RestaurantDAO restaurantDAO = new RestaurantDAO();
        listeRestaurants = restaurantDAO.findRestaurantsByType(type);
        this.type = type;
    }
    
    @Override
    public int getRowCount() {
        return listeRestaurants.size();
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
                return listeRestaurants.get(rowIndex).getId();
            case 1:
                return listeRestaurants.get(rowIndex).getNom();
            case 2:
                return listeRestaurants.get(rowIndex).getAdresse();
            case 3:
                return listeRestaurants.get(rowIndex).getCordonnee();
            case 4:
                return listeRestaurants.get(rowIndex).getNumTel();
            case 5:
                return listeRestaurants.get(rowIndex).getDescription();
            case 6:
                return listeRestaurants.get(rowIndex).getUrl();
            case 7:
                return listeRestaurants.get(rowIndex).getType();
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
