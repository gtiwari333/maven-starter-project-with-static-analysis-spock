package gt.app

import spock.lang.Specification

class MainSpec extends Specification {
    def "test main App"() {
        expect:
        Application.printPojo(new String[]{"Bob", "22"})
        Application.readGitProperties()
    }
}
