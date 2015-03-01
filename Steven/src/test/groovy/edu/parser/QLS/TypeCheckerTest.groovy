package edu.parser.QLS

import edu.exceptions.TypeCheckException
import edu.parser.QL.nodes.expression.Identifier
import edu.parser.QL.nodes.question.Label
import edu.parser.QL.nodes.question.Question
import edu.parser.QL.nodes.question.QuestionType
import edu.parser.QLS.nodes.styles.Style
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
}
