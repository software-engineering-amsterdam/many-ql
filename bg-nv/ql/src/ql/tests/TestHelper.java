package ql.tests;

import ql.ast.AstNode;
import ql.ast.expression.Expr;
import ql.ast.form.Form;
import ql.semantics.ExprEvaluator;
import ql.semantics.TypeChecker;
import ql.semantics.ValueTable;
import ql.semantics.errors.*;
import ql.semantics.errors.Error;
import ql.semantics.values.Value;
import ql.util.ParserHelper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by bore on 17/02/15.
 */
public class TestHelper
{
    public static <T> T as(Object o, Class<T> t)
    {
        return t.isInstance(o) ? t.cast(o) : null;
    }

    public static Messages analyse(String formPath)
    {
        Form f = TestHelper.as(ParserHelper.ParseForm(formPath), Form.class);
        return TypeChecker.check(f);
    }

    public static <T> void assertChildType(AstNode child, Class<T> type)
    {
        assertTrue(type.isInstance(child));
    }

    public static void assertErrorMessage(Message m, String expected)
    {
        Error e = TestHelper.as(m, Error.class);
        assertNotNull(e);
        assertEquals(expected, e.getMessage());
    }

    public static Value evaluate(String expr, ValueTable valueTable)
    {
        Expr e = TestHelper.as(ParserHelper.ParseExpression(expr), Expr.class);
        assertNotNull(e);
        return ExprEvaluator.evaluate(e, valueTable);
    }
}
