package com.staff.model;

import com.staff.config.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MissionDao {



    public static ObservableList<Mission> getAllrecords() throws ClassNotFoundException , SQLException {
        String sql = "SELECT posts.id,posts.location,posts.title,posts.description,posts.role,posts.dress_code,posts.duree,posts.debut,posts.fin,posts.heure_debut,posts.heure_fin, posts.remuneration,posts.numero,entreprise.id_entreprise,entreprise.name_entreprise ,entreprise.logo FROM posts \n" +
                "                LEFT JOIN entreprise ON posts.entreprise_id =  entreprise.id_entreprise" ;
        try {
            ResultSet rs  =  DB.dbExecute(sql);
            ObservableList<Mission> misList = getMissionObjects(rs);
            return misList;
        }catch (SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }
    }

    private static  ObservableList<Mission> getMissionObjects(ResultSet rs )throws ClassNotFoundException , SQLException{
        try {
            ObservableList<Mission> misList = FXCollections.observableArrayList() ;
            while(rs.next()){
                Mission mis =  new Mission() ;

                mis.setTitle(rs.getString("title"));
                mis.setLocation(rs.getString("location"));
                mis.setDebut(rs.getString("debut"));
                mis.setNumero(rs.getString("numero"));
                mis.setEntreprise(rs.getString("name_entreprise"));

                misList.add(mis);
            }
            return misList;
        }catch(SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }

    }
}
