import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
        
public class Exercice1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter with path of .csv file: ");
        String path = sc.nextLine();
        String newFileName = "summary.csv";

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            File file = new File(new File(path).getParent() + "/out");

            if(!file.exists()) file.mkdir();

            while(line != null){
                System.out.println(line);
                String[] lineProperties = line.split(",");

                Product product = new Product(lineProperties[0], Double.valueOf(lineProperties[1]), Integer.valueOf(lineProperties[2]));

                try(BufferedWriter bw = new BufferedWriter(new FileWriter(file.getPath()  + "/out" + newFileName, true))){

                    bw.write(product.getName() + "," + product.getPrice());
                    bw.newLine();
                }catch (IOException e){
                    e.printStackTrace();
                }

                line = br.readLine();
            }
            
            System.out.println("Program finished with success!");
        }catch (IOException e){
            e.printStackTrace();
        }

        sc.close();
    }
}