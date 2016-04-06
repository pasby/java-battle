package textDictionary;

import java.util.HashMap;
import java.util.Set;

public class Run {
    public static void main(String[] args) {
        CreateDictionary cd = new CreateDictionary("/home/gadd/example_text.txt");
        HashMap dict = cd.getResult();
        Set dictKeys = dict.keySet();
        for (Object key : dictKeys) {
            System.out.println(key + " " + dict.get(key));
        }
    }
}
