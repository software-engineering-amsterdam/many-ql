package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.question.QLSQuestion;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public class Section extends Segment {

    private final List<QLSQuestion> questions;

    public Section(int _lineNum, 
                   String _name, 
                   List<Section> _sections, 
                   List<DefaultStyleDeclaration> _defaultStyles, 
                   List<QLSQuestion> _questions)
    {
        super(_lineNum, _sections, _defaultStyles, _name);
        this.questions = _questions;
    }

    public Section(String _name, 
                   List<Section> _sections, 
                   List<DefaultStyleDeclaration> _defaultStyles, 
                   List<QLSQuestion> _questions)
    {
        super(_sections, _defaultStyles, _name);
        this.questions = _questions;
    }

    public List<QLSQuestion> getQuestions() {
        return this.questions;
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitSection(this);
    }
}
