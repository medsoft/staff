package com.staff.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Entreprise {


    private IntegerProperty id ;
    private StringProperty name ;
    private StringProperty logo  ;
    private StringProperty manager  ;
    private StringProperty telephone;


    public Entreprise() {
        this.id = new SimpleIntegerProperty();
        this.name = new SimpleStringProperty();
        this.manager = new SimpleStringProperty();
        this.logo =  new SimpleStringProperty();
        this.telephone = new SimpleStringProperty();
    }

    public int getId(){
        return id.get() ;
    }

    public void setId (int id ){
        this.id.set(id);
    }


    public IntegerProperty  getEntrepriseId(){
        return id ;
    }

    public String getName(){
        return name.get() ;
    }

    public void setName (String name ){
        this.name.set(name);
    }


    public StringProperty  getEntrepriseName(){
        return name ;
    }


    public String getLogo(){
        return logo.get() ;
    }

    public void setLogo (String logo ){
        this.logo.set(logo);
    }


    public StringProperty  getEntrepriseLogo (){
        return logo ;
    }

    public String getManager(){
        return manager.get() ;
    }

    public void setManager (String manager ){
        this.manager.set(manager);
    }

    public StringProperty  getEntrepriseManager(){
        return manager ;
    }


    public String getTelephone(){
        return manager.get() ;
    }

    public void setTelephone (String telephone  ){
        this.telephone.set(telephone);
    }

    public StringProperty  getEntrepriseTelephone(){
        return telephone ;
    }
}
