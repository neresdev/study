package nrs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import nrs.entities.Product;
import nrs.util.UpperCaseName;

public class App {
    public static void main(String[] args) throws Exception {
        List<Product> products = new ArrayList<>();

        products.add(new Product("TV", 900.0));
        products.add(new Product("Notebook", 1200.0));
        products.add(new Product("Tablet", 400.0));
        
        Function<Product, String> func = new Function<Product,String>() {
            @Override
            public String apply(Product p) {
                return p.getName().toUpperCase();
            }
            
        };

        Function<Product, String> funcLambda = p ->  p.getName().toUpperCase();

        List<String> namesMapped1 = products.stream().map(new UpperCaseName()).collect(Collectors.toList());
        // or
        List<String> namesMapped2 = products.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());
        // or
        List<String> namesMapped3 = products.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());
        // or
        List<String> namesMapped4 = products.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
        // or
        List<String> namesMapped5 = products.stream().map(func).collect(Collectors.toList());
        // or
        List<String> namesMapped6 = products.stream().map(funcLambda).collect(Collectors.toList());
    }
}
