package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class DecType extends Type
{
    public DecType()
    {
        super("decimal");
    }

    @Override
    public void accept(TypeVisitor visitor)
    {
        visitor.visit(this);
    }
}
