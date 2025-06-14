import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
        
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);

        System.out.println("FOLDERS: ");

        for(File folder : folders){
            System.out.println(folder);
        }

        File[] files = path.listFiles(File::isFile);

        for (File file : files){
            System.out.println(file);
        }

        boolean success = new File(strPath + "/subdir").mkdir();

        System.out.println(success);

        sc.close();
    }
}