package ql.ast.type;

/**
 * Created by bore on 20/02/15.
 */
public class TypeFactory
{
    public static Type createType(String s)
    {
        if (s.equalsIgnoreCase("boolean"))
        {
            return new BoolType();
        }

        if (s.equalsIgnoreCase("integer"))
        {
            return new IntType();
        }

        if (s.equalsIgnoreCase("decimal"))
        {
            return new DecType();
        }

        if (s.equalsIgnoreCase("string"))
        {
            return new StrType();
        }

        if (s.equalsIgnoreCase("date"))
        {
            return new DateType();
        }

        throw new IllegalStateException("Type does not exist");
    }
}
