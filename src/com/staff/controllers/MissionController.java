package com.staff.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.staff.model.Mission;
import com.staff.model.MissionDao;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MissionController  {

    @FXML
    private TableView tableviewMission  ;

    @FXML
    private TextField chercherTxt;

    @FXML
    private ImageView progress , addmission ;

    @FXML
    private JFXButton buttonSearch;

    @FXML
    private JFXButton buttonAddMission;

    @FXML
    private JFXButton buttonRaffraichir;

    @FXML
    private TableColumn<Mission, String> identifiant;

    @FXML
    private TableColumn<Mission, String> titreColumn;

    @FXML
    private TableColumn<Mission, String> dateColumn;

    @FXML
    private TableColumn<Mission, String> lieuColumn;

    @FXML
    private TableColumn<Mission, String> entrepriseColumn;





    @FXML
    public  void  addNewMission ()
    {
        addmission.setOnMouseClicked(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/NewMission.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setAlwaysOnTop(true);
        });
    }


    @FXML
    public void initialize() throws  Exception  {

        progress.setVisible(false);
        //titreColumn.setCellValueFactory(cellData->cellData.getValue().getMissionTitle());
        titreColumn.setCellValueFactory(new PropertyValueFactory<Mission, String>("title"));
        lieuColumn.setCellValueFactory(cellData->cellData.getValue().getMissionLocation());
        dateColumn.setCellValueFactory(cellData->cellData.getValue().getMissionDebut());
        identifiant.setCellValueFactory(cellData->cellData.getValue().getMissionNumero());
        entrepriseColumn.setCellValueFactory(cellData->cellData.getValue().getMissionEntreprise());

        ObservableList<Mission> misList  = MissionDao.getAllrecords() ;
        populateTable(misList);
        addNewMission() ;
    }


    private void populateTable (ObservableList<Mission> misList ){
        tableviewMission.setItems(misList);
    }
}
