import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;

public class App {
    /*public static void main(String[] args) throws Exception {
        List<Shape> myShapes = new ArrayList<>();
        myShapes.add(new Rectangle(3.0, 2.0));
        myShapes.add(new Circle(2.0));

        List<Circle> myCircles = new ArrayList<>();

        myCircles.add(new Circle(2.0));
        myCircles.add(new Circle(3.0));

        System.out.println("Total area: " + totalArea(myCircles));
    }*/

    public static double totalArea(List<? extends Shape> list){
        double sum = 0.0;
        for(Shape s : list) sum += s.area();
        return sum;
    }

    public static void main(String[] args) {

        // convariance
        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(5);

        List<? extends Number> list = intList; // List of type number or sub type (Integer, Double)

        Number x = list.get(0);

        // list.add(20); ERROR!

        // contravariance

        List<Object> myObjects = new ArrayList<>();
        myObjects.add("David");
        myObjects.add("Neres");

        List<? super Number> myNums = myObjects; // List of type number or Super type (Object)
        myNums.add(10);
        myNums.add(2.14);

        // Number x = myNums.get(0); ERROR!

        List<Integer> ints = Arrays.asList(1, 2, 3, 4);
        List<Double> doubles = Arrays.asList(3.14, 6.28);
        List<Object> objects = new ArrayList<>();

        copy(ints, objects);
        System.out.println(objects);
        
        copy(doubles, objects);
        System.out.println(objects);


    }

    public static void copy(List<? extends Number> source, List<? super Number> destiny){
        for(Number number : source) destiny.add(number);
    }

    public static void printList(List<?> list){
        for(Object obj : list){
            System.out.print(obj + " ");
        }
        System.out.println();
    }
    
}
