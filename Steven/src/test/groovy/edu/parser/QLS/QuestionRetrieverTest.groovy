package edu.parser.QLS

import edu.Main
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.QLSQuestion
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 06/03/2015.
 */
class QuestionRetrieverTest extends Specification {

    QuestionRetriever questionRetriever
    QLSAntlrParser antlrParser

    def setup() {
        questionRetriever = new QuestionRetriever()
        antlrParser = new QLSAntlrParser()
    }

    def "Should return all questions"() {
        setup:
        Stylesheet stylesheet = antlrParser.parse(Main.PATH_TO_QLS_INPUT_FILES + "QLS_questionRetriever", new ParseTreeVisitor(), Stylesheet.class)

        when:
        List<QLSQuestion> evaluatedQuestions = questionRetriever.retrieveQuestions(stylesheet)

        then:
        Assert.assertEquals(4, evaluatedQuestions.size())
    }


}
