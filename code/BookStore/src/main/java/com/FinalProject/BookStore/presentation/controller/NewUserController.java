package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.CartService;
import com.FinalProject.BookStore.business.CustomerService;
import com.FinalProject.BookStore.business.ShippingService;
import com.FinalProject.BookStore.business.UserService;
import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.entity.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class NewUserController {

    @FXML
    private TextField username;

    @FXML
    private TextField password;

    @FXML
    private TextField name;

    @FXML
    private TextField address;

    @FXML
    private TextField age;

    @FXML
    private TextField phone;

    @FXML
    private Button register;

    @FXML
    private Button back;

    @FXML
    private Label error;

    @Autowired
    UserService userService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ShippingService shippingService;

    public void handleButtonBack(javafx.event.ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        Scene scene = new Scene(root2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void handleButtonRegister(javafx.event.ActionEvent event) {
        if (userService.checkUsername(username.getText()) == false) {
            error.setText("Username already taken!");
            username.clear();
        }
        else {
            User user = new User(0, username.getText(), password.getText(), 1);
            ShippingInfo shippingInfo = new ShippingInfo(0, address.getText(), Integer.valueOf(age.getText()), phone.getText());
            Customer customer = new Customer(0, name.getText(), shippingInfo, user);
            userService.insertUser(user);
            shippingService.addNewShipping(shippingInfo);
            customerService.insertCustomer(customer);
            error.setText("Account successfully created!");
        }
    }
}
