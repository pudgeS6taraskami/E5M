package com.example.e5m_desk;

import javafx.fxml.FXML;
import javafx.print.Printer;
import javafx.scene.control.Label;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Window;
import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ResourceBundle;

public class HelloController{
    @FXML
    private Button button;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        Image image = new Image("file:C://Users//User//IdeaProjects//E5M_desk//src//main//resources//com//example//e5m_desk//1.png"); // Путь к вашему изображению
        ImageView imageView = new ImageView(image);

        Tooltip tooltip = new Tooltip();
        tooltip.setGraphic(imageView);
        tooltip.setText("Выбор Файла");

        button.setTooltip(tooltip);
    }
}