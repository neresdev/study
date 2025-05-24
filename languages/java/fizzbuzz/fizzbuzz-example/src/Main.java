import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            numbers.add(i);
        }
        numbers.forEach(number -> {
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.println("fizzbuzz");
            } else if(number % 3 == 0){
                System.out.println("fizz");
            } else if(number % 5 == 0){
                System.out.println("buzz");
            } else {
                System.out.println(number);
            }
        });
    }
}