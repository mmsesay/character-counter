import java.io.*;
import java.util.HashMap;

public class Main {

    public static void Counter(String fileContents) {

        // Creating an HashMap
        HashMap<Character, Integer> characterHashMap = new HashMap<Character, Integer>();

        char[] characters = fileContents.toCharArray();  // cast the file contents to an array of characters

        for (char character : characters) {
            if (characterHashMap.containsKey(character)) {
                // increment the character at index if it already exist by 1
                characterHashMap.put(character, characterHashMap.get(character)+1);
            } else {
                // add the new character with value 1
                characterHashMap.put(character, 1);
            }
        }

        System.out.print(characterHashMap);

    }

    public static void MyFileReader() {

        try {
            // setting up dynamic path
            File currentDir = new File (".");
            String basePath = currentDir.getCanonicalPath();

            InputStream iStream = new BufferedInputStream(
                    new FileInputStream(basePath + "/sample_file/sample.txt"));
            byte[] contents = new byte[1024];

            int bytesRead = 0;  // will hold the number of bytes read
            String fileContents = ""; // will hold the file contents that will be passed to the counter method

            // will return 0 when their are no more bytes
            while (iStream.available() > 0) {
                bytesRead = iStream.read(contents);  //
                fileContents += new String(contents, 0, bytesRead);  // casting the bytesRead to string
            }

            // referencing the Counter function and passing the fileContents as argument
            Counter(fileContents);

        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }

    public static void main(String[] args) {
        MyFileReader();
    }

}
