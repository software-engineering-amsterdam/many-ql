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
    public void accept(TypeVisitor visitor)
    {
        visitor.visit(this);
    }
}
