package uva.sc.ql.ast;

import uva.sc.core.INode;

public interface IQLStatementNode extends INode {

    public <T> T accept(IQLStatementNodeVisitor<T> visitor);
}
