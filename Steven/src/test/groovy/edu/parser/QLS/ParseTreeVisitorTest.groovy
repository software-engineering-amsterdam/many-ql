package edu.parser.QLS

import edu.Main
import edu.parser.AntlrParser
import edu.parser.QLS.nodes.Stylesheet
import spock.lang.Specification

/**
 * Created by Steven Kok on 28/02/2015.
 */
class ParseTreeVisitorTest extends Specification {

    AntlrParser antlrParser;
    ParseTreeVisitor parseTreeVisitor;

    def setup() {
        antlrParser = new QLSAntlrParser();
        parseTreeVisitor = new ParseTreeVisitor();
    }

    def "smoke"() {
        when:
        Stylesheet stylesheet = antlrParser.parse(Main.PATH_TO_QLS_INPUT_FILES + "QLS_initial", parseTreeVisitor, Stylesheet.class)

        then:
        true
    }
}
