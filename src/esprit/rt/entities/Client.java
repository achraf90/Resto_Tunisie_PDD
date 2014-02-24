package esprit.rt.entities;

/**
 *
 * @author Pingouins de désert
 * 
 */

class Client {
    
    private int id;
    private char estBloque;

    public Client() {
    }

    public Client(char estBloque) {
        this.estBloque = estBloque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getEstBloque() {
        return estBloque;
    }

    public void setEstBloque(char estBloque) {
        this.estBloque = estBloque;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (this.id == other.id)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", estBloque=" + estBloque + '}';
    }
    
   
    
    
    
}
