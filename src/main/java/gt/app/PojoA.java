package gt.app;

import jakarta.annotation.Nullable;
import lombok.Data;

@Data
public class PojoA {
    String firstName;
    int age;

    @Nullable
    String lastName;

    @Nullable
    String country;

    @Nullable
    String language;

    public PojoA(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
