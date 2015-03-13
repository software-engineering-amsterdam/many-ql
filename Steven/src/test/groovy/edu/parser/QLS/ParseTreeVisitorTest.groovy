package edu.parser.QLS

import edu.Main
import edu.nodes.styles.Color
import edu.nodes.styles.Font
import edu.nodes.styles.Widget
import edu.nodes.styles.Width
import edu.parser.AntlrParser
import edu.parser.QLS.nodes.Section
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.Default
import edu.parser.QLS.nodes.statement.Page
import junit.framework.Assert
import spock.lang.Specification

/**
 * Created by Steven Kok on 28/02/2015.
 */
class ParseTreeVisitorTest extends Specification {
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
        Assert.assertEquals(2, stylesheet.pages.size())
        def firstElement = stylesheet.pages.get(0)
        def secondElement = stylesheet.pages.get(1)
        Assert.assertEquals(1, stylesheet.globalDefaultStatements.size())
        def thirdElement = stylesheet.globalDefaultStatements.get(0)

        then:
        Assert.assertEquals("first element should be a Page", Page.class, firstElement.class)
        Assert.assertEquals("first element in Page should be a section", Section.class, firstElement.sections.get(0).class)
        Assert.assertEquals("first element in first section should be question name2", "name2", firstElement.sections.get(0).questions.get(0).QLSIdentifier.identifier)
        Assert.assertEquals("second element in Page should be a section", Section.class, firstElement.sections.get(1).class)
        Assert.assertEquals("first element in second section should be question name3", "name3", firstElement.sections.get(1).questions.get(0).QLSIdentifier.identifier)

        Assert.assertEquals("second element should be a Page", Page.class, secondElement.class)
        Assert.assertEquals("first element in Page should be a section", Section.class, secondElement.sections.get(0).class)
        Assert.assertEquals("first element in first section should be question name4", "name4", secondElement.sections.get(0).questions.get(0).QLSIdentifier.identifier)
        Assert.assertEquals("first style of name4 is a widget", Widget.class, secondElement.sections.get(0).questions.get(0).styles.get(0).class)
        Assert.assertEquals("first style of name4 is a widget named SPINBOX", "SPINBOX", secondElement.sections.get(0).questions.get(0).styles.get(0).widget.widget)
        Assert.assertEquals("second style of name4 is a Width ", Width.class, secondElement.sections.get(0).questions.get(0).styles.get(1).class)
        Assert.assertEquals("third style of name4 is a Font ", Font.class, secondElement.sections.get(0).questions.get(0).styles.get(2).class)
        Assert.assertEquals("fourth style of name4 is a Color ", Color.class, secondElement.sections.get(0).questions.get(0).styles.get(3).class)

        Assert.assertEquals("Third element is a default statement", Default.class, thirdElement.class)
        Assert.assertEquals("first style of third element is a Color", Color.class, thirdElement.styles.get(0).class)
    }

}
