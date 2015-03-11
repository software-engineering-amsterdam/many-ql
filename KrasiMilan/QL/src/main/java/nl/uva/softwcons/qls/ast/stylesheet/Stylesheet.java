package nl.uva.softwcons.qls.ast.stylesheet;

import java.util.List;

import nl.uva.softwcons.ql.ast.expression.identifier.Identifier;
import nl.uva.softwcons.qls.ast.ASTNode;
import nl.uva.softwcons.qls.ast.segment.Page;

public class Stylesheet implements ASTNode {
    private final Identifier id;
    private final List<Page> pages;

    public Stylesheet(final Identifier id, final List<Page> pages) {
        this.id = id;
        this.pages = pages;
    }

    public List<Page> getPages() {
        return this.pages;
    }

    public Identifier getId() {
        return id;
    }

}
