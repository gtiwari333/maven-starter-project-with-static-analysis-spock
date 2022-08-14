package gt.app


import spock.lang.Specification

class SpockExSpec extends Specification {

    def 'test1'() {
        given:
        var p = PojoA.builder()
            .firstName("Bob").age(2)
            .build()

        when:
        String fName = p.getFirstName()
        int age = p.getAge()

        then:
        "Bob" == fName
        2 == age
    }

    def "length of Spock's and his friends' names"() {
        expect:
        name.size() == length

        where:
        name     | length
        "Spock"  | 5
        "Kirk"   | 4
        "Scotty" | 6
    }
}
