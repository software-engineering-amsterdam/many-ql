package lang.ql.semantics.values;

import lang.ql.ast.type.BoolType;
import lang.ql.ast.type.DateType;
import lang.ql.ast.type.DecType;
import lang.ql.ast.type.IntType;
import lang.ql.ast.type.Type;

/**
 * Created by bore on 20/02/15.
 */
public class ValueFactory
{
    public static Value makeValue(Type t)
    {
        if (t instanceof IntType)
        {
            return IntegerValue.getDefaultValue();
        }

        if (t instanceof DecType)
        {
            return DecimalValue.getDefaultValue();
        }

        if (t instanceof BoolType)
        {
            return BooleanValue.getDefaultValue();
        }

        if (t instanceof DateType)
        {
            return DateValue.getDefaultValue();
        }

        return StringValue.getDefaultValue();
    }
}
