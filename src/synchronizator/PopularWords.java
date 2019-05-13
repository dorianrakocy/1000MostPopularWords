package synchronizator;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class PopularWords {
    public static void main(String[] args) {
       
        BufferedReader reader = null;
        File file = new File("C:\\files");
        File[] list = file.listFiles();
        List<String> wordList = new ArrayList<String>();
        HashMap<String,Integer> unsortedWords = new HashMap<String,Integer>();
        try {
            reader = new BufferedReader(new FileReader(list[0].getPath()));
            String nextLine = null;
            int lines = 0;
            while ((nextLine = reader.readLine()) != null) {
               
                if(unsortedWords.get(nextLine)==null) {
                	unsortedWords.put(nextLine, 0);
                }
                unsortedWords.put(nextLine, unsortedWords.get(nextLine)+1);
                wordList.add(nextLine);
                lines++;
            }
            System.out.println("Ilość wierszy w pliku: " + lines);
            
            System.out.println("Ilość słów w liscie "+wordList.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        	System.out.println(unsortedWords.get("dog"));
        
        Map<String,Integer> sortedWords = unsortedWords.entrySet().stream().sorted(Map.Entry.comparingByValue((word1,word2)->word2.compareTo(word1))).limit(1000).collect(
        		Collectors.toMap(Entry::getKey, Entry::getValue, (entry1,entry2)->entry1,LinkedHashMap::new));
        System.out.println(sortedWords.size());
        for (Map.Entry<String, Integer> entry : sortedWords.entrySet()) {
            System.out.println(entry.getKey()+" : "+entry.getValue());
        }
    }
}