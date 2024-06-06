package nrs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

import nrs.entities.Product;

public class App {
    private static final Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        products.add(new Product("product C", 400.0));
        products.add(new Product("product B", 1200.0));
        products.add(new Product("product A", 900.0));

        Comparator<Product> comparator = new Comparator<Product>(){ // anonymous class
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());                
            }
            
        };

        Comparator<Product> lambdaComparator = (p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase());
        
        products.sort((p1, p2) ->  p1.getName().toUpperCase().compareTo(p2.getName().toUpperCase()));
        // or
        products.sort(lambdaComparator);
        // or
        products.sort(comparator);
        // or
        products.sort(new MyComparator());

        for(Product p : products){
            log.info(p.toString());
        }
    }
}
