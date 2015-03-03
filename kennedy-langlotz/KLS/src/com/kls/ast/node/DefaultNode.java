package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class DefaultNode extends ASelectorNode {

    public DefaultNode(List<DeclarationNode> declarations, Location location) {
        super(declarations, location);
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
