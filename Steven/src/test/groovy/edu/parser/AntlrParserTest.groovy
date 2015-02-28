package edu.parser

import edu.Main
import edu.parser.QL.ParseTreeWalker
import edu.parser.QL.nodes.Form
import spock.lang.Specification

/**
 * Created by Steven Kok on 17/02/2015.
 */
class AntlrParserTest extends Specification {
    public static final String PATH_TO_INPUT_FILE = Main.PATH_TO_INPUT_FILES
    AntlrParser parseTreeWalker

    def setup() {
        parseTreeWalker = new AntlrParser()
    }

    def "Walker should throw exception when providing wrong path"() {
        when:
        parseTreeWalker.walk(path, new ParseTreeWalker(), Form.class)

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
        parseTreeWalker.walk(PATH_TO_INPUT_FILE + "QL_initial", new ParseTreeWalker(), Form.class)

        then:
        noExceptionThrown()
    }

    def "Walker should return a populated list"() {
        when:
        Form form = parseTreeWalker.walk(PATH_TO_INPUT_FILE + "QL_initial", new ParseTreeWalker(), Form.class)

        then:
        !form.getElements().empty

    }
}
