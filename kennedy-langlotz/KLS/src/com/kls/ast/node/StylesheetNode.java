package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class StylesheetNode extends ANode {
    private final List<AGroupNode> groups;
    private final List<ASelectorNode> selectors;


    public StylesheetNode(Location location) {
        super(location);
        groups = new ArrayList<AGroupNode>();
        selectors = new ArrayList<ASelectorNode>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<AGroupNode> getGroups() {
        return groups;
    }

    public List<ASelectorNode> getSelectors() {
        return selectors;
    }
}
