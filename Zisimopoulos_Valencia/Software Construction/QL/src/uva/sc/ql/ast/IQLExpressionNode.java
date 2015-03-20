package uva.sc.ql.ast;

import uva.sc.core.INode;

public interface IQLExpressionNode extends INode {

    public <T> T accept(IQLExpressionNodeVisitor<T> visitor);

}
