package textDictionary;

import java.util.Map;

public class Run {
    public static void main(String[] args) {
        CreateDictionary cd = new CreateDictionary("/home/gadd/example_text.txt");
        Map<String, Integer> dict = cd.getResult();
        for (Map.Entry<String, Integer> item : dict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
