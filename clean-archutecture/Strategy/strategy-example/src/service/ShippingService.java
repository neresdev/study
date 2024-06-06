package service;

public class ShippingService {
    private Strategy strategy;

    public ShippingService(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getShipping(){
        return strategy.calculateShipping();
    }
    
}
