package app;

import java.util.logging.Logger;

import service.NewYorkShipping;
import service.SaoPauloShipping;
import service.ShippingService;

public class App {

    private static Logger log = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        ShippingService shippingService = new ShippingService(new NewYorkShipping());
        log.info("Shipping from New York: " + shippingService.getShipping());

        shippingService = new ShippingService(new SaoPauloShipping());
        log.info("Shipping from São Paulo: " + shippingService.getShipping());
        
    }
}
