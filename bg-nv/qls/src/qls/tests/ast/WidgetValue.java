package qls.tests.ast;

import ql.tests.TestHelper;
import qls.ast.rule.widget.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by bore on 29/03/15.
 */
public class WidgetValue
{
    @org.junit.Test
    public void checkbox()
    {
        Checkbox value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("checkbox"), Checkbox.class);
        assertNotNull(value);
    }

    @org.junit.Test
    public void textbox()
    {
        Textbox value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("textbox"), Textbox.class);
        assertNotNull(value);
    }

    @org.junit.Test
    public void intSlider()
    {
        IntSlider value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("slider (0, 100, 1)"), IntSlider.class);
        assertNotNull(value);
        assertEquals(Integer.valueOf(0), value.getMin());
        assertEquals(Integer.valueOf(100), value.getMax());
        assertEquals(Integer.valueOf(1), value.getStep());
    }

    @org.junit.Test
    public void decSlider()
    {
        DecSlider value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("slider (50.0, 100.0, 2.5)"), DecSlider.class);
        assertNotNull(value);
        assertEquals(new BigDecimal("50.0"), value.getMin());
        assertEquals(new BigDecimal("100.0"), value.getMax());
        assertEquals(new BigDecimal("2.5"), value.getStep());
    }

    @org.junit.Test
    public void dropdown()
    {
        Dropdown value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("dropdown (\"y\", \"n\")"), Dropdown.class);
        assertNotNull(value);
        assertEquals("y", value.getYesLabel());
        assertEquals("n", value.getNoLabel());
    }

    @org.junit.Test
    public void radio()
    {
        Radio value = TestHelper.as(qls.util.ParserHelper.ParseWidgetValue("radio (\"y\", \"n\")"), Radio.class);
        assertNotNull(value);
        assertEquals("y", value.getYesLabel());
        assertEquals("n", value.getNoLabel());
    }
}
