package parser

import junit.framework.Assert
import parser.nodes.Form
import parser.ast.nodes.expression.*
import parser.nodes.expression.And
import parser.nodes.expression.BinaryExpression
import parser.nodes.expression.GreaterThan
import parser.nodes.expression.Identifier
import parser.nodes.expression.Multiplication
import parser.nodes.expression.Not
import parser.nodes.statement.IfStatement
import parser.nodes.type.Boolean
import parser.nodes.type.Number
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
        IfStatement ifStatement = (IfStatement) form.elements.get(0)
        BinaryExpression expression = (BinaryExpression) ifStatement.expression

        then:
        Assert.assertEquals(And.class, expression.class)
        Assert.assertEquals(Identifier.class, expression.left.class)
        Assert.assertEquals(GreaterThan.class, expression.right.class)
        Assert.assertEquals(Multiplication.class, ((GreaterThan) expression.right).left.class)
        Assert.assertEquals(Number.class, ((GreaterThan) expression.right).right.class)
    }

    def "Boolean types should be identified"() {
        when:
        Form form = parseTreeWalker.walk("src/main/antlr/input/QL_boolean", baseVisitor)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)
        And and = (And) ifStatement.expression

        then:
        Assert.assertEquals(Boolean.class, and.left.class)
        Assert.assertEquals(true, ((Boolean) and.left).isTrue())

        Assert.assertEquals(Boolean.class, and.right.class)
        Assert.assertEquals(false, ((Boolean) and.right).isTrue())
    }

    def "Negation should be recognized on identifier"() {
        when:
        Form form = parseTreeWalker.walk("src/main/antlr/input/QL_negation", baseVisitor)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)

        then:
        Assert.assertEquals(And.class, ifStatement.expression.class)
        Assert.assertEquals(Not.class, ((And) ifStatement.expression).left.class)
    }
}
