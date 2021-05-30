package com.my;

import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * клас графічного інтерфейсу, який контролює дії користувача при роботі з продуктом
 * @author Sheketa
 */

public class ProductController {

    private Product product;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Hyperlink urlLink;

    @FXML
    void initialize() {
        urlLink.setOnAction(e -> {
            try {
                Desktop.getDesktop().browse(new URL(urlLink.getText()).toURI());
            } catch (IOException | URISyntaxException ioException) {
                ioException.printStackTrace();
            }
        });
    }

    public void setProduct(Product product) {
        this.product = product ;
        priceLabel.textProperty().unbind();
        if (product == null) {
            nameLabel.setText(null);
            priceLabel.setText(null);
            urlLink.setText(null);
        } else {
            nameLabel.setText(product.getName());
            priceLabel.setText(product.getPrice());
            urlLink.setText(product.getUrl());
        }
    }
}

