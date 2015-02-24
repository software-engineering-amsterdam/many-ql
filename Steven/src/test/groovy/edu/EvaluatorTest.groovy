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

    def setup() {
        evaluator = new Evaluator();
    }

    Question getQuestion(String identifier) {
        return new Question(new Identifier(identifier), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty());
    }

    def "Should return provided unconditional question"() {
        when:
        List<Statement> statements = new ArrayList<>();

        Question inputQuestion = getQuestion("identifier")
        statements.add(inputQuestion)
        Form inputForm = new Form(statements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question returnQuestion = (Question) outputForm.elements.get(0);

        then:
        Assert.assertEquals(inputQuestion, returnQuestion)

    }

    def "Should return question when if statements condition is true"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()

        Question inputConditionalQuestion = getQuestion("conditional")
        questions.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questions, Optional.empty())

        def inputUnconditionalQuestion = getQuestion("unconditional")
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question outputQuestion1 = (Question) outputForm.elements.get(0);
        Question outputQuestion2 = (Question) outputForm.elements.get(1);

        then:
        Assert.assertEquals(inputUnconditionalQuestion, outputQuestion1)
        Assert.assertEquals(inputConditionalQuestion, outputQuestion2)

        where:
        expression                                                  | _
        new Boolean(true)                                           | _
        new And(new Boolean(true), new Boolean(true))               | _
        new And(new Identifier("unconditional"), new Boolean(true)) | _
    }

    def "Should not return question when if statements boolean condition is false"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()

        Question inputConditionalQuestion = getQuestion("conditional")
        questions.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questions, Optional.empty())

        def inputUnconditionalQuestion = getQuestion("unconditional")
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        Form outputForm = (Form) evaluator.visit(inputForm)
        Question outputQuestion1 = (Question) outputForm.elements.get(0);

        then:
        Assert.assertEquals(inputUnconditionalQuestion, outputQuestion1)
        Assert.assertEquals(1, outputForm.elements.size())

        where:
        expression                                                | _
        new Boolean(false)                                        | _
        new And(new Boolean(false), new Boolean(true))            | _
        new And(new Boolean(true), new Boolean(false))            | _
        new And(new Boolean(false), new Boolean(false))           | _
        new And(new Identifier("conditional"), new Boolean(true)) | _
    }


}
