package com.FinalProject.BookStore.presentation.controller;

import com.FinalProject.BookStore.data.entity.Product;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.IOException;


@Component
public class BookViewController {

    @FXML
    private ImageView imageView;

    @FXML
    private Button addToCart;

    @FXML
    private Button back;

    @FXML
    private Label title;

    @FXML
    private TextArea description;

    @FXML
    private Label price;

    private Product product;

    @Autowired
    ApplicationContext context;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void handleButtonBack(javafx.event.ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/UserView.fxml"));
        fxmlLoader.setControllerFactory(context::getBean);
        Parent root2 = fxmlLoader.load();
        Scene scene = new Scene(root2, 700, 450);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void handleButtonCart(javafx.event.ActionEvent event) {

    }

    public void init() {
        title.setText(product.getName());
        description.setText(product.getDescription());
        price.setText(product.getPrice().toString());

        String rocketImgStr = product.getImage();
        if(rocketImgStr!=null) {
            BASE64Decoder base64Decoder = new BASE64Decoder();
            ByteArrayInputStream rocketInputStream = null;
            try {
                rocketInputStream = new ByteArrayInputStream(base64Decoder.decodeBuffer(rocketImgStr));
            } catch (IOException e) {
                e.printStackTrace();
            }

            Image rocketImg = new Image(rocketInputStream);
            imageView.setImage(rocketImg);
        }
    }
}
