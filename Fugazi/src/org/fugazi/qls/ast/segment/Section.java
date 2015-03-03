package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.question.Question;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public class Section extends AbstractASTQLSNode {

    private final String name;
    private final List<Section> sections;
    private final List<Question> questions;
    private final List<DefaultStyleDeclaration> defaultStyles;


    public Section(String _name, List<Section> _sections, List<Question> _questions, List<DefaultStyleDeclaration> _defaultStyles) {
        this.name = _name;
        this.sections = _sections;
        this.questions = _questions;
        this.defaultStyles = _defaultStyles;
    }

    public String getName() {
        return this.name;
    }
}
