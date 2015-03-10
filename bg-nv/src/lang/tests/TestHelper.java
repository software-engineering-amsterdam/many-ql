package lang.tests;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.form.Form;
import lang.ql.semantics.ExprEvaluator;
import lang.ql.semantics.TypeChecker;
import lang.ql.semantics.ValueTable;
import lang.ql.semantics.errors.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.values.Value;
import lang.qls.ast.Stylesheet;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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

    public static List<Message> getStylesheet(String stylePath, String formPath)
    {
        Stylesheet s = TestHelper.as(ParserHelper.ParseStylesheet(stylePath), Stylesheet.class);
        Form f = TestHelper.as(ParserHelper.ParseForm(formPath), Form.class);

        return lang.qls.semantics.TypeChecker.check(s, f);
    }

    public static void assertTypeCheckErrorOccured()
    {

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
