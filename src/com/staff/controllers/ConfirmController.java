package com.staff.controllers;

import com.staff.messages.NotifyMe;
import com.staff.model.CandidatDao;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.sql.SQLException;

public class ConfirmController     {

    @FXML
    private TextField idMissionTxt;

    @FXML
    private TextField statutTxt1;

    @FXML
    private TextField userIdTxt;

    @FXML
    private ImageView progress  ;

    private  int  stat =  4  ;

    @FXML
    public  void confirmMission ()  {
        progress.setVisible(true);
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.seconds(4));
        pt.setOnFinished(ev -> {


            if (userIdTxt.getText().trim().equals("") || statutTxt1.getText().trim().equals("") || idMissionTxt.getText().trim().equals("")) {
                NotifyMe notifyMe = new NotifyMe();
                notifyMe.showPopupNotification();
                progress.setVisible(false);
            } else {
                try {
                    CandidatDao.confirmMission(Integer.parseInt(userIdTxt.getText()), Integer.parseInt(statutTxt1.getText()), Integer.parseInt(idMissionTxt.getText()));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                NotifyMe notifyMe = new NotifyMe();
                notifyMe.showPopupNotificationWhenSoldeIsCredit();
                progress.setVisible(false);
            }
        });
        pt.play();
    }
    @FXML
    public void initialize()  throws  Exception {
        progress.setVisible(false);
        statutTxt1.setText(String.valueOf(stat));
        statutTxt1.setVisible(false);
    }

}
