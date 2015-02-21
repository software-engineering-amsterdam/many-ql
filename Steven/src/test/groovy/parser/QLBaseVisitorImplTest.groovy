package parser

import junit.framework.Assert
import parser.ast.nodes.Form
import parser.ast.nodes.expression.BinaryExpression
import parser.ast.nodes.expression.Identifier
import parser.ast.nodes.statement.IfStatement
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class QLBaseVisitorImplTest extends Specification {

    ParseTreeWalker parseTreeWalker;
    QLBaseVisitorImpl baseVisitor;

    def setup() {
        parseTreeWalker = new ParseTreeWalker();
        baseVisitor = new QLBaseVisitorImpl();
    }

    def "Nested expression should be parsed correctly"() {
        when:
        Form form = parseTreeWalker.walk("src/main/antlr/input/QL_nestedExpression", baseVisitor)
        IfStatement ifStatement = form.elements.get(0)
        BinaryExpression expression = ifStatement.expression

        then:
        Assert.assertEquals(Identifier.class, expression.left.class)
        Identifier identifier =  expression.left
        Assert.assertEquals("NAME1", identifier.getIdentifier())

        Assert.assertEquals(BinaryExpression.class, expression.right.class)

    }
}
