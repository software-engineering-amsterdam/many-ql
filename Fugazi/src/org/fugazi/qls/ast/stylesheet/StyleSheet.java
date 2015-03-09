package org.fugazi.qls.ast.stylesheet;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.segment.Page;

import java.util.List;

public class StyleSheet extends AbstractASTQLSNode {
    
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

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitStyleSheet(this);
    }
}
