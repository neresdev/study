package nrs;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;


public class App {
    public static void main(String[] args) {
        Set<Integer> a = new TreeSet<>(Arrays.asList(0,2,4,5,6,8,10));
        Set<Integer> b = new TreeSet<>(Arrays.asList(1,5,6,7,8,9,10));    
        
        // union
        Set<Integer> c = new TreeSet<>(a);
        c.addAll(b);
        System.out.println(c);

        // intersection
        Set<Integer> d = new TreeSet<>(a);
        d.retainAll(b);
        System.out.println(d);

        // difference
        Set<Integer> e = new TreeSet<>(a);
        e.removeAll(b);
        System.out.println(e);
    }

    // public static void main(String[] args) throws Exception {
    //     Set<String> set = new TreeSet<>();
    //     set.add("TV");
    //     set.add("Tablet");
    //     set.add("Notebook");
        
    //     set.remove("Tablet");

    //     set.removeIf(x -> x.length() == 6);
    //     System.out.println(set.contains("Notebook"));

    //     for(String p : set){
    //         System.out.println(p);
    //     }

    // }
}
