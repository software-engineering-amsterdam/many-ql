package lang.ql.ast;

import java.util.List;

/**
 * Created by bore on 09/02/15.
 */
public class AstNode
{

    public List<AstNode> children;

    public AstNode(List<AstNode> children)
    {
        this.children = children;
    }
}
