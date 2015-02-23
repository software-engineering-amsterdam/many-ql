package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class IntType extends Type
{
    public IntType()
    {
        super("integer");
    }

    @Override
    public void accept(TypeVisitor visitor)
    {
        visitor.visit(this);
    }
}
