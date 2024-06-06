package nrs;
import java.util.Arrays;

public class App {
    private static int globalValue = 3;

    public static void main(String[] args) throws Exception {
        int[] vect = new int[] { 3, 4, 5};
        changeOddValues(vect);
        System.out.println(Arrays.toString(vect));
    }

    public static void changeOddValues(int[] numbers){ // dont have reference transparency
        for (int i = 0; i < numbers.length; i++) {
            if(numbers[i] % 2 != 0){
                numbers[i] += globalValue;
            }
        }
    }
}
