package ql.tests.ast;

import ql.util.ParserHelper;
import ql.tests.TestHelper;
import org.junit.Test;


import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 20/02/15.
 */
public class Form
{
    @Test
    public void formExample1() throws FileNotFoundException
    {
        ql.ast.form.Form f = TestHelper.as(ParserHelper.ParseForm("example1"), ql.ast.form.Form.class);
        assertNotNull(f);
        assertEquals("Box1HouseOwning", f.getId());
        assertEquals(4, f.getBody().size());
    }
}
