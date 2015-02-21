package parser

import junit.framework.Assert
import parser.ast.nodes.Form
import parser.ast.nodes.expression.And
import parser.ast.nodes.expression.BinaryExpression
import parser.ast.nodes.expression.Expression
import parser.ast.nodes.expression.GreaterThan
import parser.ast.nodes.expression.Identifier
import parser.ast.nodes.expression.Multiplication
import parser.ast.nodes.expression.Not
import parser.ast.nodes.statement.IfStatement
import parser.ast.nodes.type.Number
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
        Assert.assertEquals(parser.ast.nodes.type.Boolean.class, and.left.class)
        Assert.assertEquals(true, ((parser.ast.nodes.type.Boolean) and.left).isTrue())

        Assert.assertEquals(parser.ast.nodes.type.Boolean.class, and.right.class)
        Assert.assertEquals(false, ((parser.ast.nodes.type.Boolean) and.right).isTrue())
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
