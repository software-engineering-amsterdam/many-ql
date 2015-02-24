package edu

import edu.parser.nodes.Form
import edu.parser.nodes.expression.And
import edu.parser.nodes.expression.Identifier
import edu.parser.nodes.question.Label
import edu.parser.nodes.question.Question
import edu.parser.nodes.question.QuestionType
import edu.parser.nodes.statement.IfStatement
import edu.parser.nodes.statement.Statement
import edu.parser.nodes.type.Boolean
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 23/02/2015.
 */
class EvaluatorTest extends Specification {

    Evaluator evaluator;
    Question question;
    Question enabledQuestion = new Question(new Identifier("identifier"), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty());

    def setup() {
        evaluator = new Evaluator();
    }

    def "Should return provided unconditional question"() {
        when:
        List<Statement> statements = new ArrayList<>();
        statements.add(enabledQuestion)
        Form inputForm = new Form(statements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question question = (Question) outputForm.elements.get(0);

        then:
        Assert.assertEquals(enabledQuestion, question)

    }

    def "Should return question when if statements condition is true"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()
        questions.add(enabledQuestion)

        IfStatement ifStatement = new IfStatement(expression, questions, Optional.empty())
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question question = (Question) outputForm.elements.get(0);

        then:
        Assert.assertEquals(enabledQuestion, question)

        where:
        expression                                    | _
        new Boolean(true)                             | _
        new And(new Boolean(true), new Boolean(true)) | _
    }

    def "Should not return question when if statements boolean condition is false"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()
        questions.add(enabledQuestion)

        IfStatement ifStatement = new IfStatement(expression, questions, Optional.empty())
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        Form outputForm = (Form) evaluator.visit(inputForm)

        then:
        Assert.assertEquals(true, outputForm.elements.isEmpty())

        where:
        expression                                      | _
        new Boolean(false)                              | _
        new And(new Boolean(false), new Boolean(true))  | _
        new And(new Boolean(true), new Boolean(false))  | _
        new And(new Boolean(false), new Boolean(false)) | _
    }


}
