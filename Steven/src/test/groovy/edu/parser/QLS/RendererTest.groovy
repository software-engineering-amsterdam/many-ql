package edu.parser.QLS

import edu.Main
import edu.exceptions.EvaluationException
import edu.gui.Renderer
import edu.nodes.QuestionType
import edu.parser.QL.nodes.expression.Identifier
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.QLSQuestion
import edu.parser.QLS.nodes.statement.Statement
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 06/03/2015.
 */
class RendererTest extends Specification {

    QLSVisitor evaluator

    def setup() {
        evaluator = new Renderer()
    }

    def "Should throw exception when not all questions are placed in stylesheet"() {
        setup:
        List<Statement> statements = new ArrayList<>()
        statements.add(createQLSQuestion("identifier"))
        Stylesheet stylesheet = new Stylesheet(new edu.parser.QLS.nodes.Identifier("title"), statements)

        List<Question> questions = new ArrayList<>()
        questions.add(createQuestion("iden1"))
        questions.add(createQuestion("iden2"))

        when:
        evaluator.confirmAllQuestionsAreInStylesheet(stylesheet, questions)

        then:
        def exception = thrown(EvaluationException.class)
        Assert.assertEquals(true, exception.message.contains(Renderer.NOT_FOUND_QUESTIONS))
    }

    private Question createQuestion(String identifier) {
        return new Question(new Identifier(identifier), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty())
    }

    private QLSQuestion createQLSQuestion(String identifier) {
        return new QLSQuestion(new edu.parser.QLS.nodes.Identifier(identifier), Collections.emptyList())
    }

}
