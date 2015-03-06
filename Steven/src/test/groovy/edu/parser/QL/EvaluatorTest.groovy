package edu.parser.QL

import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.expression.*
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question
import edu.parser.QL.nodes.statement.ElseClause
import edu.parser.QL.nodes.statement.IfStatement
import edu.parser.QL.nodes.statement.Statement
import edu.parser.QL.nodes.type.Boolean
import edu.parser.QL.nodes.type.Number
import edu.parser.nodes.QuestionType
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

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)
        Question firstElement = returnedQuestions.get(0)

        then:
        Assert.assertEquals(inputQuestion, firstElement)
        Assert.assertEquals(1, returnedQuestions.size())

    }

    def "Should return question when if statements condition is true"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        Question inputConditionalQuestion = getQuestion("conditional")
        questionsWithinIfStatement.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questionsWithinIfStatement, Optional.empty())

        def inputUnconditionalQuestion = getQuestion("unconditional")
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals("List should contain only two elements", 2, returnedQuestions.size())
        Question outputUnconditionalQuestion = returnedQuestions.get(0);
        Question outputConditionalQuestion = returnedQuestions.get(1);
        Assert.assertEquals(inputUnconditionalQuestion, outputUnconditionalQuestion)
        Assert.assertEquals(inputConditionalQuestion, outputConditionalQuestion)

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
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        Question inputConditionalQuestion = getQuestion("conditional")
        questionsWithinIfStatement.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questionsWithinIfStatement, Optional.empty())

        def inputUnconditionalQuestion = getQuestion("unconditional")
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals(1, returnedQuestions.size())
        Question outputUnconditionalQuestion = returnedQuestions.get(0);
        Assert.assertEquals(inputUnconditionalQuestion, outputUnconditionalQuestion)

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

    def "Should return question from elseClause when condition is false"() {
        setup:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        Question inputConditionalQuestion = new Question(new Identifier("conditional"), QuestionType.BOOLEAN, new Label("conditional"), true, Optional.empty())
        questionsWithinIfStatement.add(inputConditionalQuestion)

        Question inputElseClauseQuestion = new Question(new Identifier("else"), QuestionType.BOOLEAN, new Label("else"), true, Optional.empty())
        List<Statement> elseClauseQuestions = new ArrayList<>();
        elseClauseQuestions.add(inputElseClauseQuestion)
        Optional<ElseClause> elseClause = Optional.of(new ElseClause(elseClauseQuestions))
        IfStatement ifStatement = new IfStatement(new Boolean(false), questionsWithinIfStatement, elseClause)

        def inputUnconditionalQuestion = new Question(new Identifier("unconditional"), QuestionType.BOOLEAN, new Label("unconditional"), true, Optional.empty())
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        when:
        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals(2, returnedQuestions.size())
        Question outputUnconditionalQuestion = (Question) returnedQuestions.get(0)
        Question outputElseClauseQuestion = (Question) returnedQuestions.get(1)
        Assert.assertEquals(inputUnconditionalQuestion, outputUnconditionalQuestion)
        Assert.assertEquals(inputElseClauseQuestion, outputElseClauseQuestion)
    }

    def "Should show question when if-statement evaluates to 'true' the second time"() {
        setup:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        def identifierUnconditionalQuestion = "identifierUnconditionalQuestion"
        questionsWithinIfStatement.add(createQuestion("conditionalQuestion", true))
        IfStatement ifStatement = new IfStatement(new Identifier(identifierUnconditionalQuestion), questionsWithinIfStatement, Optional.empty())

        formStatements.add(createQuestion(identifierUnconditionalQuestion, false))
        formStatements.add(ifStatement)
        def form = new Form(formStatements)

        when:
        List<Question> initialEvaluationReturnedQuestions = evaluator.evaluate(form)
        Assert.assertEquals(1, initialEvaluationReturnedQuestions.size())
        Question initialReturnedQuestion = initialEvaluationReturnedQuestions.get(0)
        Assert.assertEquals(identifierUnconditionalQuestion, initialReturnedQuestion.getIdentifier().identifier)

        then:
        List<Question> updatedQuestions = new ArrayList<>()
        updatedQuestions.add(createQuestion(identifierUnconditionalQuestion, true))
        List<Question> evaluationReturnedUpdatedQuestions = evaluator.evaluate(form, updatedQuestions)
        Assert.assertEquals(2, evaluationReturnedUpdatedQuestions.size())

        // disable question again
        List<Question> updatedQuestionsDisabled = new ArrayList<>()
        updatedQuestionsDisabled.add(createQuestion(identifierUnconditionalQuestion, false))
        List<Question> evaluationReturnedUpdatedQuestionsDisabled = evaluator.evaluate(form, updatedQuestions)
        Assert.assertEquals(1, evaluationReturnedUpdatedQuestionsDisabled.size())

    }

    private Question createQuestion(String identifier, boolean isEnabled) {
        return new Question(new Identifier(identifier), QuestionType.BOOLEAN, new Label("label"), isEnabled, Optional.empty())
    }
}
