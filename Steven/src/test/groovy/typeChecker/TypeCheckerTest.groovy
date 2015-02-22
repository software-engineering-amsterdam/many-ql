package typeChecker

import parser.ParseTreeWalker
import parser.QLBaseVisitorImpl
import parser.nodes.Form
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class TypeCheckerTest extends Specification {

    ParseTreeWalker parseTreeWalker = new ParseTreeWalker();

    def "smoke"() {
        when:
        Form form = parseTreeWalker.walk("src/main/antlr/input/QL_initial", new QLBaseVisitorImpl())

        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        true
    }
}
