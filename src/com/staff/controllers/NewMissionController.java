package com.staff.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class NewMissionController implements Initializable {
    @FXML
    public  Text textloading  ;
    @FXML
    public ImageView progress ;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            progress.setVisible(false);
            textloading.setVisible(false);
    }
}
