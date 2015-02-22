package parser

import parser.nodes.Form
import spock.lang.Specification

/**
 * Created by Steven Kok on 17/02/2015.
 */
class ParseTreeWalkerTest extends Specification {
    public static final String PATH_TO_INPUT_FILE = "src/main/antlr/input/QL_initial"
    ParseTreeWalker parseTreeWalker

    def setup() {
        parseTreeWalker = new ParseTreeWalker()
    }

    def "Walker should throw exception when providing wrong path"() {
        when:
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
        parseTreeWalker.walk(PATH_TO_INPUT_FILE, new QLBaseVisitorImpl())

        then:
        noExceptionThrown()
    }

    def "Walker should return a populated list"() {
        when:
        Form form = parseTreeWalker.walk(PATH_TO_INPUT_FILE, new QLBaseVisitorImpl())

        then:
        !form.getElements().empty

    }
}
