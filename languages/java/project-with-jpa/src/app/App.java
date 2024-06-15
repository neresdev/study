package app;

import domain.People;

public class App {
    public static void main(String[] args) throws Exception {
        People p1 = new People(1, "David Neres", "neresdev@gmail.com");
        People p2 = new People(2, "Neres", "devneres@gmail.com");
        People p3 = new People(3, "Neres David", "neresdesenvolvedor@gmail.com");

        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
}
