package lang.ql.semantics.values;

import lang.ql.ast.types.BoolType;
import lang.ql.ast.types.DecType;
import lang.ql.ast.types.IntType;
import lang.ql.ast.types.Type;

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

        return StringValue.getDefaultValue();
    }
}
