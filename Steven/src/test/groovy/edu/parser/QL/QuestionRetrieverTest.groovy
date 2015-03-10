package edu.parser.QL

import edu.Main
import edu.parser.AntlrParser
import edu.parser.QL.nodes.Form
import edu.parser.QL.nodes.question.Question
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 06/03/2015.
 */
class QuestionRetrieverTest extends Specification {

    QuestionRetriever questionRetriever
    AntlrParser antlrParser

    def setup() {
        questionRetriever = new QuestionRetriever()
        antlrParser = new QLAntlrParser()
    }

    def "Should return all questions"() {
        when:
        Form form = antlrParser.parse(Main.PATH_TO_QL_INPUT_FILES + "QL_valid", new ParseTreeVisitor(), Form.class)
        List<Question> questions = questionRetriever.retrieveQuestions(form)

        then:
        Assert.assertEquals(4, questions.size())
    }
}
