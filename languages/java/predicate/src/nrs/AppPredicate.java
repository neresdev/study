package nrs;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import nrs.entities.PredicateProduct;
import nrs.util.ProductPredicate;

public class AppPredicate {
    public static void main(String[] args) throws Exception {
        List<PredicateProduct> products = new ArrayList<>();

        products.add(new PredicateProduct("TV", 900.0));
        products.add(new PredicateProduct("Notebook", 1200.0));
        products.add(new PredicateProduct("Tablet", 400.0));

        products.removeIf(new ProductPredicate());
        // or 
        products.removeIf(PredicateProduct::staticProductPredicate);
        // or
        products.removeIf(PredicateProduct::nonStaticProductPredicate);
        // or
        Predicate<PredicateProduct> pred = p -> p.getPrice() >= 100.0;
        products.removeIf(pred);
        // or
        products.removeIf(p -> p.getPrice() >= 100.0);

        for (PredicateProduct predicateProduct : products) {
            System.out.println(predicateProduct);
        }
    }
}
