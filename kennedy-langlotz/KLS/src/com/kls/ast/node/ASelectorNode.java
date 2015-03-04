package com.kls.ast.node;

import com.kls.ast.Location;

import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public abstract class ASelectorNode extends ANode {
    private final List<DeclarationNode> declarations;

    public ASelectorNode(List<DeclarationNode> declarations, Location location) {
        super(location);
        this.declarations = declarations;
    }

    public List<DeclarationNode> getDeclarations() {
        return declarations;
    }
}
