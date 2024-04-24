package com.example.e5m_desk;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.io.IOException;



public class HelloApplication extends Application {
    private String secretKey = "7014021028035042";
    private FileChooser fileChooser = new FileChooser();
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Button button = new Button("Выберите файл");
        double translate = 100;
        button.setTranslateX(translate);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    onHelloButtonClick();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Image image = new Image(getClass().getResourceAsStream("1.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        VBox lay = new VBox(100, button);
        Scene scene = new Scene((Parent) fxmlLoader.load(), 1000, 600);
        lay.setStyle("-fx-background-color: #FFFFFF");
Image ico = new Image("com/example/e5m_desk/E5M_LOGO.png");
stage.getIcons().add(ico);
        stage.setTitle("E5M");
        stage.setScene(scene);

        stage.show();

    }


    @FXML
    protected void onHelloButtonClick() throws IOException {
        fileChooser.setTitle("Выберите файл");
        File selectedFile = fileChooser.showOpenDialog(new Stage());
        String originalFilePath = selectedFile.getAbsolutePath();
        String path = selectedFile.getParent();
        System.out.println(path);
        String encryptFile1 = path + "\\encrypt.txt";
        System.out.println(encryptFile1);
        encryptFile(originalFilePath, encryptFile1, secretKey);
        deleteFile(originalFilePath);

    }

    public static void encryptFile(String inputFilePath, String outputFilePath, String secretKey) {
        try {
            SecretKeySpec key = new SecretKeySpec(secretKey.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            try (InputStream in = new FileInputStream(inputFilePath);
                 OutputStream out = new CipherOutputStream(new FileOutputStream(outputFilePath), cipher)) {
                byte[] buffer = new byte[8192];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
        } catch (IOException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String filePath) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch();
    }
}