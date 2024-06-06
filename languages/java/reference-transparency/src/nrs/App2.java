package nrs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import nrs.entities.Product;

public class App2 {
    private static int globalValue = 3;

    private static int comparator(Product p1, Product p2){
        return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
    }
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        
        products.add(new Product("TV", 900.0));
        products.add(new Product("Notebook", 1200.0));
        products.add(new Product("Tablet", 400.0));

        products.sort((p1, p2) -> p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase())); // lambda
        products.sort(App2::comparator); // lambda reference
    }
}
