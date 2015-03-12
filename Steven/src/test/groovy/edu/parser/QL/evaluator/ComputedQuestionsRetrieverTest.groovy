package edu.parser.QL.evaluator

import edu.gui.components.store.Store
import edu.parser.QL.nodes.expression.Addition
import edu.parser.QL.nodes.expression.QLIdentifier
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

    def "should return number for ADDITION expression"() {
        setup:
        Number leftNumber = new Number(left)
        Number rightNumber = new Number(right)
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
        left | right | expression                                 | result
        4    | 6     | new Addition(new Number(4), new Number(6)) | 10
    }
}
