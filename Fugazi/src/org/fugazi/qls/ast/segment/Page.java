package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.style.Style;

import java.util.List;

public class Page {

    protected final String name;
    protected final List<Section> sections;
    protected final List<Style> styles;

    public Page(String _name, List<Section> _sections, List<Style> _Styles) {
        this.name = _name;
        this.sections = _sections;
        this.styles = _Styles;
    }

    public String getName() {
        return this.name;
    }
}
