package picture.ths

import spock.lang.Specification

class PictureThisTest extends Specification {
    def "getInstance returns object"() {
        when:
        def result = PictureThis.getInstance()

        then:
        result
    }
}
