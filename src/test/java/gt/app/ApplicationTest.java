package gt.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ApplicationTest {

    @Test
    void testLombokData() {
        //given
        var p = new PojoA("Bob", 2);


        //when:
        String fName = p.getFirstName();
        int age = p.getAge();

        //then:
        assertEquals("Bob", fName, "First Name set/get works");
        assertEquals(2, age, "Age set/get works");
    }


}


