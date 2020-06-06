package com.staff.controllers;

import com.jfoenix.controls.JFXButton;
import com.staff.messages.NotifyMe;
import com.staff.model.User;
import com.staff.model.UserDao;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField emailTxt;

    @FXML
    private PasswordField passwordTxt;

    @FXML
    private JFXButton buttonConnect;

    @FXML
    private ImageView progress , close;

    @FXML
    private Text text;

    private UserDao userDao ;

    @FXML
    public void connection(ActionEvent event) throws SQLException, ClassNotFoundException {
        Image staff = new Image("/com/staff/images/staff.png");
        progress.setVisible(true);
        text.setVisible(true);
        PauseTransition pt  =  new PauseTransition() ;
        pt.setDuration(Duration.seconds(4));
        pt.setOnFinished(ev->{


            String email = emailTxt.getText() ;
            String password  = passwordTxt.getText() ;

            if (email.trim().equals("") || password.trim().equals("")) {
                NotifyMe notifyMe =  new NotifyMe();
                notifyMe.errorChampsNotify();

                progress.setVisible(false);
            }else{
                userDao = new UserDao() ;
                User myUser  = null;
                try {
                    myUser = userDao.getLogin(email , password);
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
                if (myUser != null){


                    ((Node) event.getSource()).getScene().getWindow().hide();
                    Parent root = null;
                    try {
                        root = FXMLLoader.load(getClass().getResource("/com/staff/controllers/Admin.fxml"));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root);
                    Stage primaryStage = new Stage();
                    primaryStage.setScene(scene);
                    primaryStage.show();
                    NotifyMe notifyMe = new NotifyMe();
                    notifyMe.access();
                    progress.setVisible(false);


                }else {

                    NotifyMe notifyMe = new NotifyMe();
                    notifyMe.mauvaisIdentifiants();
                    progress.setVisible(false);

                }
            }

        });
        pt.play();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
            progress.setVisible(false);
            text.setVisible(false);

    }
}
