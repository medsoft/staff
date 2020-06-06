package com.staff.config;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DB {

    private static String JDBC_DRIVER  = "com.mysql.jdbc.Driver" ;
    private static Connection connection = null  ;
    private static final  String connection_string = "jdbc:mysql://localhost/nawanam";

    public  static  void connect ()throws SQLException, ClassNotFoundException
    {
        try{
            Class.forName(JDBC_DRIVER) ;
        }catch(ClassNotFoundException e){
            System.out.println("MYSQL JDBC introuvable ? ") ;
            e.printStackTrace();
        }
        System.out.println("JDBC EST BIEN PRESENT") ;

        try{
            connection  = DriverManager.getConnection(connection_string ,"root" , "") ;
        }catch (SQLException e){
            System.out.println("Connection impossible " + e);
            throw  e ;

        }
    }
    public static void disconnect() throws  SQLException{
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }catch (Exception e){
            throw e ;
        }
    }

    //pour inseerer modifier et supprimer
    public static void  dbExecuteQuery (String sqlStmt)  throws SQLException , ClassNotFoundException{
        Statement stmt  = null  ;
        try{
            connect();
            stmt = connection.createStatement() ;
            stmt.executeUpdate(sqlStmt) ;

        }catch(SQLException e ){

            System.out.println("Erreurs survenues lors de l'operation" + e ) ;
            throw  e  ;
        }
        finally{
            if (stmt!=null){
                stmt.close() ;
            }
            disconnect();
        }
    }
    public static ResultSet dbExecute (String sqlQuery) throws  ClassNotFoundException , SQLException {
        Statement stmt  = null ;
        ResultSet rs  =  null ;
        CachedRowSetImpl crs  = null ;

        try{
            connect() ;
            stmt = connection.createStatement() ;
            rs = stmt.executeQuery(sqlQuery) ;
            crs  = new CachedRowSetImpl() ;
            crs.populate(rs) ;
        }
        catch(SQLException e) {

            System.out.println("Erreur lors de l'execution de la requette " + e);
            throw  e ;
        }
        finally {
            if (rs != null ){
                rs.close();
            }
            if(stmt != null){
                stmt.close();
            }
            disconnect();
        }
        return crs ;
    }
}
