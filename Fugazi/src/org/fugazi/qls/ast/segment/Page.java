package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.default_style.DefaultStyle;

import java.util.List;

public class Page extends Segment {

    public Page(String _name, List<Section> _sections, List<DefaultStyle> _defaultStyles) {
        super(_name, _sections, _defaultStyles);
    }
}
