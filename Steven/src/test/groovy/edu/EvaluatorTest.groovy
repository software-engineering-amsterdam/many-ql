package edu

import edu.parser.nodes.Form
import edu.parser.nodes.expression.Identifier
import edu.parser.nodes.question.Label
import edu.parser.nodes.question.Question
import edu.parser.nodes.question.QuestionType
import edu.parser.nodes.statement.Statement
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 23/02/2015.
 */
class EvaluatorTest extends Specification {

    Evaluator evaluator;
    Question question;

    def setup() {
        evaluator = new Evaluator();
    }

    def "Should return provided unconditional question"() {
        when:
        List<Statement> statements = new ArrayList<>();

        def identifier = new Identifier("identifier")
        def questionType = QuestionType.BOOLEAN
        def label = new Label("label")
        def expression = Optional.empty()
        statements.add(new Question(identifier, questionType, label, expression))

        Form inputForm = new Form(statements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question question = (Question) outputForm.elements.get(0);

        then:
        Assert.assertEquals(identifier, question.identifier)
        Assert.assertEquals(questionType, question.questionType)
        Assert.assertEquals(label, question.label)
        Assert.assertEquals(expression, question.expression)
    }


}
