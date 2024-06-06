import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
        
public class InformationFromPath {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a file path");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName: " + path.getName()); // file name
        System.out.println("getParent: " + path.getParent()); // path name without file name
        System.out.println("getPath: " + path.getPath()); // full path name, with file name

        sc.close();
    }
}