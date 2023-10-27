package com.example.newfractaldraft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    //idk if i need these but this yt tutorial puts them here
    //and i dont want my code to not work and not know why so ill delete them later if needed

    @FXML

    //we talked about IO in class but its like 11pm so im blanking rn on what this actually does
    public void switchToJulia(ActionEvent event) throws IOException
    {
        Pane juliaRoot = FXMLLoader.load(getClass().getResource("juliaScene.fxml"));
        //i had to google this because i didnt know why it wouldnt let me use the getChildren method
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // i still dont really get what this does
        Scene juliaScene = new Scene(juliaRoot,1000,700);
        Julia julia = new Julia();
        WritableImage controllerImage = julia.getJuliaImage();
        ImageView controllerImageView = new ImageView(controllerImage);
        juliaRoot.getChildren().add(controllerImageView);

        //now im gonna center it so it looks pretty
        controllerImageView.setTranslateX(100);
        controllerImageView.setTranslateY(50);
        stage.setScene(juliaScene);
        stage.show();

    }

    //this is where i would create and plot a new julia fractal on a button click
}