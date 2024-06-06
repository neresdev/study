package nrs;

import java.util.ArrayList;
import java.util.List;

import nrs.entities.Product;

public class App {
 
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.0));
        products.add(new Product("Notebook", 1200.0));
        products.add(new Product("Tablet", 400.0));
        products.sort(new MyComparator());
        // ↓↓↓↓↓ will be
        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
    }
}
