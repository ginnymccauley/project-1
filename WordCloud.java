import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class WordCloud
{
    private HashMap<String,Integer> group;

    /**
     * echo the given file
     * kind of boring
     * @param the scanner for the file
     **/
    public void readIt(Scanner infile)
    {
        group = new HashMap<String,Integer>();
        int count = 1;
        while (infile.hasNext())
        {
           String word = infile.next();
           if(group.containsKey(word)){
               count = count++;
               group.put(word,count);
               System.out.println("WORD: " + word);
            }else{
                group.put(word,count);
               System.out.println("WORD: " + word);
            }
        }
        
    }

    /**
    * BONUS: Writing to a file
    * @param outputFile is the file object for output
    * @param someWords is a list of words to print out
    **/
    public void writeIt(PrintWriter outputFile, ArrayList<String> someWords)
    {
        for (String word: someWords) 
        {
            outputFile.println(word);
        }
    }

    public static void main(String [] args)
    {
        if (args.length < 1) {
            System.out.println("Please give a file name, thanks.");
        }
        else {
            WordCloud mainObject = new WordCloud();
            File fileToRead = new File(args[0]);
            try {
                Scanner in = new Scanner(fileToRead);
                mainObject.readIt(in);
                /* Now demonstrate a PrintWriter for printing a file */
                PrintWriter outFile = new PrintWriter("words.txt");
                ArrayList<String> words = new ArrayList<String>();
                words.add("how");
                words.add("now");
                words.add("brown");
                words.add("cow");
                mainObject.writeIt(outFile,words);
                outFile.close();
            } catch(IOException e) {
                System.out.println("Uh oh, file error! "+ e);
            }
        }
    }
}