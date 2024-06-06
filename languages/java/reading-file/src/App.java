import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file path and file name: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        sc.close();
    }
}
