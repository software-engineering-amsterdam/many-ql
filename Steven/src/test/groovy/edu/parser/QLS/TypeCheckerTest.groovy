package edu.parser.QLS

import edu.Main
import edu.Widgets
import edu.exceptions.TypeCheckException
import edu.nodes.QuestionType
import edu.nodes.styles.Style
import edu.nodes.styles.Widget
import edu.nodes.styles.Width
import edu.parser.AntlrParser
import edu.parser.QL.QLAntlrParser
import edu.parser.QL.QuestionRetriever
import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.expression.Identifier
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.QLSQuestion
import edu.parser.QuestionBuilder
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 01/03/2015.
 */
class TypeCheckerTest extends Specification {

    TypeChecker typeChecker
    AntlrParser qlParser
    AntlrParser qlsParser

    def setup() {
        typeChecker = new TypeChecker()
        qlParser = new QLAntlrParser()
        qlsParser = new QLSAntlrParser()
    }

    def "should throw exception when stylesheet question is not contained in form questions"() {
        setup:
        List<Question> questions = new ArrayList<>()
        questions.add(new QuestionBuilder().isEnabled(true).build())

        def identifier = "abcdefgh"
        typeChecker.stylesheetQuestions.add(new QLSQuestion(new edu.parser.QLS.nodes.Identifier(identifier), new ArrayList<Style>()))

        when:
        typeChecker.confirmQuestionsExistInForm(questions)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true, exception.message.contains(identifier))
    }

    def "should not throw exception when stylesheet question is contained in form questions"() {
        setup:
        List<Question> questions = new ArrayList<>()

        def identifier = "identifier"
        questions.add(new QuestionBuilder().isEnabled(true).identifier(identifier).build())

        typeChecker.stylesheetQuestions.add(new QLSQuestion(new edu.parser.QLS.nodes.Identifier(identifier), new ArrayList<Style>()))

        when:
        typeChecker.confirmQuestionsExistInForm(questions)

        then:
        noExceptionThrown()
    }

    def "Should throw typeCheckException when widget type is not compatible"() {
        setup:
        List<Question> questions = new ArrayList<>()
        questions.add(new QuestionBuilder().isEnabled(true).build())
        typeChecker.allQuestions.addAll(questions);

        def styles = new ArrayList<Style>()
        styles.add(new Widget(Widgets.TEXT))
        def stylesheetQuestion = new QLSQuestion(new edu.parser.QLS.nodes.Identifier("identifier"), styles)

        when:
        typeChecker.confirmQuestionHasCompatibleType(stylesheetQuestion)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true, exception.message.contains("Widget type is not compatible"))
    }

    def "Should not throw typeCheckException when widget type is compatible"() {
        setup:
        List<Question> questions = new ArrayList<>()
        questions.add(new QuestionBuilder().isEnabled(true).build())
        typeChecker.allQuestions.addAll(questions);

        def styles = new ArrayList<Style>()
        styles.add(new Width(40))
        styles.add(new Widget(Widgets.CHECKBOX))
        def stylesheetQuestion = new QLSQuestion(new edu.parser.QLS.nodes.Identifier("identifier"), styles)

        when:
        typeChecker.confirmQuestionHasCompatibleType(stylesheetQuestion)

        then:
        noExceptionThrown()
    }

    def "Should have collected all questions from QLS grammar"() {
        setup:
        Form form = qlParser.parse(Main.PATH_TO_QL_INPUT_FILES + "QL_valid", new edu.parser.QL.ParseTreeVisitor(), Form.class)
        Stylesheet stylesheet = qlsParser.parse(Main.PATH_TO_QLS_INPUT_FILES + "QLS_valid", new ParseTreeVisitor(), Stylesheet.class)
        QuestionRetriever questionRetriever = new QuestionRetriever()
        List<Question> questions = questionRetriever.retrieveQuestions(form)

        when:
        typeChecker.start(questions, stylesheet)

        then:
        Assert.assertEquals(3, typeChecker.stylesheetQuestions.size())
    }

    def "should throw exception for duplicate questions"() {
        setup:
        Form form = qlParser.parse(Main.PATH_TO_QL_INPUT_FILES + "QL_valid", new edu.parser.QL.ParseTreeVisitor(), Form.class)
        Stylesheet stylesheet = qlsParser.parse(Main.PATH_TO_QLS_INPUT_FILES + "QLS_duplicateQuestions", new ParseTreeVisitor(), Stylesheet.class)
        QuestionRetriever questionRetriever = new QuestionRetriever()
        List<Question> questions = questionRetriever.retrieveQuestions(form)

        when:
        typeChecker.start(questions, stylesheet)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true, exception.message.contains(TypeChecker.FOUND_DUPLICATE_QUESTIONS))
    }
}
