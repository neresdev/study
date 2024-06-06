package nrs;

import java.util.ArrayList;
import java.util.List;

import nrs.entities.Product;
import nrs.services.ProductService;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();
        products.add(new Product("TV", 900.0));
        products.add(new Product("Notebook", 1200.0));
        products.add(new Product("Tablet", 400.0));

        ProductService ps = new ProductService();

        double sum = ps.filteredSum(products, p -> p.getName().charAt(0) == 'T');

        System.out.println("Sum = " + String.format("%.2f", sum));
    }
}
