package edu.parser

import edu.nodes.styles.Style
import edu.parser.QLS.nodes.Identifier
import edu.parser.QLS.nodes.Stylesheet
import edu.parser.QLS.nodes.statement.Default
import edu.parser.QLS.nodes.statement.Page

/**
 * Created by Steven Kok on 11/03/2015.
 */
public class StylesheetBuilder {
    private Identifier title
    private List<Page> pages
    private List<Default> defaultStatements

    StylesheetBuilder() {
        this.pages = new ArrayList<>()
        this.defaultStatements = new ArrayList<>()
        title = new Identifier("title")
    }

    public Stylesheet build() {
        return new Stylesheet(title, pages, defaultStatements)
    }

    public StylesheetBuilder title(String title) {
        this.title = new Identifier(title)
    }

    public StylesheetBuilder addPage(Page page) {
        this.pages.add(page)
    }

    public StylesheetBuilder addDefault(Default aDefault) {
        this.defaultStatements.add(aDefault)
    }

}
