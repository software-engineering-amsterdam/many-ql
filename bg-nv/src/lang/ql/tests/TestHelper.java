package lang.ql.tests;

import lang.ql.ast.AstNode;
import lang.ql.ast.expression.Expr;
import lang.ql.ast.expression.Not;
import lang.ql.ast.form.Form;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.TypeChecker;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.values.BooleanValue;
import lang.ql.semantics.values.Value;
import lang.ql.util.ParserHelper;
import lang.qls.ast.Stylesheet;

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
