package lang.ql.semantics;

import lang.ql.ast.type.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by bore on 20/02/15.
 */
public class ExprTypeMap
{
    public static final Map<String, Set<Type>> exprAllowedTypes;
    public static final Map<String, Type> exprReturnType;

    private static final Type intType = new IntType();
    private static final Type strType = new StrType();
    private static final Type boolType = new BoolType();
    private static final Type decType = new DecType();

    static
    {
        exprAllowedTypes = new HashMap<String, Set<Type>>();
        Set<Type> arithmetic = makeSet(intType, decType);
        Set<Type> bool = makeSet(boolType);
        Set<Type> all = makeSet(intType, decType, boolType, strType);
        exprAllowedTypes.put("Add", makeSet(intType, decType, strType));
        exprAllowedTypes.put("Sub", arithmetic);
        exprAllowedTypes.put("Div", arithmetic);
        exprAllowedTypes.put("Mul", arithmetic);
        exprAllowedTypes.put("Pos", arithmetic);
        exprAllowedTypes.put("Neg", arithmetic);
        exprAllowedTypes.put("Not", bool);
        exprAllowedTypes.put("Gt", arithmetic);
        exprAllowedTypes.put("Lt", arithmetic);
        exprAllowedTypes.put("GtEqu", arithmetic);
        exprAllowedTypes.put("LtEqu", arithmetic);
        exprAllowedTypes.put("Equ", all);
        exprAllowedTypes.put("NotEqu", all);
        exprAllowedTypes.put("And", bool);
        exprAllowedTypes.put("Or", bool);

        exprReturnType = new HashMap<>();
        exprReturnType.put("Gt", boolType);
        exprReturnType.put("Lt", boolType);
        exprReturnType.put("GtEqu", boolType);
        exprReturnType.put("LtEqu", boolType);
        exprReturnType.put("Equ", boolType);
        exprReturnType.put("NotEqu", boolType);
    }

    private static Set<Type> makeSet(Type... types)
    {
        HashSet<Type> h = new HashSet<Type>();
        for (Type t : types)
        {
            h.add(t);
        }
        return h;
    }
}
