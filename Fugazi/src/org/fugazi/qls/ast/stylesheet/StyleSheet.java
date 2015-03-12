package org.fugazi.qls.ast.stylesheet;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.segment.Page;

import java.util.List;

public class StyleSheet extends AbstractASTNode {
    
    private final String name;
    private final List<Page> pages;

    public StyleSheet(int _lineNum, String _name, List<Page> _pages) {
        super(_lineNum);
        this.name = _name;
        this.pages = _pages;
    }

    public StyleSheet(String _name, List<Page> _pages) {
        this.name = _name;
        this.pages = _pages;
    }

    public String getName() {
        return this.name;
    }

    public List<Page> getPages() {
        return this.pages;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitStyleSheet(this);
    }
}
