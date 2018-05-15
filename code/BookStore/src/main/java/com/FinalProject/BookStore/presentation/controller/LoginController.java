package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.UserService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class LoginController {

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Button logIn;

    @FXML
    private Button newUser;

    @FXML
    private Label error;

    @Autowired
    UserService userService;

    public void handelButtonLogIn(javafx.event.ActionEvent event) throws IOException {
        Integer type = userService.checkCredentials(username.getText(), password.getText());
        if (type == 2)
            error.setText("Username or password are incorrect!");
        else
            if (type == 0) {
                Parent root2 = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
                Scene scene = new Scene(root2, 600, 400);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else {
                Parent root2 = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
                Scene scene = new Scene(root2, 600, 400);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
    }

    public void handleButtonNewUser(javafx.event.ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/NewUser.fxml"));
        Scene scene = new Scene(root2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
