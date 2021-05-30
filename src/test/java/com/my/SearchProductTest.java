package com.my;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SearchProductTest {

    @Test
    void searchInAlloTest(){
        List<Product> products = SearchProduct.searchInAllo("samsung");
        Assertions.assertFalse(products.isEmpty());
    }
    @Test
    void searchInPnTest(){
        List<Product> products = SearchProduct.searchInPn("samsung");
        Assertions.assertFalse(products.isEmpty());
    }
    @Test
    void searchInMOYOTest(){
        List<Product> products = SearchProduct.searchInMOYO("samsung");
        Assertions.assertFalse(products.isEmpty());
    }
    @Test
    void searchInFoxtrotTest(){
        List<Product> products = SearchProduct.searchInFoxtrot("samsung");
        Assertions.assertFalse(products.isEmpty());
    }

}