package edu.parser.QLS

import edu.Widgets
import edu.exceptions.TypeCheckException
import edu.parser.QL.nodes.expression.Identifier
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question
import edu.parser.QLS.nodes.styles.Style
import edu.parser.QLS.nodes.styles.Widget
import edu.parser.QLS.nodes.styles.Width
import edu.parser.nodes.QuestionType
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 01/03/2015.
 */
class TypeCheckerTest extends Specification {

    TypeChecker typeChecker

    def setup() {
        typeChecker = new TypeChecker()
    }

    def "should throw exception when stylesheet question is not contained in form questions"() {
        setup:
        List<Question> formQuestions = new ArrayList<>()
        formQuestions.add(new Question(new Identifier("identifier"), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty()))


        def identifier = "abcdefgh"
        typeChecker.stylesheetQuestions.add(new edu.parser.QLS.nodes.statement.Question(new edu.parser.QLS.nodes.Identifier(identifier), new ArrayList<Style>()))

        when:
        typeChecker.confirmQuestionsExistInForm(formQuestions)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true, exception.message.contains(identifier))
    }

    def "should not throw exception when stylesheet question is contained in form questions"() {
        setup:
        List<Question> formQuestions = new ArrayList<>()

        def identifier = "identifier"
        formQuestions.add(new Question(new Identifier(identifier), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty()))

        typeChecker.stylesheetQuestions.add(new edu.parser.QLS.nodes.statement.Question(new edu.parser.QLS.nodes.Identifier(identifier), new ArrayList<Style>()))

        when:
        typeChecker.confirmQuestionsExistInForm(formQuestions)

        then:
        noExceptionThrown()
    }

    def "Should throw typeCheckException when widget type is not compatible"() {
        setup:
        List<Question> formQuestions = new ArrayList<>()
        formQuestions.add(new Question(new Identifier("identifier"), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty()))
        typeChecker.formQuestions.addAll(formQuestions);

        def styles = new ArrayList<Style>()
        styles.add(new Widget(Widgets.TEXT))
        def stylesheetQuestion = new edu.parser.QLS.nodes.statement.Question(new edu.parser.QLS.nodes.Identifier("identifier"), styles)

        when:
        typeChecker.confirmQuestionHasCompatibleType(stylesheetQuestion)

        then:
        def exception = thrown(TypeCheckException.class)
        Assert.assertEquals(true,exception.message.contains("Widget type is not compatible"))
    }

    def "Should not throw typeCheckException when widget type is compatible"() {
        setup:
        List<Question> formQuestions = new ArrayList<>()
        formQuestions.add(new Question(new Identifier("identifier"), QuestionType.BOOLEAN, new Label("label"), true, Optional.empty()))
        typeChecker.formQuestions.addAll(formQuestions);

        def styles = new ArrayList<Style>()
        styles.add(new Width(40))
        styles.add(new Widget(Widgets.CHECKBOX))
        def stylesheetQuestion = new edu.parser.QLS.nodes.statement.Question(new edu.parser.QLS.nodes.Identifier("identifier"), styles)

        when:
        typeChecker.confirmQuestionHasCompatibleType(stylesheetQuestion)

        then:
        noExceptionThrown()
    }
}
