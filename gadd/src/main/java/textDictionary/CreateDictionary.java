package textDictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class CreateDictionary {
    private String filePath;

    public CreateDictionary(String filePath) {
        this.filePath = filePath;
    }

    public HashMap getResult() {
        try {
            ArrayList wordsList = getWordsFromFile();
            HashSet wordsSet = convertToSet(wordsList);
            return countWords(wordsSet, wordsList);
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
        return null;
    }

    private ArrayList getWordsFromFile() throws IOException {
        ArrayList wordsArray = new ArrayList();
        FileReader fr = new FileReader(filePath);
        BufferedReader textReader = new BufferedReader(fr);
        String textLine;
        while ((textLine = textReader.readLine()) != null) { // to the end of file
            String[] wordsInLine = textLine.split(" "); // split string to words
            for (String i : wordsInLine) {
                if (i.length() > 0) {
                    String stripWord = strip(i);
                    if (stripWord.length() > 0) {
                        wordsArray.add(strip(i));
                    }
                }
            }
        }
        return wordsArray;
    }

    private String strip(String word) { // delete non-alphabetic characters from word
        StringBuilder wordSB = new StringBuilder(word);
        while (wordSB.length() > 0 && !Character.isAlphabetic(wordSB.charAt(0))) { // delete non-alphabetic characters from the beginning
            wordSB.deleteCharAt(0);
        }
        while (wordSB.length() > 0 && !Character.isAlphabetic(wordSB.charAt(wordSB.length() - 1))) { // delete non-alphabetic characters from the end
            wordSB.deleteCharAt(wordSB.length() - 1);
        }
        return wordSB.toString();

    }

    private HashSet convertToSet(ArrayList wordsArrayList) {
        HashSet wordsSet = new HashSet();
        for (int i = 0; i < wordsArrayList.size(); i++) {
            wordsSet.add(wordsArrayList.get(i));
        }
        return wordsSet;
    }

    private HashMap countWords(HashSet wordsSet, ArrayList wordsList) {
        HashMap result = new HashMap();
        Iterator it = wordsSet.iterator();
        while (it.hasNext()) {
            Object checkingWord = it.next();
            for (int i = 0; i < wordsList.size(); i++) {
                if (checkingWord.equals(wordsList.get(i))) {
//                    int count = result.getOrDefault(checkingWord, 0);
                    int count;
                    if (result.containsKey(checkingWord)) {
                        count = (int) result.get(checkingWord) + 1;
                    } else {
                        count = 1;
                    }
                    result.put(checkingWord, count);
                }
            }
        }
        return result;
    }
}
