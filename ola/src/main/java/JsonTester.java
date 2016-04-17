
import com.google.gson.Gson;

public class JsonTester {
    public static void main(String args[]){
        Gson gson = new Gson();

        User user = new User();
        user.setName("Ola");
        user.setAge(20);
       
		String json = gson.toJson(user);
        System.out.println(json);
        User Usver = gson.fromJson(json, User.class);
		System.out.println(Usver.toString());
    }

  
}