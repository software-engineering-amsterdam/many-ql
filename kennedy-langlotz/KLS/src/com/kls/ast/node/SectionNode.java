package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class SectionNode extends AGroupNodeBase {

    public SectionNode(String title, List<QuestionNode> questions, DefaultNode def, Location location) {
        super(title, questions, def, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
