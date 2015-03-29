package qls.tests.ast;

import ql.tests.TestHelper;
import qls.util.ParserHelper;

import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 29/03/15.
 */
public class Stylesheet
{
    @org.junit.Test
    public void stylesheet()
    {
        qls.ast.Stylesheet sheet = TestHelper.as(ParserHelper.ParseStylesheet("styleInput"), qls.ast.Stylesheet.class);
        assertNotNull(sheet);
    }
}
