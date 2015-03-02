package edu.parser.QL

import edu.Main
import edu.parser.AntlrParser
import edu.parser.QL.nodes.Form
import spock.lang.Specification

/**
 * Created by Steven Kok on 17/02/2015.
 */
class QLAntlrParserTest extends Specification {
    public static final String PATH_TO_INPUT_FILE = Main.PATH_TO_QL_INPUT_FILES
    AntlrParser parseTreeWalker

    def setup() {
        parseTreeWalker = new QLAntlrParser();
    }

    def "Walker should throw exception when providing wrong path"() {
        when:
        parseTreeWalker.parse(path, new ParseTreeVisitor(), Form.class)

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
        parseTreeWalker.parse(PATH_TO_INPUT_FILE + "QL_initial", new ParseTreeVisitor(), Form.class)

        then:
        noExceptionThrown()
    }

    def "Walker should return a populated list"() {
        when:
        Form form = parseTreeWalker.parse(PATH_TO_INPUT_FILE + "QL_initial", new ParseTreeVisitor(), Form.class)

        then:
        !form.getElements().empty

    }
}
