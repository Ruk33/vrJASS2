package ruke.vrj;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String line = "";
    
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            if (!scanner.hasNextLine()) {
                continue;
            }
            
            line = scanner.nextLine();
    
            if (line.isEmpty()) {
                continue;
            }
            
            if ("exit".equals(line)) {
                break;
            }
            
            try {
                JsonObject value = Json.parse(line).asObject();
                System.out.println("Value: " + value.getString("name", "no-name"));
    
                System.out.println("Epa!, you just said " + line);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
