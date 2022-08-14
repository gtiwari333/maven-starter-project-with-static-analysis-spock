package gt.app;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PojoA {
    String firstName;
    String lastName;
    int age;
    String country;
    String language;
}
