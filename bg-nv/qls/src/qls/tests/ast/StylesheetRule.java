package qls.tests.ast;

import ql.tests.TestHelper;
import qls.ast.rule.*;
import qls.ast.rule.widget.Textbox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 29/03/15.
 */
public class StylesheetRule
{
    @org.junit.Test
    public void width()
    {
        Width value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("width: 15"), Width.class);
        assertNotNull(value);
        assertEquals(Integer.valueOf(15), value.getValue());
    }

    @org.junit.Test
    public void font()
    {
        Font value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("font: \"Arial\""), Font.class);
        assertNotNull(value);
        assertEquals("Arial", value.getValue());
    }

    @org.junit.Test
    public void fontSize()
    {
        FontSize value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("fontsize: 25"), FontSize.class);
        assertNotNull(value);
        assertEquals(Integer.valueOf(25), value.getValue());
    }

    @org.junit.Test
    public void backColor()
    {
        BackColor value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("backcolor: #99FF55"), BackColor.class);
        assertNotNull(value);
        assertEquals("#99FF55", value.getValue().getColor());
    }

    @org.junit.Test
    public void foreColor()
    {
        ForeColor value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("forecolor: #99FF55"), ForeColor.class);
        assertNotNull(value);
        assertEquals("#99FF55", value.getValue().getColor());
    }

    @org.junit.Test
    public void widget()
    {
        Widget value = TestHelper.as(qls.util.ParserHelper.ParseStylesheetRule("widget textbox"), Widget.class);
        assertNotNull(value);
        TestHelper.assertChildType(value.getValue(), Textbox.class);
    }
}