package com.klq.ast.impl.stmt;

import com.klq.ast.IStatementVisitor;
import com.klq.ast.impl.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by juriaan on 10-2-15.
 */
public class QuestionnaireNode extends AStatementNode {
    private List<AStatementNode> children;

    public QuestionnaireNode(Location location) {
        super(location);
        this.children = new ArrayList<>();
    }

    public QuestionnaireNode() {
        super();
        this.children = new ArrayList<>();
    }

    public List<AStatementNode> getChildren() {
        return children;
    }

    @Override
    public <T> T accept(IStatementVisitor<T> visitor) {
        return visitor.visit(this);
    }
}
