package nrs.util;

import java.util.function.Predicate;

import nrs.entities.PredicateProduct;

public class ProductPredicate implements Predicate<PredicateProduct> {

    @Override
    public boolean test(PredicateProduct p) {
        return p.getPrice() >= 500.0;
    }

}
