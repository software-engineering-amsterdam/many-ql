package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.default_style.DefaultStyle;
import org.fugazi.qls.ast.question.Question;

import java.util.List;

public class Section extends Segment {
    
    private final List<Question> questions;
    
    public Section(String _name, List<Section> _sections, List<DefaultStyle> _defaultStyles, List<Question> _questions) {
        super(_name, _sections, _defaultStyles);
        this.questions = _questions;
    }
}
