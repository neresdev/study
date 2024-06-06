import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        
        list.add("David");
        list.add("Neres");
        list.add("Fabiano");
        list.add("Paula");
        list.add("Souza");
        list.add("Cida");
        list.add("Paulo");
        list.add("Silva");
        list.add("Pedro");
        list.add(2, "Neres");
        list.add(3, "Souza");
        
        System.out.println(String.format("tamanho da lista: %d", list.size()));
        
        
        for(String item : list ) {
            System.out.println(item);
            System.out.println("********* next *********");
        }
        
        System.out.println("--------------------");
        
        list.removeIf(x -> x.charAt(0) == 'S');
        
        for(String item : list ) {
            System.out.println(item);
            System.out.println("********* next *********");
        }
        
        System.out.println("--------------------");
        System.out.println(String.format("Index of Neres: %d", list.indexOf("Neres")));
        
        System.out.println("------------------ apenas quem começa com 'P' ------------------");
        
        List<String> listaP = list.stream().filter( x -> x.charAt(0) == 'P' ).collect(Collectors.toList()); 
        //--> o método stream aceita funções do tipo lambda ( a partir do java 8 )
        for(String item : listaP ) {
            System.out.println(item);
            System.out.println("********* next *********");
        }
        
        System.out.println("------------- primeiro que começar com a letra 'P' -------------");
        String name = list.stream().filter(x -> x.charAt(0) == 'P').findFirst().orElse(null);
        System.out.println(name);
    }
}
