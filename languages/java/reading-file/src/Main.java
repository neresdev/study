import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
        
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] lines = new String[] {"linha 1", "linha 2", "linha 3", "linha 4"};

        System.out.println("Enter a new file path with name");
        String path = sc.nextLine();

//      try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ // for append file
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){ // for replace file
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}