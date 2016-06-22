import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jeff on 6/22/16.
 */
public class ReadWriteJson {
    public static void main(String[] args) throws IOException {
        Person sally = new Person("Sally", 20);

        File file = new File("person.json");

        //write json
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.serialize(sally);
        FileWriter fw = new FileWriter(file);
        fw.write(json);
        fw.close();

        // Read Json
        Scanner scanner = new Scanner(file);
        scanner.useDelimiter("\\Z");
        String contents = scanner.next();

        JsonParser parser = new JsonParser();
        Person p2 = parser.parse(contents, Person.class);

        System.out.println(p2);
    }

}
