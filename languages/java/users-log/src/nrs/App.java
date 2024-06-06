package nrs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Logger;

import nrs.entities.Log;

public class App {
    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        LOGGER.info("Enter a file path and file name: ");
        String path = sc.nextLine();

        try(BufferedReader br = new BufferedReader(new FileReader(path)) ){
            
            Set<Log> logs = new HashSet<>();
            
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(" ");
                Log log = new Log(fields[0], Date.from(Instant.parse(fields[1])));
                logs.add(log);
                line = br.readLine();
            }
            LOGGER.info("Total users: " + logs.size());
        }catch (IOException e){
            e.printStackTrace();
        }

        
        sc.close();
    }
}
