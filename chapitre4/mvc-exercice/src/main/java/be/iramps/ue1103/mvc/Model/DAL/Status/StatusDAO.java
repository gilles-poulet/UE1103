package be.iramps.ue1103.mvc.Model.DAL.Status;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import be.iramps.ue1103.mvc.Model.BL.Status;

public class StatusDAO implements IStatusDAO {
    Connection connexion;
    PreparedStatement insertStatus;   
    PreparedStatement updateStatus;
    PreparedStatement deleteStatus;
    PreparedStatement getIDStatus;
    PreparedStatement getStatuss;


    public StatusDAO(Connection connexion) {
        try {
            this.connexion = connexion;
            Statement statement = connexion.createStatement();
            try {
                statement.executeUpdate("CREATE TABLE IF NOT EXISTS Status (id SERIAL PRIMARY KEY, nom VARCHAR(30))");
            } catch (SQLException e) {
                // La table existe déjà. Log pour le cas où.
                System.out.println(e.getMessage());
            }
            statement.close();
            this.insertStatus = this.connexion.prepareStatement("INSERT into Status (nom) VALUES (?)");
            this.updateStatus = this.connexion.prepareStatement("UPDATE Status SET nom=? WHERE id=?");
            this.deleteStatus = this.connexion.prepareStatement("DELETE FROM Status WHERE id=?");
            this.getIDStatus = this.connexion.prepareStatement("SELECT id FROM Status WHERE nom=?");
            this.getStatuss = this.connexion.prepareStatement("SELECT id,nom FROM Status");

            ;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public ArrayList<Status> getStatus() {
        ArrayList<Status> listeStatus = new ArrayList<Status>();
        try {
            ResultSet set = this.getStatuss.executeQuery();
            while (set.next()) {
                Status Status = new Status(set.getInt(1), set.getString(2));
                listeStatus.add(Status);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listeStatus;

    }

    @Override
    public int getIDStatus(String nom) {
        int id = -1;
        try {
            this.getIDStatus.setString(1, nom);
            ResultSet set = this.getIDStatus.executeQuery();
            while (set.next()) {
                id = set.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return id;
    }

    @Override
    public boolean updateStatus(int id, String nom) {
        try {        
            this.updateStatus.setString(1, nom);
            this.updateStatus.setInt(2, id);    
            this.updateStatus.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteStatus(int id) {
        try {
            this.deleteStatus.setInt(1, id);
            this.deleteStatus.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public boolean addStatus(String nom) {
        try {
            this.insertStatus.setString(1, nom);
            this.insertStatus.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public void close() {
       if (this.updateStatus != null) {
            try {
                this.updateStatus.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

        if (this.getIDStatus != null) {
            try {
                this.getIDStatus.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        if (this.deleteStatus != null) {
            try {
                this.deleteStatus.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        if (this.getStatuss != null) {
            try {
                this.getStatuss.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        if (this.insertStatus != null) {
            try {
                this.insertStatus.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}