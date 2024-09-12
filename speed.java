import java.io.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class speed {

    public static void main (String [] args){

        String command = "ping maynoothuniversity.ie";

        File outputFile = new File ("output.txt");
        
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("cmd.exe", "/c", command);

        try{
            Process process = processBuilder.start();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream())
            );
            
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line);
                writer.newLine();
            }

            reader.close();
            writer.close();

            int exitCode = process.waitFor();
            System.out.println("Exited with code: " + exitCode);


        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }



    }

    static class ReadFile{

        public static void main(String[] args) {
            
        
        try{
            File myObj = new File ("C://Users//Brooklyn//Documents//summer stuff//output");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
            
        } catch (FileNotFoundException e){
            System.out.println("Error has occured.");
        }
    }
    
}
}
