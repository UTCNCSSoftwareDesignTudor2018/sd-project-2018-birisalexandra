package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.business.ProductService;
import com.FinalProject.BookStore.data.entity.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
public class UserViewController implements Initializable {

    @FXML
    private ListView<String> listView;

    @FXML
    private Button shoppingCart;

    @FXML
    private Button myAccount;

    @FXML
    private Button logOut;

    @Autowired
    ApplicationContext context;

    @Autowired
    ProductService productService;

    public void openBook() {

    }

    public void handleCartButton(javafx.event.ActionEvent event) {

    }

    public void handleAccountButton(javafx.event.ActionEvent event) {

    }

    public void handleLogOutButton(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root2 = fxmlLoader.load();
        Scene scene = new Scene(root2, 600, 400);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Product> products = productService.findAllProducts();
        List<String> list = new ArrayList<>();
        for(Product p : products) {
            list.add(p.getName());
            System.out.println(p.getName());
        }

        listView = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(list);
        listView.setItems(items);
    }
}