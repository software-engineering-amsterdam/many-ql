package parser

import spock.lang.Specification

/**
 * Created by Steven Kok on 17/02/2015.
 */
class ParseTreeWalkerTest extends Specification {

    def "Walker should throw exception when providing wrong path"() {
        when:
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker()
        parseTreeWalker.walk(path, new QLBaseVisitorImpl())

        then:
        thrown(thrownClass)

        where:
        path                    | thrownClass
        "src/main/antlr/input/" | IOException.class
        "QL_initial"            | IOException.class
        ""                      | IOException.class
        " "                     | IOException.class
    }

    def "Walker shouldn't throw exception when provided correct path"() {
        when:
        ParseTreeWalker parseTreeWalker = new ParseTreeWalker()
        parseTreeWalker.walk("src/main/antlr/input/QL_initial", new QLBaseVisitorImpl())

        then:
        noExceptionThrown()
    }
}
