package nrs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a file path and file name: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
            Map<String, Integer> candidates = new LinkedHashMap<>();

            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                String candidateName = fields[0];
                Integer votes = Integer.parseInt(fields[1]);
                if(candidates.containsKey(candidateName)){
                    Integer actualVotes = candidates.get(candidateName);
                    Integer totalVotes = actualVotes + votes;
                    candidates.put(candidateName, totalVotes);
                }else candidates.put(candidateName, votes); 
                line = br.readLine();
            }
            for(String key : candidates.keySet()){
                System.out.println(key + ": " + candidates.get(key)); 
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        sc.close();

    }
}
