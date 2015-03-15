package ql.ast.type;

/**
 * Created by Nik on 22-02-2015
 */
public class DateType extends Type
{
    @Override
    public String getTitle()
    {
        return "date";
    }

    @Override
    public <T> T accept(TypeVisitor<T> visitor)
    {
        return visitor.visit(this);
    }
}
