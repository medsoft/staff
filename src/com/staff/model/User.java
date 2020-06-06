package com.staff.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

    private IntegerProperty idProperty ;
    private StringProperty nameProperty  ;
    private   StringProperty  lastnameProperty  ;
    private   StringProperty  emailProprerty  ;
    private   StringProperty  passwordProprerty  ;

    public User() {
        this.idProperty = new SimpleIntegerProperty() ;
        this.nameProperty = new SimpleStringProperty() ;
        this.lastnameProperty = new SimpleStringProperty() ;
        this.emailProprerty = new SimpleStringProperty() ;
        this.passwordProprerty = new SimpleStringProperty() ;

    }

    public int getUsId(){
        return idProperty.get() ;
    }
    public void setUsId (int id ){
        this.idProperty.set(id);
    }


    public IntegerProperty getUserId(){
        return idProperty ;
    }


    public String getUsName(){
        return nameProperty.get() ;
    }
    public void setUsName (String name ){
        this.nameProperty.set(name);
    }


    public StringProperty getUserName(){
        return nameProperty ;
    }

    public String getUsLastname(){
        return lastnameProperty.get() ;
    }
    public void setUsLastname (String lastname ){
        this.lastnameProperty.set(lastname);
    }


    public StringProperty getUserLastname(){
        return lastnameProperty ;
    }

    public String getUsEmail(){
        return lastnameProperty.get() ;
    }
    public void setUsEmail (String email ){
        this.emailProprerty.set(email);
    }


    public StringProperty getUserEmail(){
        return emailProprerty ;
    }

    public String getUsPassword(){
        return passwordProprerty.get() ;
    }
    public void setUsPassword (String password ){
        this.passwordProprerty.set(password);
    }


    public StringProperty getUserPassword(){
        return passwordProprerty ;
    }

}
