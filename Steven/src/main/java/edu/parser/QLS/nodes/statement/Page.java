package edu.parser.QLS.nodes.statement;

import edu.parser.QLS.nodes.AbstractNode;
import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.Section;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Page extends Statement {

    private final List<Section> sections;

    public Page(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
