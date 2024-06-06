package nrs.util;

import java.util.function.Consumer;

import nrs.entities.CProduct;

public class PriceUpdate implements Consumer<CProduct>{

    @Override
    public void accept(CProduct p) {
        p.setPrice(p.getPrice() * 1.1);
    }

}
