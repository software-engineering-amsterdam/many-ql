package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class BoolType extends Type
{
    @Override
    public String getTitle()
    {
        return "boolean";
    }

    @Override
    public boolean isBool()
    {
        return true;
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
