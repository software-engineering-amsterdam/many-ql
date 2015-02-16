import spock.lang.Specification

/**
 * Created by Steven Kok on 3/02/2015.
 */
class WalkerTest extends Specification {

    def "Walker should read input file"() {
        setup:
        def walker = new Walker()
        walker.walk()

        expect:
        true
    }
}
