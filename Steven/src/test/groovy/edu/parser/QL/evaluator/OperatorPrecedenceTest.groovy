package edu.parser.QL.evaluator

import edu.Main
import edu.parser.AntlrParser
import edu.parser.QL.ParseTreeVisitor
import edu.parser.QL.QLAntlrParser
import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.expression.Addition
import edu.parser.QL.nodes.expression.Expression
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 13/03/2015.
 */
class OperatorPrecedenceTest extends Specification {

    public static final String INPUT_PATH = Main.PATH_TO_QL_INPUT_FILES
    AntlrParser antlrParser;
    ParseTreeVisitor parseTreeWalker;

    def setup() {
        antlrParser = new QLAntlrParser();
        parseTreeWalker = new ParseTreeVisitor();
    }

    def "should parse operator precedence correctly"() {
        setup:
        Form form = antlrParser.parse(INPUT_PATH + "QL_precedence", parseTreeWalker, Form.class)

        when:
        Expression firstExpression = (Expression) form.elements.get(0).expression;
        Expression secondExpression = (Expression) form.elements.get(1).expression;

        then:
        Assert.assertEquals(true, firstExpression.left instanceof Addition)
        Assert.assertEquals(1, firstExpression.left.left.number)
        Assert.assertEquals(3, firstExpression.left.right.left.number)
        Assert.assertEquals(5, firstExpression.left.right.right.number)
        Assert.assertEquals(true, firstExpression.right instanceof edu.parser.QL.nodes.type.Number)
        Assert.assertEquals(3, firstExpression.right.number)

        Assert.assertEquals(3, secondExpression.left.number)
        Assert.assertEquals(4, secondExpression.right.left.left.number)
        Assert.assertEquals(2, secondExpression.right.left.right.left.number)
        Assert.assertEquals(5, secondExpression.right.left.right.right.number)
        Assert.assertEquals(1, secondExpression.right.right.number)
    }
}
