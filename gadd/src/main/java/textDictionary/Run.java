package textDictionary;

import java.util.Map;

public class Run {
    public static void main(String[] args) {
        String path = args[0];
        CreateDictionary cd = new CreateDictionary(path);
        Map<String, Integer> dict = cd.getResult();
        for (Map.Entry<String, Integer> item : dict.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
