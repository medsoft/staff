package com.staff.controllers;
import com.jfoenix.controls.JFXButton;
import com.staff.messages.NotifyMe;
import com.staff.model.EntrepriseDao;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private JFXButton  buttonMission  ;
    @FXML
    AnchorPane  anchorAdmin  ;
    @FXML
    private JFXButton  buttonOptions  ;




    @FXML
    private ImageView drawerImage;

    @FXML
    private AnchorPane opacityPane;

    @FXML
    private AnchorPane drawerPane;



    @FXML
    private TextField nameTxt;

    @FXML
    private TextField imageTxt;

    @FXML
    private TextField managerTxt;

    @FXML
    private TextField telTxt;

    @FXML
    private JFXButton buttonAddEntreprise;

    @FXML
    private ImageView progress  , close ;
    @FXML
    private Pane rootPane ;


    @FXML
    public void openMission (ActionEvent event) {

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Mission.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }


    @FXML
    public void openEntreprise  (ActionEvent event)
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Entreprise.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }

    @FXML
    public void openCandidat  (ActionEvent event)
    {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Candidat.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setAlwaysOnTop(true);
    }


    @FXML
    public  void addNewEntreprise (ActionEvent event ) throws ClassNotFoundException , SQLException
    {
        opacityPane.setVisible(true);
        progress.setVisible(true);
        PauseTransition pt  =  new PauseTransition() ;
        pt.setDuration(Duration.seconds(5));
        pt.setOnFinished(ev-> {

            if (nameTxt.equals("") || imageTxt.equals("") || managerTxt.equals("") || telTxt.equals(""))
            {
                NotifyMe notifyMe  =  new NotifyMe() ;
                notifyMe.errorChampsNotify();
                progress.setVisible(false);
                opacityPane.setVisible(false);
            }else {
                try {
                    EntrepriseDao.addEntreprise(nameTxt.getText() , imageTxt.getText(), managerTxt.getText(), telTxt.getText());
                }catch (SQLException e){
                    e.printStackTrace();
                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }
                NotifyMe  notifyMe  =  new NotifyMe() ;
                notifyMe.whenUserIsAdded();
                progress.setVisible(false);
                opacityPane.setVisible(false);
            }
        });
        pt.play()  ;
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        opacityPane.setVisible(false);
        FadeTransition fadeTransition =  new FadeTransition(Duration.seconds(0.5),opacityPane) ;
        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);
        fadeTransition.play();
        TranslateTransition translateTransition =  new TranslateTransition(Duration.seconds(0.5),drawerPane) ;
        translateTransition.setByX(-600);
        translateTransition.play();

        drawerImage.setOnMouseClicked(event -> {
            opacityPane.setVisible(true);
            FadeTransition fadeTransition1 =  new FadeTransition(Duration.seconds(0.5),opacityPane) ;
            fadeTransition1.setFromValue(0);
            fadeTransition1.setToValue(0.15);
            fadeTransition1.play();

            TranslateTransition translateTransition1 =  new TranslateTransition(Duration.seconds(0.5),drawerPane) ;
            translateTransition1.setByX(+600);
            translateTransition1.play();
        });

        opacityPane.setOnMouseClicked(event -> {
            opacityPane.setVisible(true);
            FadeTransition fadeTransition1 =  new FadeTransition(Duration.seconds(0.5),opacityPane) ;
            fadeTransition1.setFromValue(0.15);
            fadeTransition1.setToValue(0);
            fadeTransition1.play();

            fadeTransition1.setOnFinished(event1 -> {
                opacityPane.setVisible(false);
            });
            TranslateTransition translateTransition1 =  new TranslateTransition(Duration.seconds(0.5),drawerPane) ;
            translateTransition1.setByX(-600);
            translateTransition1.play();
        });

        progress.setVisible(false);

    }
}
