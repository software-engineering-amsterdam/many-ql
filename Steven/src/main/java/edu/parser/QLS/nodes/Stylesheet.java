package edu.parser.QLS.nodes;

import edu.parser.QLS.QLSVisitor;
import edu.parser.QLS.nodes.statement.Default;
import edu.parser.QLS.nodes.statement.Page;

import java.util.List;

/**
 * Created by Steven Kok on 28/02/2015.
 */
public class Stylesheet implements AbstractNode {
    private final List<Page> pages;
    private final Identifier title;
    private final List<Default> globalDefaultStatements;

    public Stylesheet(Identifier title, List<Page> pages, List<Default> globalDefaultStatements) {
        this.title = title;
        this.pages = pages;
        this.globalDefaultStatements = globalDefaultStatements;
    }

    public List<Page> getPages() {
        return pages;
    }

    public List<Default> getGlobalDefaultStatements() {
        return globalDefaultStatements;
    }

    public Identifier getTitle() {
        return title;
    }


    @Override
    public AbstractNode accept(QLSVisitor QLSVisitor) {
        return QLSVisitor.visit(this);
    }
}
