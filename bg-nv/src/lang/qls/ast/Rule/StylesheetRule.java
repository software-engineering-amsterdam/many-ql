package lang.qls.ast.Rule;

import lang.ql.ast.AstNode;

/**
 * Created by bore on 02/03/15.
 */
public abstract class StylesheetRule extends AstNode
{
    public StylesheetRule(int lineNumber)
    {
        super(lineNumber);
    }

    public abstract <T> T accept(RuleVisitor<T> visitor);
}
