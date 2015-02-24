package edu

import edu.parser.nodes.Form
import edu.parser.nodes.expression.Addition
import edu.parser.nodes.expression.And
import edu.parser.nodes.expression.Division
import edu.parser.nodes.expression.Equal
import edu.parser.nodes.expression.GreaterOrEqual
import edu.parser.nodes.expression.GreaterThan
import edu.parser.nodes.expression.Identifier
import edu.parser.nodes.expression.LessOrEqual
import edu.parser.nodes.expression.LessThan
import edu.parser.nodes.expression.Multiplication
import edu.parser.nodes.expression.Not
import edu.parser.nodes.expression.NotEqual
import edu.parser.nodes.expression.Or
import edu.parser.nodes.question.Label
import edu.parser.nodes.question.Question
import edu.parser.nodes.question.QuestionType
import edu.parser.nodes.statement.ElseClause
import edu.parser.nodes.statement.IfStatement
import edu.parser.nodes.statement.Statement
import edu.parser.nodes.type.Boolean
import edu.parser.nodes.type.Number
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

        then:
        Assert.assertEquals(2, outputForm.elements.size())
        Question outputQuestion1 = (Question) outputForm.elements.get(0);
        Question outputQuestion2 = (Question) outputForm.elements.get(1);
        Assert.assertEquals(inputUnconditionalQuestion, outputQuestion1)
        Assert.assertEquals(inputConditionalQuestion, outputQuestion2)

        where:
        expression                                                                 | _
        new Boolean(true)                                                          | _
        new And(new Boolean(true), new Boolean(true))                              | _
        new And(new Identifier("unconditional"), new Boolean(true))                | _
        new And(new And(new Boolean(true), new Boolean(true)), new Boolean(true))  | _
        new Or(new Boolean(true), new Boolean(true))                               | _
        new Or(new Boolean(true), new Boolean(false))                              | _
        new Or(new Boolean(false), new Boolean(true))                              | _
        new GreaterThan(new Addition(new Number(1), new Number(2)), new Number(1)) | _
        new GreaterOrEqual(new Number(2), new Number(1))                           | _
        new LessThan(new Number(1), new Number(2))                                 | _
        new LessOrEqual(new Number(1), new Number(1))                              | _
        new NotEqual(new Number(1), new Number(2))                                 | _
        new Equal(new Multiplication(new Number(3), new Number(2)), new Number(6)) | _
        new Equal(new Division(new Number(9), new Number(3)), new Number(3))       | _
        new Not(new Boolean(false))                                                | _

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

        then:
        Assert.assertEquals(1, outputForm.elements.size())
        Question outputQuestion1 = (Question) outputForm.elements.get(0);
        Assert.assertEquals(inputUnconditionalQuestion, outputQuestion1)

        where:
        expression                                                                 | _
        new Boolean(false)                                                         | _
        new And(new Boolean(false), new Boolean(true))                             | _
        new And(new Boolean(true), new Boolean(false))                             | _
        new And(new Boolean(false), new Boolean(false))                            | _
        new And(new Identifier("conditional"), new Boolean(true))                  | _
        new Or(new Boolean(false), new Boolean(false))                             | _
        new GreaterThan(new Addition(new Number(1), new Number(2)), new Number(4)) | _
        new GreaterOrEqual(new Number(2), new Number(3))                           | _
        new LessThan(new Number(2), new Number(1))                                 | _
        new LessOrEqual(new Number(2), new Number(1))                              | _
        new NotEqual(new Number(1), new Number(1))                                 | _
        new Equal(new Multiplication(new Number(3), new Number(2)), new Number(7)) | _
        new Equal(new Division(new Number(9), new Number(3)), new Number(4))       | _
        new Not(new Boolean(true))                                                 | _
        new Not(new Identifier("unconditional"))                                   | _
    }

    def "Should return disabled question when condition expects it so"() {
        setup:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()

        Question inputConditionalQuestion = new Question(new Identifier("conditional"), QuestionType.BOOLEAN, new Label("conditional"), true, Optional.empty())
        questions.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(new Not(new Identifier("unconditional")), questions, Optional.empty())

        def inputUnconditionalQuestion = new Question(new Identifier("unconditional"), QuestionType.BOOLEAN, new Label("unconditional"), false, Optional.empty())
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        when:
        Form outputForm = (Form) evaluator.visit(inputForm)

        then:
        Assert.assertEquals(1, outputForm.elements.size())
        Question outputConditionalQuestion = (Question) outputForm.elements.get(0)
        Assert.assertEquals(inputConditionalQuestion, outputConditionalQuestion)
    }


    def "Should return question from elseClause when condition is false"() {
        setup:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questions = new ArrayList<>()

        Question inputConditionalQuestion = new Question(new Identifier("conditional"), QuestionType.BOOLEAN, new Label("conditional"), true, Optional.empty())
        questions.add(inputConditionalQuestion)

        Question inputElseClauseQuestion = new Question(new Identifier("else"), QuestionType.BOOLEAN, new Label("else"), true, Optional.empty())
        List<Statement> elseClauseQuestions = new ArrayList<>();
        elseClauseQuestions.add(inputElseClauseQuestion)
        Optional<ElseClause> elseClause = Optional.of(new ElseClause(elseClauseQuestions))
        IfStatement ifStatement = new IfStatement(new Boolean(false), questions, elseClause)

        def inputUnconditionalQuestion = new Question(new Identifier("unconditional"), QuestionType.BOOLEAN, new Label("unconditional"), true, Optional.empty())
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);
        when:
        Form outputForm = (Form) evaluator.visit(inputForm)

        then:
        Assert.assertEquals(2, outputForm.elements.size())
        Question outputUnconditionalQuestion = (Question) outputForm.elements.get(0)
        Question outputElseClauseQuestion = (Question) outputForm.elements.get(1)
        Assert.assertEquals(inputUnconditionalQuestion, outputUnconditionalQuestion)
        Assert.assertEquals(inputElseClauseQuestion, outputElseClauseQuestion)
    }
}
