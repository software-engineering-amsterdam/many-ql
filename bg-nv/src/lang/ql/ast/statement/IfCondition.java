package lang.ql.ast.statement;

import lang.ql.ast.AstNode;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class IfCondition extends Statement
{
    public IfCondition(List<AstNode> children)
    {
        super(children);
    }
}
