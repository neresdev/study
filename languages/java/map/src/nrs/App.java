package nrs;

import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        Map<String, String> cookies = new TreeMap<>();

        cookies.put("username", "Maria");
        cookies.put("email", "maria@gmail.com");
        cookies.put("phone", "40028922");

        cookies.remove("email");
        cookies.put("phone", "1232412");

        System.out.println("Contains 'phone' key: " + cookies.containsKey("phone"));
        System.out.println("Phone " + cookies.get("phone"));
        System.out.println("Email: " + cookies.get("email"));
        System.out.println("ALL COOKIES: ");
        for(String key : cookies.keySet()){
            System.out.println(key + ": " + cookies.get(key) );
        }
    }
}
