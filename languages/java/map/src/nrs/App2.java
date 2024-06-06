package nrs;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import nrs.entities.Product;

public class App2 {
    public static void main(String[] args) throws Exception {
        Map<Product, Double> products = new HashMap<>();
        
        Product p1 = new Product("Tv", 900.0);
        Product p2 = new Product("Notebook", 1200.0);
        Product p3 = new Product("Tablet", 400.0);

        products.put(p1, 10000.0);
        products.put(p2, 20000.0);
        products.put(p3, 15000.0);

        Product ps = new Product("Tv", 900.0);

        System.out.println("Contais 'ps' key:" + products.containsKey(ps));
    }
}
