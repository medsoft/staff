package com.staff.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Candidat {

    private SimpleStringProperty titre  ;
    private SimpleStringProperty numero  ;
    private SimpleStringProperty debut  ;
    private SimpleStringProperty email  ;
    private SimpleStringProperty username  ;
    private SimpleStringProperty entreprise  ;
    private SimpleStringProperty logo  ;
    private SimpleIntegerProperty statut ;
    private SimpleIntegerProperty identifiantMission ;
    private SimpleIntegerProperty identifiantUtilisateur ;



    public Candidat  ()
    {
        this.titre =  new SimpleStringProperty() ;
        this.numero =  new SimpleStringProperty() ;
        this.debut =  new SimpleStringProperty() ;
        this.email =  new SimpleStringProperty() ;
        this.username =  new SimpleStringProperty() ;
        this.entreprise =  new SimpleStringProperty() ;
        this.logo =  new SimpleStringProperty() ;
        this.statut =  new SimpleIntegerProperty() ;
        this.identifiantMission =  new SimpleIntegerProperty() ;
        this.identifiantUtilisateur =  new SimpleIntegerProperty() ;

    }



    public String getTitre() {
        return titre.get() ;
    }

    public void setTitre (String titre ){
        this.titre.set(titre);
    }


    public StringProperty getCandidatTitre(){
        return titre ;
    }




    public String getNumero(){
        return numero.get() ;
    }

    public void setNumero (String numero){
        this.numero.set(numero);
    }


    public StringProperty getCandidatNumero(){
        return numero ;
    }






    public String getDebut(){
        return debut.get() ;
    }

    public void setDebut (String debut ){
        this.debut.set(debut);
    }


    public StringProperty getCandidatDebut(){
        return debut ;
    }



    public String getEmail(){
        return email.get() ;
    }

    public void setEmail (String email ){
        this.email.set(email);
    }


    public StringProperty getCandidatEmail(){
        return email ;
    }




    public String getUsername(){
        return titre.get() ;
    }

    public void setUsername (String username ){
        this.username.set(username);
    }


    public StringProperty getCandidatUsername(){
        return username;
    }




    public String getEntreprise(){
        return entreprise.get() ;
    }

    public void setEntreprise (String  entreprise ){
        this.entreprise.set(entreprise);
    }


    public SimpleStringProperty getCandidatEntreprise(){
        return entreprise ;
    }


    public String getLogo(){
        return logo.get() ;
    }

    public void setLogo (String  logo ){
        this.logo.set(logo);
    }


    public StringProperty getCandidatLogo(){
        return logo ;
    }




    public int getStatut(){
        return statut.get() ;
    }

    public void setStatut (int  statut ){
        this.statut.set(statut);
    }


    public IntegerProperty getCandidatStatut(){
        return statut ;
    }




    public int getIdentifiantMission(){
        return identifiantMission.get() ;
    }

    public void setIdentifiantMission (int  identifiantMission ){
        this.identifiantMission.set(identifiantMission);
    }


    public IntegerProperty getIdenttMission(){
        return identifiantMission ;
    }



    public int getIdentifiantUtilisateur(){
        return identifiantUtilisateur.get() ;
    }

    public void setIdentifiantUtilisateur (int  identifiantUtilisateur ){
        this.identifiantUtilisateur.set(identifiantUtilisateur);
    }


    public IntegerProperty getIdentUtilisateur(){
        return identifiantUtilisateur ;
    }


}
