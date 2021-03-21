import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    // Creating an HashMap
    static Map<Character, Integer> characterHashMap = new TreeMap<Character, Integer>();

    public static void Counter(char character) {

        if (characterHashMap.containsKey(character)) {
            // increment the character at index if it already exist by 1
            characterHashMap.put(character, characterHashMap.get(character)+1);
        } else {
            // add the new character with value 1
            characterHashMap.put(character, 1);
        }
    }

    public static void MyFileReader() {

        try {
            // setting up dynamic path
            File currentDir = new File (".");
            String basePath = currentDir.getCanonicalPath();

            Reader reader = new FileReader(basePath + "/sample_file/sample.txt");

            char[] contents = new char[1024];
            int read = 0;  // will hold the number of bytes read

            // will return 0 when their are no more bytes
            while ((read = reader.read(contents)) != -1) {

                for(int i = 0; i < read; i++){

                    char c = contents[i];

                    // check for only uppercase and lower case alphabets
                    if((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {

                        // check for all uppercase and convert to lower case
                        if(c <= 90) {
                            c += 32;
                        }
                        Counter(c);  // reference the counter method
                    }
                }
            }

        } catch (FileNotFoundException e) {
            return;
        } catch (IOException e) {
            return;
        }
    }

    public static void main(String[] args) {
        MyFileReader();
        System.out.print(characterHashMap);
    }

}
