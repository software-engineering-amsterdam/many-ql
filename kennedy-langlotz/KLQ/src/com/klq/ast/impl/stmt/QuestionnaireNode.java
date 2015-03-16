package com.klq.ast.impl.stmt;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.Location;
import com.klq.ast.ANode;

import java.util.ArrayList;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionnaireNode extends AStatementNode {
    private ArrayList<AStatementNode> children;

    public QuestionnaireNode(Location location) {
        super(location);
        this.children = new ArrayList<AStatementNode>();
    }

    public QuestionnaireNode() {
        super();
        this.children = new ArrayList<AStatementNode>();
    }

    public ArrayList<AStatementNode> getChildren() {
        return children;
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
