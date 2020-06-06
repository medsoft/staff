package com.staff.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Mission {



    private StringProperty title ;
    private StringProperty location ;
    private StringProperty debut ;
    private StringProperty numero ;
    private StringProperty entreprise ;


    public Mission ()
    {
       this.title=  new SimpleStringProperty();
       this.location=  new SimpleStringProperty();
       this.debut=  new SimpleStringProperty();
       this.numero=  new SimpleStringProperty();
       this.entreprise=  new SimpleStringProperty();
    }
    public String getTitle(){
        return title.get() ;
    }

    public void setTitle (String title ){
        this.title.set(title);
    }


    public StringProperty  getMissionTitle(){
        return title ;
    }


    public String getLocation(){
        return location.get() ;
    }

    public void setLocation (String location ){
        this.location.set(location);
    }


    public StringProperty  getMissionLocation(){
        return location ;
    }

    public String getDebut(){
        return debut.get() ;
    }

    public void setDebut (String debut ){
        this.debut.set(debut);
    }

    public StringProperty  getMissionDebut(){
        return debut ;
    }

    public String getNumero(){
        return numero.get() ;
    }

    public void setNumero (String numero ){
        this.numero.set(numero);
    }


    public StringProperty  getMissionNumero(){
        return numero ;
    }

    public String getEntreprise(){
        return entreprise.get() ;
    }

    public void setEntreprise (String entreprise ){
        this.entreprise.set(entreprise);
    }


    public StringProperty  getMissionEntreprise (){
        return entreprise ;
    }

}
