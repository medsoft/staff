package com.staff.model;

import com.staff.config.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrepriseDao {




    public static  void addEntreprise (String name_entreprise  , String logo  , String manager , String telephone ) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO entreprise (name_entreprise,logo,manager,telephone ) VALUES ('" +name_entreprise+ "' , '" +logo+ "', '" +manager+ "', '" +telephone+ "' )" ;
        try {
            DB.dbExecuteQuery(sql);
        }catch (SQLException e){
            System.out.println("probleme est survenu lors de l'insertiion " + e );
            throw  e ;
        }
    }

    public static ObservableList<Entreprise> getAllrecords() throws ClassNotFoundException , SQLException {
        String sql = "SELECT * FROM entreprise" ;
        try {
            ResultSet rs  =  DB.dbExecute(sql);
            ObservableList<Entreprise> entrepriseList = getEntrepriseObjects(rs);
            return entrepriseList;
        }catch (SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }
    }

    private static  ObservableList<Entreprise> getEntrepriseObjects(ResultSet rs )throws ClassNotFoundException , SQLException{
        try {
            ObservableList<Entreprise> entrepList = FXCollections.observableArrayList() ;
            while(rs.next()){
                Entreprise entreprise =  new Entreprise() ;
                entreprise.setId(rs.getInt("id_entreprise"));
                entreprise.setName(rs.getString("name_entreprise"));
                entreprise.setLogo(rs.getString("logo"));
                entreprise.setManager(rs.getString("manager"));
                entreprise.setTelephone(rs.getString("telephone"));
                entrepList.add(entreprise);
            }
            return entrepList;
        }catch(SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }

    }
}
