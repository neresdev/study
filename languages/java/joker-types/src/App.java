import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Object> myObjs = new ArrayList<>();
        List<Integer> myNumbers = new ArrayList<>();
        // myObjs = myNumbers; error!!
        Object obj;
        Integer x = 10;
        obj = x; // it works!

        List<? extends Integer> jokerList = myNumbers; // it works!!
        List<Integer> myInts = Arrays.asList(5, 2, 3);
        printList(myInts);
    
    }



    /*public static void main(String[] args) throws Exception {
       List<Integer> myInts = Arrays.asList(5, 2, 3);
       printList(myInts);
    }*/

    public static void printList(List<? extends Integer> list){
        for(Object obj : list){
            System.out.println(obj);
        }
    }
}
