import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * Created by Оля on 18.04.2016.
 */
public class JsonSerializationService <T> {

    public String objectToJson(T obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public T objectFromJson(String json, Type type) {
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }
}
