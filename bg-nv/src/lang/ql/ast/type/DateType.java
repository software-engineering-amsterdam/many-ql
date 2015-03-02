package lang.ql.ast.type;

/**
 * Created by Nik on 22-02-2015
 */
public class DateType extends Type
{
    public DateType()
    {
        super("date");
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
