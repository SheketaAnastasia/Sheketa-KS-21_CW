package com.my;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Клас у яком зберігаються методи для пошуку продуктів на різних сайтах
 * @author Sheketa
 */

public class SearchProduct {

    /**
     * Метод для пошуку на сайті MOYO
     * @author Sheketa
     * @param searchParam назва шукаємого продукта
     * @return List<Product> продукти які знайшли на сайті
     */

    public static List<Product> searchInMOYO(String searchParam) {
        try {
            List<Product> products = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.moyo.ua/search/new/?q=" + searchParam)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Elements listNews = doc.select("div.product-tile_inner_wrapper");
            for (Element element : listNews) {
                Product product = new Product();
                product.setName(element.select("a.gtm-link-product").text());
                product.setPrice(element.select("div.product-tile_price-current").select("span.product-tile_price-value").text());
                product.setUrl("https://www.moyo.ua"+element.select("a.gtm-link-product").attr("href"));
                products.add(product);
            }

            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * Метод для пошуку на сайті PN
     * @author Sheketa
     * @param searchParam назва шукаємого продукта
     * @return List<Product> продукти які знайшли на сайті
     */

    public static List<Product> searchInPn(String searchParam) {
        try {
            List<Product> products = new ArrayList<>();
            Document doc = Jsoup.connect("https://pn.com.ua/search/?fn="+searchParam)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Elements listNews = doc.select("div.catalog-block-text.td-block > div.catalog-product-head");
            for (Element element : listNews) {
                Product product = new Product();
                product.setName(element.select("div.catalog-block-head > a").text());
                product.setPrice(element.select("a.price > span > strong").text());
                product.setUrl("https://pn.com.ua"+element.select("div.catalog-block-head > a").attr("href"));
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * Метод для пошуку на сайті Foxtrot
     * @author Sheketa
     * @param searchParam назва шукаємого продукта
     * @return List<Product> продукти які знайшли на сайті
     */

    public static List<Product> searchInFoxtrot(String searchParam) {
        try {
            List<Product> products = new ArrayList<>();
            Document doc = Jsoup.connect("https://www.foxtrot.com.ua/ru/search?query="+searchParam)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Elements listNews = doc.select("div.card__body");
            for (Element element : listNews) {
                Product product = new Product();
                product.setName(element.select("a").attr("title"));
                product.setPrice(element.select("div.card-price").text());
                product.setUrl("https://www.foxtrot.com.ua"+element.select("a").attr("href"));
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    /**
     * Метод для пошуку на сайті Allo
     * @author Sheketa
     * @param searchParam назва шукаємого продукта
     * @return List<Product> продукти які знайшли на сайті
     */

    public static List<Product> searchInAllo(String searchParam) {
        try {
            List<Product> products = new ArrayList<>();
            Document doc = Jsoup.connect("https://allo.ua/ua/catalogsearch/result/?q="+searchParam)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
            Elements listNews = doc.select("div.product-card__content");
            for (Element element : listNews) {
                Product product = new Product();
                product.setName(element.select("a").attr("title"));
                product.setPrice(element.select("div.v-price-box__cur").text());
                product.setUrl(element.select("a").attr("href"));
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
