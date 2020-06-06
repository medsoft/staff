package com.staff.messages;

import javafx.scene.image.Image;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.TrayNotification;

/**
 * Created by macbookair on 16/02/2018.
 */
public class NotifyMe {
    Image staff = new Image("/com/staff/images/staff.png");
   public void errorChampsNotify() {

       TrayNotification tray = new TrayNotification();
       tray.setTitle("Informations  Staff ");
       tray.setTrayIcon(staff);
       tray.setImage(staff);
       tray.setMessage("Veuillez remplir tous les informations ");
       tray.setRectangleFill(Paint.valueOf("#323552"));
       tray.setAnimationType(AnimationType.SLIDE);
       tray.showAndDismiss(Duration.seconds(5));
       tray.showAndWait();
   }

   public void access () {
       TrayNotification tray = new TrayNotification();
       tray.setImage(staff);
       tray.setTitle("Informations  Staff");
       tray.setMessage("Vous pouvez acceder a votre  espace");
       tray.setRectangleFill(Paint.valueOf("#323552"));
       tray.setAnimationType(AnimationType.SLIDE);
       tray.showAndDismiss(Duration.seconds(3));
   }

   public  void mauvaisIdentifiants () {

       TrayNotification tray = new TrayNotification();
       tray.setImage(staff);
       tray.setTitle("Informations  Staff");
       tray.setMessage("Vos identifiants ne coresspondent pas ");
       tray.setRectangleFill(Paint.valueOf("#323552"));
       tray.setAnimationType(AnimationType.SLIDE);
       tray.showAndDismiss(Duration.seconds(3));

   }
    public  void whenUserIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations  Staff ");
        tray.setMessage(" Un nouvel entreprise vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void whenClientrIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle(" Informations  Staff");
        tray.setMessage(" Un nouveau  client vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void whenAccountrIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations  Staff ");
        tray.setMessage(" Un nouveau  compte  vient d'etre creer  ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));
    }
    public  void whenTasksIsAdded () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage(" Un nouvelle   tache  vient d'etre ajouter ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.SLIDE);
        tray.showAndDismiss(Duration.seconds(3));

    }
    public void showPopupNotification () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage("Merci de  remplir tous les champs  ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

    public void showPopupNotificationWhenSoldeIsCredit () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage("La mission a bien été attribue ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

    public void showPopupNotificationWhenSoldeIsCredi () {
        TrayNotification tray = new TrayNotification();
        tray.setImage(staff);
        tray.setTitle("Informations Staff ");
        tray.setMessage("La mission a été refusé   ");
        tray.setRectangleFill(Paint.valueOf("#323552"));
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
    }

}
