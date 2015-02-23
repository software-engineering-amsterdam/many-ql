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
    public void accept(TypeVisitor visitor)
    {
        visitor.visit(this);
    }
}
