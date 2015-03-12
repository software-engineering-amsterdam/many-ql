package edu.parser.QL.evaluator

import edu.gui.components.store.Store
import edu.parser.QL.nodes.expression.Expression
import edu.parser.QL.nodes.expression.QLIdentifier
import edu.parser.QL.nodes.question.Question
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

        def label = "label"
        questionsRetriever.evaluatedQuestions.add(new QuestionBuilder()
                .identifier(identifier)
                .label(label)
                .build())

        when:
        Store store = questionsRetriever.visit(new QLIdentifier(identifier))

        then:
        Assert.assertEquals(true, store instanceof Text)
        Text text = (Text) store
        Assert.assertEquals(true, text.getText().equals(label))
    }
}
