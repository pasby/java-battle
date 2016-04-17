

public class User{

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "User{" +
                "Name='" + name + '\'' +
                ", Age=" + age +
                '}';
    }
}