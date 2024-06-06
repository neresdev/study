package app;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import entities.Product;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        
        LOGGER.info("Enter full file path: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
            String line = br.readLine();
            while(line != null){
                var lineSplit = line.split(",");
                var product = new Product(lineSplit[0], Double.parseDouble(lineSplit[1]));
                products.add(product);
                line = br.readLine();
            }

            Double averagePrice = products.stream()
                                .map(Product::getPrice)
                                .reduce(0.0, (x, y) -> x + y) / products.size();
            LOGGER.info("Average price: " + String.format("%.2f", averagePrice));
            
            Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

            var sortedNames = products.stream().filter(p -> p.getPrice() < averagePrice)
                                .map( Product::getName)
                                .sorted(comp.reversed());

            LOGGER.info("Sorted names: ");
            sortedNames.forEach(LOGGER::info);

        }catch (IOException e){
            e.printStackTrace();
        }
        int a = 0;
        sc.close();
        
    }
}
