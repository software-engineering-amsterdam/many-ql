package lang.qls.ast.Statement;

import lang.ql.ast.type.Type;
import lang.qls.ast.Rule.StylesheetRule;

import java.util.List;

/**
 * Created by bore on 02/03/15.
 */
public class DefaultStmt extends Statement
{
    private Type type;
    private List<StylesheetRule> body;

    public DefaultStmt(Type type, List<StylesheetRule> body, int lineNumber)
    {
        super(lineNumber);
        this.type = type;
        this.body = body;
    }

    public Type getType()
    {
        return this.type;
    }

    public List<StylesheetRule> getBody()
    {
        return this.body;
    }

    @Override
    public <T> T accept(StatementVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
