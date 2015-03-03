package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public class Section extends Segment {

    private final List<Question> questions;

    public Section(String _name, List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles, List<Question> _questions) {
        super(_sections, _defaultStyles, _name);
        this.questions = _questions;
    }
}
