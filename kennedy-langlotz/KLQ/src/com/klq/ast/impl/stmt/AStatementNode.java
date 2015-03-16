package com.klq.ast.impl.stmt;

import com.klq.ast.impl.ANode;
import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.Location;

/**
 * Created by juriaan on 16-3-15.
 */
public abstract class AStatementNode extends ANode {
    public AStatementNode(){
        super();
    }

    public AStatementNode(Location location){
        super(location);
    }

    public abstract <T> T  accept(IStatementVisitor<T> visitor);
}
