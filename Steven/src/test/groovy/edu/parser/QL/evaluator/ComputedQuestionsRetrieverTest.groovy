package edu.parser.QL.evaluator

import edu.exceptions.TypeCheckException
import edu.gui.components.store.Store
import edu.parser.QL.nodes.expression.*
import edu.parser.QL.nodes.question.Question
import edu.parser.QL.nodes.type.Number
import edu.parser.QL.nodes.type.Text
import edu.parser.QuestionBuilder
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 12/03/2015.
 */
class ComputedQuestionsRetrieverTest extends Specification {

    ComputedQuestionsRetriever questionsRetriever

    def setup() {
        questionsRetriever = new ComputedQuestionsRetriever(new ArrayList<Question>())
    }

    def "Should return the label of the question the identifier points to"() {
        setup:
        def identifier = "identifier"
        Text inputText = new Text("input")
        questionsRetriever.evaluatedQuestions.add(new QuestionBuilder()
                .identifier(identifier)
                .store(inputText)
                .build())

        when:
        Store store = (Store) questionsRetriever.visit(new QLIdentifier(identifier))

        then:
        Assert.assertEquals(true, store instanceof Text)
        Text text = (Text) store
        Assert.assertEquals(true, inputText.equals(text))
    }

    def "should return number for expression"() {
        setup:
        Number leftNumber = (Number) expression.getLeft()
        Number rightNumber = (Number) expression.getRight()
        questionsRetriever.evaluatedQuestions.add(new QuestionBuilder()
                .store(leftNumber)
                .identifier("left")
                .build())
        questionsRetriever.evaluatedQuestions.add(new QuestionBuilder()
                .store(rightNumber)
                .identifier("right")
                .build())

        when:
        Store store = (Store) questionsRetriever.visit(expression)

        then:
        Assert.assertEquals(true, store instanceof Number)
        Number number = (Number) store
        Assert.assertEquals(result, number.number)

        where:
        expression                                       | result
        new Addition(new Number(4), new Number(6))       | 10
        new Multiplication(new Number(4), new Number(6)) | 24
        new Division(new Number(12), new Number(4))      | 3
        new Division(new Number(0), new Number(4))       | 4
        new Division(new Number(5), new Number(0))       | 5
        new Division(new Number(0), new Number(0))       | 0
    }

    def "should throw TypeCheckException for not supported operations"() {
        when:
        questionsRetriever.visit(expression)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true, exception.message.contains(ComputedQuestionsRetriever.NOT_SUPPORTED_OPERATION_FOR_COMPUTED_QUESTIONS))

        where:
        expression                                       | _
        new And(new Number(4), new Number(6))            | _
        new Or(new Number(4), new Number(6))             | _
        new Equal(new Number(4), new Number(6))          | _
        new NotEqual(new Number(4), new Number(6))       | _
        new Not(new QLIdentifier("identifier"))          | _
        new GreaterOrEqual(new Number(4), new Number(6)) | _
        new GreaterThan(new Number(4), new Number(6))    | _
        new LessOrEqual(new Number(4), new Number(6))    | _
        new LessThan(new Number(4), new Number(6))       | _
    }
}
