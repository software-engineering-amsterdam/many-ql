package edu.parser.QL.typechecker

import edu.Main
import edu.exceptions.TypeCheckException
import edu.parser.AntlrParser
import edu.parser.QL.ParseTreeVisitor
import edu.parser.QL.QLAntlrParser
import edu.parser.QL.nodes.Form
import edu.parser.QL.typechecker.TypeChecker
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 21/02/2015.
 */
class TypeCheckerTest extends Specification {

    AntlrParser parseTreeWalker = new QLAntlrParser();
    public static final String INPUT_PATH = Main.PATH_TO_QL_INPUT_FILES

    def "Should throw exception with duplicate and unreferenced questions"() {
        when:
        Form form = parseTreeWalker.parse(input, new ParseTreeVisitor(), Form.class)
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        def exception = thrown(TypeCheckException)
        Assert.assertEquals(true, exception.message.contains(message))

        where:
        input                                                      | message
        INPUT_PATH + "question/QL_duplicateQuestions"              | TypeChecker.ALREADY_DECLARED_QUESTION.substring(0, 20)
        INPUT_PATH + "question/QL_duplicateQuestionsDifferentType" | TypeChecker.ALREADY_DECLARED_QUESTION_DIFFERENT_TYPE.substring(0, 20)
        INPUT_PATH + "question/QL_referenceToUndefinedQuestion"    | "name1"
    }

    def "Should throw exception with non-boolean conditions"() {
        when:
        Form form = parseTreeWalker.parse(input, new ParseTreeVisitor(), Form.class)
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        def exception = thrown(TypeCheckException)
        exception.message.contains(message)

        where:
        input                                                   | message
        INPUT_PATH + "logicalOperators/QL_invalidCondition_or"  | TypeChecker.EXPRESSION_EXPECTS_BOOLEAN.substring(0, 30)
        INPUT_PATH + "logicalOperators/QL_invalidCondition_and" | TypeChecker.EXPRESSION_EXPECTS_BOOLEAN.substring(0, 30)
        INPUT_PATH + "logicalOperators/QL_invalidCondition_not" | TypeChecker.EXPRESSION_EXPECTS_BOOLEAN.substring(0, 30)
    }

    def "Should throw exception with non-arithmetic operators"() {
        when:
        Form form = parseTreeWalker.parse(input, new ParseTreeVisitor(), Form.class)
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        def exception = thrown(TypeCheckException)
        exception.message.contains(message)

        where:
        input                                                             | message
        INPUT_PATH + "arithmeticOperators/QL_invalidOperator_GreaterThan" | TypeChecker.EXPRESSION_EXPECTS_NON_BOOLEAN.substring(0, 30)
    }

    def "Check valid grammars"() {
        when:
        Form form = parseTreeWalker.parse(input, new ParseTreeVisitor(), Form.class)
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        noExceptionThrown()

        where:
        input                                                | _
        INPUT_PATH + "arithmeticOperators/QL_validOperators" | _
        INPUT_PATH + "logicalOperators/QL_validConditions"   | _
    }

    def "Should throw exception when a question is used as a condition before it is declared"() {
        when:
        Form form = parseTreeWalker.parse(input, new ParseTreeVisitor(), Form.class)
        TypeChecker typeChecker = new TypeChecker();
        typeChecker.visit(form)

        then:
        def exception = thrown(TypeCheckException)
        exception.message.contains(message)

        where:
        input                                                  | message
        INPUT_PATH + "question/QL_cyclicQuestions"             | "name1"
        INPUT_PATH + "question/QL_cyclicQuestionAndIdentifier" | "name1"
    }

}
