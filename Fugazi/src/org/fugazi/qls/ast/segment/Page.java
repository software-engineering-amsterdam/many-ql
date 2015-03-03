package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.style.DefaultStyle;

import java.util.List;

public class Page {

    protected final String name;
    protected final List<Section> sections;
    protected final List<DefaultStyle> defaultStyles;

    public Page(String _name, List<Section> _sections, List<DefaultStyle> _defaultStyles) {
        this.name = _name;
        this.sections = _sections;
        this.defaultStyles = _defaultStyles;
    }

    public String getName() {
        return this.name;
    }
}
