package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.AbstractASTQLSNode;
import org.fugazi.qls.ast.question.Question;

import java.util.List;

public class Section extends AbstractASTQLSNode {

    private final String name;
    private final List<Section> sections;
    private final List<Question> questions;
    
    public Section(String _name, List<Section> _sections, List<Question> _questions) {
        this.name = _name;
        this.sections = _sections;
        this.questions = _questions;
    }

    public String getName() {
        return this.name;
    }
}
