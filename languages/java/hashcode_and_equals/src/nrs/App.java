package nrs;

import nrs.entities.Client;

public class App {
    public static void main(String[] args){
        Client c1 = new Client("Neres", "neresdev@gmail.com");
        Client c2 = new Client("Neres", "neresdev@gmail.com");
        Client c3 = new Client("Neres", "davidneres5@gmail.com");

        String s1 = "Test";
        String s2 = "Test";

        String s3 = new String("Other test");
        String s4 = new String("Other test");

        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
        System.out.println(c1.equals(c2)); // true
        System.out.println(c1.equals(c3)); // false
        System.out.println(c1 == c2); // false

        System.out.println(s1 == s2); // true
        System.out.println(s3 == s4); // false
    }
}
