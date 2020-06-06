package com.staff.model;

import com.staff.config.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidatDao {


    public static ObservableList<Candidat> getAllrecords() throws ClassNotFoundException , SQLException {
        String sql = "  SELECT postulants.id,postulants.statut,postulants.user_id,postulants.id_mission, users.username,users.email, posts.location,posts.title,posts.remuneration,posts.debut,posts.numero,entreprise.id_entreprise,entreprise.name_entreprise,entreprise.logo,entreprise.manager,entreprise.telephone\n" +
                "                FROM postulants\n" +
                "                LEFT JOIN users ON postulants.user_id =  users.id \n" +
                "                LEFT JOIN posts ON postulants.id_mission = posts.id\n" +
                "                LEFT JOIN entreprise ON postulants.entreprise_id = entreprise.id_entreprise"  ;
        try {
            ResultSet rs  =  DB.dbExecute(sql);
            ObservableList<Candidat> candidatList = getCandidatObjects(rs);
            return candidatList;
        }catch (SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }
    }

    private static  ObservableList<Candidat> getCandidatObjects(ResultSet rs )throws ClassNotFoundException , SQLException{
        try {
            ObservableList<Candidat> candidatList = FXCollections.observableArrayList() ;
            while(rs.next()){
                Candidat candidat =  new Candidat() ;
                candidat.setTitre(rs.getString("title"));
                candidat.setDebut(rs.getString("debut"));
                candidat.setNumero(rs.getString("numero"));
                candidat.setEntreprise(rs.getString("name_entreprise"));
                candidat.setUsername(rs.getString("username"));
                candidat.setEmail(rs.getString("email"));
                candidat.setLogo(rs.getString("logo"));
                candidat.setStatut(rs.getInt("statut"));
                candidat.setIdentifiantMission(rs.getInt("id_mission"));
                candidat.setIdentifiantUtilisateur(rs.getInt("user_id"));

                candidatList.add(candidat);
            }
            return candidatList;
        }catch(SQLException e){
            System.out.println("Une erreur est survenue lors de l'execution");
            e.printStackTrace();
            throw e ;
        }

    }

    public static ObservableList<Candidat> searchCandidat(int id )throws  ClassNotFoundException , SQLException{
        String sql  = " SELECT postulants.id,postulants.statut,postulants.user_id,postulants.id_mission, users.username,users.email, posts.location,posts.title,posts.remuneration,posts.debut,posts.numero,entreprise.id_entreprise,entreprise.name_entreprise,entreprise.logo,entreprise.manager,entreprise.telephone\n" +
        "                FROM postulants\n" +
                "                LEFT JOIN users ON postulants.user_id =  users.id \n" +
                "                LEFT JOIN posts ON postulants.id_mission = posts.id\n" +
                "                LEFT JOIN entreprise ON postulants.entreprise_id = entreprise.id_entreprise" +
                "                  WHERE posts.id="+id  ;
        try{
            ResultSet rs  =  DB.dbExecute(sql) ;
            ObservableList<Candidat> list =  getCandidatObjects(rs) ;
            return list ;
        }catch (SQLException e){
            e.printStackTrace();
            throw  e ;
        }
    }

    public static  void confirmMission (int user_id ,  int statut  , int id_mission  ) throws  ClassNotFoundException ,SQLException  {
        String sql  =  "UPDATE  postulants  SET statut= '"+statut+"' where user_id = '"+user_id+"' AND id_mission="+id_mission ;
        try{
            DB.dbExecuteQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
            throw  e  ;
        }
    }

    public static  void refuseMission (int user_id ,  int statut  , int id_mission  ) throws  ClassNotFoundException ,SQLException  {
        String sql  =  "UPDATE  postulants  SET statut= '"+statut+"' where user_id = '"+user_id+"' AND id_mission="+id_mission ;
        try{
            DB.dbExecuteQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
            throw  e  ;
        }
    }
}


