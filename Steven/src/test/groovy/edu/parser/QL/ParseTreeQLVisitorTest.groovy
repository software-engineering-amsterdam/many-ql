package edu.parser.QL

import edu.Main
import edu.parser.AntlrParser
import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.expression.*
import edu.parser.QL.nodes.question.QLQuestion
import edu.parser.QL.nodes.statement.ElseClause
import edu.parser.QL.nodes.statement.IfStatement
import edu.parser.QL.nodes.type.Boolean
import edu.parser.QL.nodes.type.Number
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class ParseTreeQLVisitorTest extends Specification {

    public static final String INPUT_PATH = Main.PATH_TO_QL_INPUT_FILES
    AntlrParser antlrParser;
    ParseTreeVisitor parseTreeWalker;

    def setup() {
        antlrParser = new QLAntlrParser();
        parseTreeWalker = new ParseTreeVisitor();
    }

    def "Nested expression should be parsed correctly"() {
        when:
        Form form = antlrParser.parse(INPUT_PATH + "QL_nestedExpression", parseTreeWalker, Form.class)
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
        Form form = antlrParser.parse(INPUT_PATH + "QL_boolean", parseTreeWalker, Form.class)
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
        Form form = antlrParser.parse(INPUT_PATH + "QL_negation", parseTreeWalker, Form.class)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)

        then:
        Assert.assertEquals(And.class, ifStatement.expression.class)
        Assert.assertEquals(Not.class, ((And) ifStatement.expression).left.class)
    }

    def "Should recognise else clause in If statement"() {
        when:
        Form form = antlrParser.parse(INPUT_PATH + "QL_elseClause", parseTreeWalker, Form.class)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)

        then:
        Assert.assertEquals(true, ifStatement.elseClause.present)
        ElseClause elseClause = ifStatement.elseClause.get()
        QLQuestion question = (QLQuestion) elseClause.statements.get(0)
        Assert.assertEquals("name2", question.identifier.identifier);
    }
}
