import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class readFile {

    public static void main(String[] args) {
        StringBuilder data = new StringBuilder();
        
        try {
            File myObj = new File("");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data.append(myReader.nextLine()).append(" ");
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error has occurred.");
            e.printStackTrace();
        }
        
        // Convert StringBuilder to String
        String dataStr = data.toString();
        String[] words = dataStr.split("\\s+");
        String targetWord = "Average";
        String targt = "";
        
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(targetWord)) {
                // Ensure there is an element at i+2
                // remember its split into words, indexing i + 2 skips the average and gives me the ms time.
                if (i + 2 < words.length) {
                    targt = words[i + 2];
                }
                //end loop here
                break;
            }
        }
        
        int targtsearch = Character.getNumericValue(targt.charAt(0));
        double average = targtsearch;

      
// call a final method to calculate the average
      calculate(average);
    }
 
    public static void calculate(double ms){

        double rtt = ms / 2;
 
        double speedOfLight = 1.98e5; //kilometre per second-

        double solution = ((rtt/1000)  * speedOfLight);

        System.out.println("Between you and the host server there is approximately " + solution + "km worth of fibre cables");
    }
}

