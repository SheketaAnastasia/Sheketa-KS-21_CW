package com.my;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 * Клас який контролює дії користувача у програмі
 * @author Sheketa
 */

public class ApplicationController {

    @FXML
    private TextField searchField;

    @FXML
    private CheckBox foxtrotCheckBox;

    @FXML
    private CheckBox moyoCheckBox;

    @FXML
    private CheckBox pnCheckBox;

    @FXML
    private CheckBox alloCheckBox;

    @FXML
    private ListView<Product> searchList;

    @FXML
    void initialize() {
        searchList.setCellFactory(lv -> new ProductListCell());
    }


    /**
     * метод для пошуку продуктів на сайтах та відображення їх на головному екрані
     * @author Sheketa
     */

    @FXML
    void searchProduct(){

        searchList.getItems().clear();
        if (searchField.getText().isEmpty()){
            return;
        }

        ObservableList<Product> products = searchList.getItems();
        if (foxtrotCheckBox.isSelected()){
            products.addAll(SearchProduct.searchInFoxtrot(searchField.getText()));
        }
        if (moyoCheckBox.isSelected()){
            products.addAll(SearchProduct.searchInMOYO(searchField.getText()));
        }
        if (alloCheckBox.isSelected()){
            products.addAll(SearchProduct.searchInAllo(searchField.getText()));
        }
        if (pnCheckBox.isSelected()){
            products.addAll(SearchProduct.searchInPn(searchField.getText()));
        }
    }
}
