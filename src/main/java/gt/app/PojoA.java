package gt.app;

import lombok.Data;

import javax.annotation.Nullable;

@Data
public class PojoA {
    @Nullable
    String firstName;
    @Nullable
    String lastName;
    int age;
    @Nullable
    String country;
    @Nullable
    String language;

    public PojoA(@Nullable String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }
}
