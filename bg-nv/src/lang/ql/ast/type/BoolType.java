package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class BoolType extends Type
{
    public BoolType()
    {
        super("boolean");
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
