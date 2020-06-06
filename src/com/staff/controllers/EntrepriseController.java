package com.staff.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import com.staff.model.Entreprise;
import com.staff.model.EntrepriseDao;
import com.staff.model.Mission;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EntrepriseController  {


    @FXML
    private TextField chercherTxt;

    @FXML
    private ImageView progress, close ;

    @FXML
    private JFXButton buttonSearch;

    @FXML
    private JFXButton buttonAddMission;

    @FXML
    private JFXButton buttonRaffraichir;

    @FXML
    private TableView <Entreprise> tableviewEntreprise;


    @FXML
    private TableColumn<Entreprise, String> nomColumn;

    @FXML
    private TableColumn<Entreprise, String> managerColumn;

    @FXML
    private TableColumn<Entreprise, String> telColumn;

    @FXML
    private TableColumn<Entreprise, String> imageColumn;




    @FXML
    public void initialize()  throws  Exception {
        nomColumn.setCellValueFactory(cellData->cellData.getValue().getEntrepriseName());
        managerColumn.setCellValueFactory(cellData->cellData.getValue().getEntrepriseManager());
        imageColumn.setCellValueFactory(cellData->cellData.getValue().getEntrepriseLogo());
        telColumn.setCellValueFactory(cellData->cellData.getValue().getEntrepriseTelephone());
        ObservableList<Entreprise> enList  = EntrepriseDao.getAllrecords() ;
        populateTable(enList);
        progress.setVisible(false);


    }

    private void populateTable (ObservableList<Entreprise> enList ){
        tableviewEntreprise.setItems(enList);
    }


}
