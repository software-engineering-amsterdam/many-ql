package com.kls.ast.node;

import com.klq.Type;
import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class DefaultNode extends ASelectorNodeBase {
    private final Type type;

    public DefaultNode(Type type, List<DeclarationNode> declarations, Location location) {
        super(declarations, location);
        this.type = type;
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public Type getType() {
        return type;
    }
}
