import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCount {

    public static int countWords(String text) {
        
        String[] words = text.split("\\W+");

       
        int count = 0;

       
        for (String word : words) {
            count++;
        }

        
        return count;
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter a text or provide a file to count the words: ");
        String input = System.console().readLine();

        
        String text;
        if (input.startsWith("file://")) {
            FileReader fileReader = new FileReader(input.substring(7));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            text = "";
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                text += line + "\n";
            }

            bufferedReader.close();
        } else {
            text = input;
        }

        int wordCount = countWords(text);

        System.out.println("The total number of words in the text is: " + wordCount);
    }
}
