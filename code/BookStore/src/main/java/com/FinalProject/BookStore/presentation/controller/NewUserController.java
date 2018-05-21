package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.CartService;
import com.FinalProject.BookStore.business.CustomerService;
import com.FinalProject.BookStore.business.ShippingService;
import com.FinalProject.BookStore.business.UserService;
import com.FinalProject.BookStore.data.entity.Customer;
import com.FinalProject.BookStore.data.entity.ShippingInfo;
import com.FinalProject.BookStore.data.entity.ShoppingCart;
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
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

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

    @Autowired
    CartService cartService;

    @Autowired
    ApplicationContext context;

    public void handleButtonBack(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root2 = fxmlLoader.load();
        Scene scene = new Scene(root2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void handleButtonRegister(javafx.event.ActionEvent event) {
        if (!userService.checkUsername(username.getText())) {
            error.setText("Username already taken!");
            username.clear();
        }
        else {
            User user = new User(0, username.getText(), password.getText(), 1);
            ShippingInfo shippingInfo = new ShippingInfo(0, address.getText(), Integer.valueOf(age.getText()), phone.getText());

            if (!shippingService.checkAge(shippingInfo)) {
                error.setText("Age must be greater than 12!");
                age.clear();
            }
            else
                if (!shippingService.checkPhone(shippingInfo)) {
                    error.setText("Phone number must have 10 digits!");
                    phone.clear();
                }
                else {
                    userService.insertUser(user);
                    shippingService.addNewShipping(shippingInfo);
                    Customer customer = new Customer(0, name.getText(), shippingService.findByPhone(phone.getText()), userService.findByUsername(username.getText()));
                    customerService.insertCustomer(customer);

                    ShoppingCart cart = new ShoppingCart(0, userService.findByUsername(username.getText()), new ArrayList<>());
                    cartService.insertCart(cart);
                    error.setText("Account successfully created!");
                }
        }
    }
}
