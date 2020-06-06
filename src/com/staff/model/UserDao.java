package com.staff.model;

import com.staff.config.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    public User  getLogin (String email , String password )throws SQLException, ClassNotFoundException {
        User usr  =  null ;
        String sql = "SELECT * FROM admin Where email   = '"+email+"' AND password = '"+password+"' " ;
        ResultSet rs  =  DB.dbExecute(sql);
        try{
            DB.dbExecute(sql);
            while (rs.next()){
                usr = new User();
                usr.setUsEmail(rs.getString("email"));
                usr.setUsPassword(rs.getString("password"));
            }

        }catch (SQLException e){
            System.out.println("une erreur est survenue");
            e.printStackTrace();
            throw  e ;
        }
        return  usr ;
    }
}
