package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.UserService;
import com.FinalProject.BookStore.data.entity.ShoppingCart;
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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

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

    @Autowired
    ApplicationContext context;

    public void handelButtonLogIn(javafx.event.ActionEvent event) throws IOException {
        Integer type = userService.checkCredentials(username.getText(), password.getText());
        if (type == 2)
            error.setText("Username or password are incorrect!");
        else
            if (type == 0) {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/AdminView.fxml"));
                fxmlLoader.setControllerFactory(context::getBean);
                Parent root2 = fxmlLoader.load();
                Scene scene = new Scene(root2, 600, 400);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            else {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/UserView.fxml"));
                fxmlLoader.setControllerFactory(context::getBean);
                Parent root2 = fxmlLoader.load();

                BookViewController bookView = context.getBean(BookViewController.class);
                bookView.setUser(userService.findByUsername(username.getText()));

                ShoppingCartController cartController = context.getBean(ShoppingCartController.class);
                cartController.setUser(userService.findByUsername(username.getText()));

                MyAccountController accountController = context.getBean(MyAccountController.class);
                accountController.setUser(userService.findByUsername(username.getText()));

                Scene scene = new Scene(root2, 700, 450);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
    }

    public void handleButtonNewUser(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/NewUser.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root2 = fxmlLoader.load();
        Scene scene = new Scene(root2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }
}
