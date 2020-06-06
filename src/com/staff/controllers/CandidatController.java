package com.staff.controllers;

import com.jfoenix.controls.JFXButton;
import com.staff.messages.NotifyMe;
import com.staff.model.Candidat;
import com.staff.model.CandidatDao;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import net.sf.jasperreports.components.items.Item;

import java.io.IOException;
import java.sql.SQLException;

public class CandidatController {

    @FXML
    private Text textCandi  ;

    @FXML
    private TextField searchTxt;

    @FXML
    private ImageView progress;

    @FXML
    private JFXButton buttonSearch;

    @FXML
    private JFXButton buttonAddMission;



    @FXML
    private TableView<Candidat> tableviewCandidat ;

    @FXML
    private TableColumn<Candidat, String> candidatColumn;
    @FXML
    private TableColumn<Candidat, Integer> statutColumn;

    @FXML
    private TableColumn<Candidat, String> entrepriseColumn;

    @FXML
    private TableColumn<Candidat, String> emailColumn;

    @FXML
    private TableColumn<Candidat, String> missionColumn;

    @FXML
    private TableColumn<Candidat, String> debutColumn;
    @FXML
    private TableColumn<Candidat, String> numeroColumn;
    @FXML
    private TableColumn<Candidat, Integer> idmColumn;
    @FXML
    private TableColumn<Candidat, Integer> iduColumn ;




    @FXML
    private ImageView drawerImage , reload  , confirm , refus , close ;



    @FXML
    public void initialize() throws Exception {
        candidatColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatUsername());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatEmail());

        missionColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatTitre());
        debutColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatDebut());
       // entrepriseColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatEntreprise());
        entrepriseColumn.setCellValueFactory(new PropertyValueFactory<Candidat, String>("entreprise"));
        numeroColumn.setCellValueFactory(cellData -> cellData.getValue().getCandidatNumero());
        idmColumn.setCellValueFactory(cellData -> cellData.getValue().getIdenttMission().asObject());
        iduColumn.setCellValueFactory(cellData -> cellData.getValue().getIdentUtilisateur().asObject());

        ObservableList<Candidat> candidatList = CandidatDao.getAllrecords();
        populateTable(candidatList);
        progress.setVisible(false);
        searchAll();
        confirm() ;
        refus();
       //searchTxt.setStyle("-fx-text-inner-color:#FFFFFF ");

        tableviewCandidat.selectionModelProperty().addListener((Observable observable )-> {
                    int index = tableviewCandidat.getSelectionModel().getSelectedIndex();
                    Candidat candidat = tableviewCandidat.getItems().get(index);
                        textCandi.setText(candidat.getTitre());
                });
    }
    private void populateTable(ObservableList<Candidat> candidatList) {
        tableviewCandidat.setItems(candidatList);
    }

    @FXML
    private void searchAll(){

       reload.setOnMouseClicked(event1 -> {
           progress.setVisible(true);
           PauseTransition pt = new PauseTransition();
           pt.setDuration(Duration.seconds(3));
           pt.setOnFinished(ev -> {
               ObservableList<Candidat> candidatsList = null;
               try {
                   candidatsList = CandidatDao.getAllrecords();
               } catch (ClassNotFoundException e) {
                   e.printStackTrace();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
               progress.setVisible(false);
               populateTable(candidatsList);
               searchTxt.setText("");

           });
           pt.play();
       });
    }

    @FXML
    public  void  confirm ()
    {
        confirm.setOnMouseClicked(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Confirm.fxml"));
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
    public  void  refus ()
    {
        refus.setOnMouseClicked(event -> {
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Refus.fxml"));
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
    public  void   searchCandidat  (ActionEvent event) {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(4));
        pt.setOnFinished(ev -> {

            if (searchTxt.getText().trim().equals("")) {
                NotifyMe notifyMe =  new NotifyMe() ;
                notifyMe.showPopupNotification();
                progress.setVisible(false);
            } else {
                ObservableList<Candidat> list = null;
                try {
                    list = CandidatDao.searchCandidat(Integer.parseInt(searchTxt.getText()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                populateTablePostulants(list);
                progress.setVisible(false);
                searchTxt.setText("");
            }
        });
        pt.play();
    }

    public  void populateTablePostulants(ObservableList<Candidat> list){
        tableviewCandidat.setItems(list) ;
    }

}
