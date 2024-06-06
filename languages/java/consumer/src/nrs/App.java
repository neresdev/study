package nrs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.logging.Logger;

import nrs.entities.CProduct;
import nrs.util.PriceUpdate;

public class App {
    private Logger log = Logger.getLogger(App.class.getName());
    public static void main(String[] args) throws Exception {
        List<CProduct> products = new ArrayList<>();

        products.add(new CProduct("TV", 900.0));
        products.add(new CProduct("Notebook", 1200.0));
        products.add(new CProduct("Tablet", 400.0));

        products.forEach(new PriceUpdate());
        // or
        products.forEach(CProduct::staticPriceUpdate);
        // or
        products.forEach(CProduct::nonStaticPriceUpdate);
        // or
        Consumer<CProduct> consumer = p -> p.setPrice(p.getPrice() * 1.1);
        products.forEach(consumer);
        // or
        products.forEach(p -> p.setPrice(p.getPrice() * 1.1));

        products.forEach(System.out::println);
    }
}
