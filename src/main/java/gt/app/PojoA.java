package gt.app;

import lombok.Data;

@Data
public class PojoA {
    String firstName;
    String lastName;
    int age;
    String country;
    String language;

    public PojoA(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
