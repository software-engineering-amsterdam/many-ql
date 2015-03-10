package edu.parser.QL

import edu.nodes.QuestionType
import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.expression.*
import edu.parser.QL.nodes.question.Question
import edu.parser.QL.nodes.statement.ElseClause
import edu.parser.QL.nodes.statement.IfStatement
import edu.parser.QL.nodes.statement.Statement
import edu.parser.QL.nodes.type.Boolean
import edu.parser.QL.nodes.type.Number
import edu.parser.QuestionBuilder
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

//    Question getQuestion(String identifier) {
//        return new Question(new Identifier(identifier), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty(), Collections.emptyList());
//    }

    def "Should return provided unconditional question"() {
        when:
        List<Statement> statements = new ArrayList<>();

        Question inputQuestion = new QuestionBuilder().identifier("identifier").isEnabled(true).build()
        statements.add(inputQuestion)
        Form inputForm = new Form(statements);

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)
        Question firstElement = returnedQuestions.get(0)

        then:
        Assert.assertEquals(inputQuestion.identifier.identifier, firstElement.identifier.identifier)
        Assert.assertEquals(1, returnedQuestions.size())

    }

    def "Should return question when if statements condition is true"() {
        when:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        Question inputConditionalQuestion = new QuestionBuilder().identifier("conditional").isEnabled(true).build()
        questionsWithinIfStatement.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questionsWithinIfStatement, Optional.empty())

        def inputUnconditionalQuestion = new QuestionBuilder().identifier("unconditional").isEnabled(true).build()
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals("List should contain only two elements", 2, returnedQuestions.size())
        Question outputUnconditionalQuestion = returnedQuestions.get(0);
        Question outputConditionalQuestion = returnedQuestions.get(1);
        Assert.assertEquals(inputUnconditionalQuestion.identifier.identifier, outputUnconditionalQuestion.identifier.identifier)
        Assert.assertEquals(inputConditionalQuestion.identifier.identifier, outputConditionalQuestion.identifier.identifier)

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

        Question inputConditionalQuestion = new QuestionBuilder().identifier("conditional").isEnabled(true).build()
        questionsWithinIfStatement.add(inputConditionalQuestion)

        IfStatement ifStatement = new IfStatement(expression, questionsWithinIfStatement, Optional.empty())

        def inputUnconditionalQuestion = new QuestionBuilder().identifier("unconditional").isEnabled(true).build()
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals(1, returnedQuestions.size())
        Question outputUnconditionalQuestion = returnedQuestions.get(0);
        Assert.assertEquals(inputUnconditionalQuestion.identifier.identifier, outputUnconditionalQuestion.identifier.identifier)

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

        Question inputConditionalQuestion = new QuestionBuilder()
                .identifier("conditional")
                .questionType(QuestionType.BOOLEAN)
                .label("conditional")
                .isEnabled(true)
                .expression(Optional.empty())
                .styles(Collections.emptyList())
                .build()

        questionsWithinIfStatement.add(inputConditionalQuestion)

        Question inputElseClauseQuestion = new QuestionBuilder()
                .identifier("else")
                .questionType(QuestionType.BOOLEAN)
                .label("else")
                .isEnabled(true)
                .expression(Optional.empty())
                .styles(Collections.emptyList())
                .build()

        List<Statement> elseClauseQuestions = new ArrayList<>();
        elseClauseQuestions.add(inputElseClauseQuestion)
        Optional<ElseClause> elseClause = Optional.of(new ElseClause(elseClauseQuestions))
        IfStatement ifStatement = new IfStatement(new Boolean(false), questionsWithinIfStatement, elseClause)

        def inputUnconditionalQuestion = new QuestionBuilder()
                .identifier("unconditional")
                .questionType(QuestionType.BOOLEAN)
                .label("unconditional")
                .isEnabled(true)
                .expression(Optional.empty())
                .styles(Collections.emptyList())
                .build()
        formStatements.add(inputUnconditionalQuestion)
        formStatements.add(ifStatement)
        Form inputForm = new Form(formStatements);

        when:
        List<Question> returnedQuestions = evaluator.evaluate(inputForm)

        then:
        Assert.assertEquals(2, returnedQuestions.size())
        Question outputUnconditionalQuestion = returnedQuestions.get(0)
        Question outputElseClauseQuestion = returnedQuestions.get(1)
        Assert.assertEquals(inputUnconditionalQuestion.identifier.identifier, outputUnconditionalQuestion.identifier.identifier)
        Assert.assertEquals(inputElseClauseQuestion.identifier.identifier, outputElseClauseQuestion.identifier.identifier)
    }

    def "Should show question when if-statement evaluates to 'true' the second time"() {
        setup:
        List<Statement> formStatements = new ArrayList<>()
        List<Statement> questionsWithinIfStatement = new ArrayList<>()

        def identifierUnconditionalQuestion = "identifierUnconditionalQuestion"
        questionsWithinIfStatement.add(new QuestionBuilder().identifier("conditionalQuestion").isEnabled(true).build())
        IfStatement ifStatement = new IfStatement(new Identifier(identifierUnconditionalQuestion), questionsWithinIfStatement, Optional.empty())

        formStatements.add(new QuestionBuilder().identifier(identifierUnconditionalQuestion).isEnabled(false).build())
        formStatements.add(ifStatement)
        def form = new Form(formStatements)

        when:
        List<Question> initialEvaluationReturnedQuestions = evaluator.evaluate(form)
        Assert.assertEquals(1, initialEvaluationReturnedQuestions.size())
        Question initialReturnedQuestion = initialEvaluationReturnedQuestions.get(0)
        Assert.assertEquals(identifierUnconditionalQuestion, initialReturnedQuestion.getIdentifier().identifier)

        then:
        Set<Question> updatedQuestions = new ArrayList<>()
        updatedQuestions.add(new QuestionBuilder().identifier(identifierUnconditionalQuestion).isEnabled(true).build())
        List<Question> evaluationReturnedUpdatedQuestions = evaluator.evaluate(form, updatedQuestions)
        Assert.assertEquals(2, evaluationReturnedUpdatedQuestions.size())

        // disable question again
        Set<Question> updatedQuestionsDisabled = new ArrayList<>()
        updatedQuestionsDisabled.add(new QuestionBuilder().identifier(identifierUnconditionalQuestion).isEnabled(false).build())
        List<Question> evaluationReturnedUpdatedQuestionsDisabled = evaluator.evaluate(form, updatedQuestionsDisabled)
        Assert.assertEquals(1, evaluationReturnedUpdatedQuestionsDisabled.size())

    }
}
