package edu.parser

import edu.parser.QLS.nodes.Section
import edu.parser.QLS.nodes.statement.Page

/**
 * Created by Steven Kok on 11/03/2015.
 */
public class PageBuilder {
    private List<Section> sections

    PageBuilder() {
        this.sections = new ArrayList<>()
    }

    public Page build() {
        return new Page(sections)
    }

    public PageBuilder addSection(Section section) {
        this.sections.add(section)
    }
}
