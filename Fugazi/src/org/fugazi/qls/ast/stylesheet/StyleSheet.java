package org.fugazi.qls.ast.stylesheet;

import org.fugazi.qls.ast.AbstractASTNode;
import org.fugazi.qls.ast.segment.Page;

import java.util.List;

public class StyleSheet extends AbstractASTNode {
    
    private final String name;
    private final List<Page> pages;
    
    public StyleSheet(String _name, List<Page> _pages) {
        this.name = _name;
        this.pages = _pages;
    }

    public String getName() {
        return this.name;
    }
}
