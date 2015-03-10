package org.fugazi.qls.ast.segment;

import org.fugazi.ql.ast.AbstractASTNode;
import org.fugazi.qls.ast.IQLSASTVisitor;
import org.fugazi.qls.ast.style.DefaultStyleDeclaration;

import java.util.List;

public abstract class Segment extends AbstractASTNode {
    protected final String name;
    protected final List<Section> sections;
    protected final List<DefaultStyleDeclaration> defaultStyleDeclarations;

    public Segment(int _lineNum, List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles, String _name) {
        super(_lineNum);
        this.sections = _sections;
        this.defaultStyleDeclarations = _defaultStyles;
        this.name = _name;
    }
    public Segment(List<Section> _sections, List<DefaultStyleDeclaration> _defaultStyles, String _name) {
        this.sections = _sections;
        this.defaultStyleDeclarations = _defaultStyles;
        this.name = _name;
    }

    public String getName() {
        return this.name;
    }

    public List<Section> getSections() {
        return this.sections;
    }

    public List<DefaultStyleDeclaration> getDefaultStyleDeclarations() {
        return this.defaultStyleDeclarations;
    }

    public void addDefaultStyleDeclaration(DefaultStyleDeclaration _defaultStyleDeclr) {
        this.defaultStyleDeclarations.add(_defaultStyleDeclr);
    }

    public abstract <T> T accept(IQLSASTVisitor<T> visitor);

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Segment)) {
            return false;
        }

        Segment other = (Segment) obj;

        return (this.getName().equals(other.getName()));
    }

    @Override
    public int hashCode() {
        return (this.getClass().toString().hashCode() * name.hashCode());
    }
}

