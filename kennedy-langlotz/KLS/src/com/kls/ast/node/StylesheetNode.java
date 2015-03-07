package com.kls.ast.node;

import com.kls.ast.IVisitor;
import com.kls.ast.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Timon on 03.03.2015.
 */
public class StylesheetNode extends ANodeBase {
    private final List<AGroupNodeBase> groups;
    private final List<ASelectorNodeBase> selectors;


    public StylesheetNode(Location location) {
        super(location);
        groups = new ArrayList<AGroupNodeBase>();
        selectors = new ArrayList<ASelectorNodeBase>();
    }

    @Override
    public <T> T accept(IVisitor<T> visitor) {
        return visitor.visit(this);
    }

    public List<AGroupNodeBase> getGroups() {
        return groups;
    }

    public List<ASelectorNodeBase> getSelectors() {
        return selectors;
    }
}
