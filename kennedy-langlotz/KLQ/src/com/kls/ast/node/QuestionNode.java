package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.common.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class QuestionNode extends ASelectorNodeBase {
    private final String identifier;

    public QuestionNode(String identifier, List<DeclarationNode> declarations, Location location) {
        super(declarations, location);
        this.identifier = identifier;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public String getIdentifier() {
        return identifier;
    }
}
