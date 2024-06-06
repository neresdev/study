package nrs.entities;

public class CProduct{
    private String name;
    private Double price;
    
    public CProduct(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static void staticPriceUpdate(CProduct p){
        p.setPrice(p.getPrice() * 1.1);
    }

    public void nonStaticPriceUpdate(){
        price = price.getPrice() * 1.1;
    }

    public boolean nonStaticProductPredicate(){
        return price >= 500.0;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + "]";
    }


    
}
