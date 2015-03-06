package edu.parser.QLS

import edu.Main
import edu.Widgets
import edu.parser.AntlrParser
import edu.parser.QLS.nodes.statement.Page
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.QLSQuestion
import edu.parser.nodes.styles.Widget
import edu.parser.nodes.styles.Width
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 28/02/2015.
 */
class ParseTreeVisitorTest extends Specification { //todo: create enum with paths to test files; do not call them directly

    AntlrParser antlrParser
    ParseTreeVisitor parseTreeVisitor

    def setup() {
        antlrParser = new QLSAntlrParser()
        parseTreeVisitor = new ParseTreeVisitor()
    }

    def "QLS_initial should be parsed correctly"() {
        setup:
        Stylesheet stylesheet = antlrParser.parse(Main.PATH_TO_QLS_INPUT_FILES + "QLS_initial", parseTreeVisitor, Stylesheet.class)

        when:
        def firstElement = stylesheet.statements.get(0)
        def secondElement = stylesheet.statements.get(1)
        def thirdElement = stylesheet.statements.get(2)
        def fourthElement = stylesheet.statements.get(3)

        then:
        Assert.assertEquals("first element should be firstElement name1", "name1", firstElement.identifier.identifier)
        Assert.assertEquals("second element should be a page", Page.class, secondElement.class)
        Assert.assertEquals("page should contain two sections", 2, secondElement.sections.size())
        Assert.assertEquals("first section should be called: 'section'", "section", secondElement.sections.get(0).title)
        Assert.assertEquals("second section should be called: 'another section'", "another section", secondElement.sections.get(1).title)
        Assert.assertEquals("first section contains one element", 1, secondElement.sections.get(0).statements.size())
        Assert.assertEquals("first section contains a question", QLSQuestion.class, secondElement.sections.get(0).statements.get(0).class)
        Assert.assertEquals("second section contains a question", QLSQuestion.class, secondElement.sections.get(1).statements.get(0).class)
        Assert.assertEquals("second section contains a question with a style width", Width.class, secondElement.sections.get(1).statements.get(0).styles.get(0).class)
        Assert.assertEquals("second section contains a question with a style width of 40", 40, secondElement.sections.get(1).statements.get(0).styles.get(0).width)
        Assert.assertEquals("third element is a page", Page.class, thirdElement.class)
        Assert.assertEquals("third element is an empty page", true, thirdElement.sections.isEmpty())
        Assert.assertEquals("fourth element is a question named name4", "name4", fourthElement.identifier.identifier)
        Assert.assertEquals("fourth element has a widget", Widget.class, fourthElement.styles.get(0).class)
        Assert.assertEquals("fourth element has a widget called SPINBOX", Widgets.SPINBOX, fourthElement.styles.get(0).widget)
        Assert.assertEquals("fourth element has a width", Width.class, fourthElement.styles.get(1).class)
        Assert.assertEquals("fourth element has a width of 500", 500, fourthElement.styles.get(1).width)
    }

}
