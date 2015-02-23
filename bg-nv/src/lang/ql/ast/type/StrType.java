package lang.ql.ast.type;

/**
 * Created by bore on 17/02/15.
 */
public class StrType extends Type
{
    public StrType()
    {
        super("string");
    }

    @Override
    public void accept(TypeVisitor visitor)
    {
        visitor.visit(this);
    }
}
