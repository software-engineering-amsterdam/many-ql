package lang.tests;

import lang.ql.ast.expression.Expr;
import lang.ql.ast.form.Form;
import lang.ql.semantics.EvalEnv;
import lang.ql.semantics.TypeChecker;
import lang.ql.semantics.errors.*;
import lang.ql.semantics.errors.Error;
import lang.ql.semantics.values.Value;

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

    public static List<Message> analyse(String formName)
    {
        Form f = TestHelper.as(ParserHelper.ParseForm(formName), Form.class);
        return TypeChecker.check(f);
    }

    public static void assertErrorMessage(Message m, String expected)
    {
        Error e = TestHelper.as(m, Error.class);
        assertNotNull(e);
        assertEquals(expected, e.getMessage());
    }

    public static Value evaluate(String expr, EvalEnv env)
    {
        Expr e = TestHelper.as(ParserHelper.ParseExpression(expr), Expr.class);
        assertNotNull(e);
        return lang.ql.semantics.Evaluator.evaluate(e, env);
    }
}
