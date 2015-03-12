package org.fugazi.qls.ast.segment;

import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public class Page extends Segment {

    public Page(int _lineNum, 
                String _name, 
                List<Section> _sections, 
                List<DefaultStyleDeclaration> _defaultStyles) 
    {
        super(_lineNum, _sections, _defaultStyles, _name);
    }

    public Page(String _name, 
                List<Section> _sections, 
                List<DefaultStyleDeclaration> _defaultStyles) 
    {
        super(_sections, _defaultStyles, _name);
    }

    public <T> T accept(IQLSASTVisitor<T> _visitor) {
        return _visitor.visitPage(this);
    }
}
