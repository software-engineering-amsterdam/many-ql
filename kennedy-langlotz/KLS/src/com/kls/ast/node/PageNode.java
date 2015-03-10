package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class PageNode extends AGroupNodeBase {
    private List<SectionNode> sections;

    public PageNode(String title, List<SectionNode> sections, List<QuestionNode> questions, DefaultNode def, Location location) {
        super(title, questions, def, location);
        this.sections = sections;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<SectionNode> getSections() {
        return sections;
    }
}
