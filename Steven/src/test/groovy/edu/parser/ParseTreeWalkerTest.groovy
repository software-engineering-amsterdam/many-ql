package edu.parser

import junit.framework.Assert
import edu.parser.nodes.Form
import edu.parser.ast.nodes.expression.*
import edu.parser.nodes.expression.And
import edu.parser.nodes.expression.BinaryExpression
import edu.parser.nodes.expression.GreaterThan
import edu.parser.nodes.expression.Identifier
import edu.parser.nodes.expression.Multiplication
import edu.parser.nodes.expression.Not
import edu.parser.nodes.question.Question
import edu.parser.nodes.statement.ElseClause
import edu.parser.nodes.statement.IfStatement
import edu.parser.nodes.type.Boolean
import edu.parser.nodes.type.Number
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class ParseTreeWalkerTest extends Specification {

    public static final String INPUT_PATH = AntlrParserTest.PATH_TO_INPUT_FILE
    AntlrParser antlrParser;
    ParseTreeWalker parseTreeWalker;

    def setup() {
        antlrParser = new AntlrParser();
        parseTreeWalker = new ParseTreeWalker();
    }

    def "Nested expression should be parsed correctly"() {
        when:
        Form form = antlrParser.walk(INPUT_PATH + "QL_nestedExpression", parseTreeWalker, Form.class)
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
        Form form = antlrParser.walk(INPUT_PATH + "QL_boolean", parseTreeWalker, Form.class)
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
        Form form = antlrParser.walk(INPUT_PATH + "QL_negation", parseTreeWalker, Form.class)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)

        then:
        Assert.assertEquals(And.class, ifStatement.expression.class)
        Assert.assertEquals(Not.class, ((And) ifStatement.expression).left.class)
    }

    def "Should recognise else clause in If statement"() {
        when:
        Form form = antlrParser.walk(INPUT_PATH + "QL_elseClause", parseTreeWalker, Form.class)
        IfStatement ifStatement = (IfStatement) form.elements.get(0)

        then:
        Assert.assertEquals(true, ifStatement.elseClause.present)
        ElseClause elseClause = ifStatement.elseClause.get()
        Question question = (Question) elseClause.statements.get(0)
        Assert.assertEquals("name2", question.identifier.identifier);
    }
}
