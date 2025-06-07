import entities.NumberControl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var numbers = List.of(11, 3, 4, 5, 8);
        System.out.println(haveSum(numbers, 11));
    }

    public static boolean haveSum(List<Integer> numbers, int sumNumber) {
        List<NumberControl> numberControls = new ArrayList<>();
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = 0; j < numbers.size(); j++) {
                if(j == i) continue;
                var sum = numbers.get(i) + numbers.get(j);
                numberControls.add(new NumberControl(numbers.get(i) + numbers.get(j), numbers.get(i), numbers.get(j)));
            }
        }
        return !numberControls.stream().filter(nc -> nc.getResult() == sumNumber).toList().isEmpty();
    }
}