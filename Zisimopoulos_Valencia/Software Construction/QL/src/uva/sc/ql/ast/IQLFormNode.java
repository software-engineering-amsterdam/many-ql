package uva.sc.ql.ast;

import uva.sc.core.INode;

public interface IQLFormNode extends INode {

    public <T> T accept(IQLFormNodeVisitor<T> visitor);
}
