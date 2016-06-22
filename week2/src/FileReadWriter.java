import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jeff on 6/22/16.
 */
public class FileReadWriter {

    public static void main(String[] args) throws IOException {
        File file = new File("names.txt");

        FileWriter fw = new FileWriter(file);
        fw.write("Nigel\n");
        fw.append("Val\n");
        fw.append("Eddy\n");
        fw.close();

        // read line by line
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

        // Read entire file
        scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();
        System.out.println(contents);


    }
}
