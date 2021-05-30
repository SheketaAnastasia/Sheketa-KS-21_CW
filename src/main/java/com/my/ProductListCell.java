package com.my;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ContentDisplay;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.UncheckedIOException;

/**
 * Клас, який розширює ListCell для роботи з продуктом
 * @author Sheketa
 */

public class ProductListCell extends javafx.scene.control.ListCell<Product> {

    private final Pane stockView ;
    private final ProductController productController ;

    public ProductListCell() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Product.fxml"));
            stockView = loader.load();
            productController = loader.getController();
            setGraphic(stockView);
            setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
        } catch (IOException exc) {
            throw new UncheckedIOException(exc);
        }
    }

    @Override
    protected void updateItem(Product item, boolean empty) {
        super.updateItem(item, empty);
        productController.setProduct(item);
    }
}
