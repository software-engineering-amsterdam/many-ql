package qls.tests;

import org.junit.Test;
import ql.ast.type.*;
import qls.ast.rule.*;
import qls.ast.rule.widget.*;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by bore on 29/03/15.
 */
public class Rule
{
    private static final BoolType boolType = new BoolType();
    private static final IntType intType = new IntType();
    private static final DecType decType = new DecType();
    private static final StrType strType = new StrType();

    private static final Width width100 = new Width(100, 0);
    private static final Width width50 = new Width(50, 0);
    private static final BackColor backColorBlue = new BackColor(new ColorValue("#0000FF"), 0);
    private static final BackColor backColorRed = new BackColor(new ColorValue("#FF0000"), 0);
    private static final ForeColor foreColorBlue = new ForeColor(new ColorValue("#0000FF"), 0);
    private static final ForeColor foreColorRed = new ForeColor(new ColorValue("#FF0000"), 0);
    private static final Font fontArial = new Font("Arial", 0);
    private static final Font fontComic = new Font("Comic Sans", 0);
    private static final FontSize fontSize10 = new FontSize(10, 0);
    private static final FontSize fontSize15 = new FontSize(15, 0);
    private static final Widget widgetRadio = new Widget(new Radio("y", "n"), 0);
    private static final Widget widgetTextbox = new Widget(new Textbox(), 0);

    @Test
    public void widthOverwrittenByWidth()
    {
        assertTrue(width100.isOverwrittenBy(width50));
    }

    @Test
    public void foreColorOverwrittenByForeColor()
    {
        assertTrue(foreColorBlue.isOverwrittenBy(foreColorRed));
    }

    @Test
    public void backColorOverwrittenByBackColor()
    {
        assertTrue(backColorBlue.isOverwrittenBy(backColorRed));
    }

    @Test
    public void fontOverwrittenByFont()
    {
        assertTrue(fontArial.isOverwrittenBy(fontComic));
    }

    @Test
    public void fontSizeOverwrittenByFontSize()
    {
        assertTrue(fontSize10.isOverwrittenBy(fontSize15));
    }

    @Test
    public void widgetOverwrittenByWidget()
    {
        assertTrue(widgetRadio.isOverwrittenBy(widgetTextbox));
    }

    @Test
    public void widgetNotOverwrittenByFont()
    {
        assertFalse(widgetRadio.isOverwrittenBy(fontArial));
    }

    @Test
    public void fontNotOverwrittenByFontSize()
    {
        assertFalse(fontArial.isOverwrittenBy(fontSize15));
    }

    @Test
    public void fontSizeNotOverwrittenByFont()
    {
        assertFalse(fontSize15.isOverwrittenBy(fontArial));
    }

    @Test
    public void backColorNotOverwrittenByForeColor()
    {
        assertFalse(backColorRed.isOverwrittenBy(foreColorBlue));
    }

    @Test
    public void foreColorNotOverwrittenByBackColor()
    {
        assertFalse(foreColorBlue.isOverwrittenBy(backColorRed));
    }

    @Test
    public void widgetNotOverwrittenByWidth()
    {
        assertFalse(widgetRadio.isOverwrittenBy(width100));
    }

    @Test
    public void widthNotOverwrittenByWidget()
    {
        assertFalse(width100.isOverwrittenBy(widgetRadio));
    }

    @Test
    public void isWidthCompatibleWithIntType()
    {
        assertTrue(width100.isCompatibleWithType(intType));
    }

    @Test
    public void isWidthCompatibleWithBoolType()
    {
        assertTrue(width100.isCompatibleWithType(boolType));
    }

    @Test
    public void isWidthCompatibleWithStrType()
    {
        assertTrue(width100.isCompatibleWithType(strType));
    }

    @Test
    public void isWidthCompatibleWithDecType()
    {
        assertTrue(width100.isCompatibleWithType(decType));
    }

    @Test
    public void isFontCompatibleWithIntType()
    {
        assertTrue(fontArial.isCompatibleWithType(intType));
    }

    @Test
    public void isFontCompatibleWithBoolType()
    {
        assertTrue(fontArial.isCompatibleWithType(boolType));
    }

    @Test
    public void isFontCompatibleWithStrType()
    {
        assertTrue(fontArial.isCompatibleWithType(strType));
    }

    @Test
    public void isFontCompatibleWithDecType()
    {
        assertTrue(fontArial.isCompatibleWithType(decType));
    }

    @Test
    public void isFontSizeCompatibleWithIntType()
    {
        assertTrue(fontSize10.isCompatibleWithType(intType));
    }

    @Test
    public void isFontSizeCompatibleWithBoolType()
    {
        assertTrue(fontSize10.isCompatibleWithType(boolType));
    }

    @Test
    public void isFontSizeCompatibleWithStrType()
    {
        assertTrue(fontSize10.isCompatibleWithType(strType));
    }

    @Test
    public void isFontSizeCompatibleWithDecType()
    {
        assertTrue(fontSize10.isCompatibleWithType(decType));
    }

    @Test
    public void isForeColorCompatibleWithIntType()
    {
        assertTrue(foreColorBlue.isCompatibleWithType(intType));
    }

    @Test
    public void isForeColorCompatibleWithBoolType()
    {
        assertTrue(foreColorBlue.isCompatibleWithType(boolType));
    }

    @Test
    public void isForeColorCompatibleWithStrType()
    {
        assertTrue(foreColorBlue.isCompatibleWithType(strType));
    }

    @Test
    public void isForeColorCompatibleWithDecType()
    {
        assertTrue(foreColorBlue.isCompatibleWithType(decType));
    }

    @Test
    public void isBackColorCompatibleWithIntType()
    {
        assertTrue(backColorBlue.isCompatibleWithType(intType));
    }

    @Test
    public void isBackColorCompatibleWithBoolType()
    {
        assertTrue(backColorBlue.isCompatibleWithType(boolType));
    }

    @Test
    public void isBackColorCompatibleWithStrType()
    {
        assertTrue(backColorBlue.isCompatibleWithType(strType));
    }

    @Test
    public void isBackColorCompatibleWithDecType()
    {
        assertTrue(backColorBlue.isCompatibleWithType(decType));
    }

    @Test
    public void isIntSliderCompatibleWithIntType()
    {
        Widget intSliderWidget = new Widget(new IntSlider(0, 100, 1), 0);
        assertTrue(intSliderWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isIntSliderCompatibleWithBoolType()
    {
        Widget intSliderWidget = new Widget(new IntSlider(0, 100, 1), 0);
        assertFalse(intSliderWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isIntSliderCompatibleWithStrType()
    {
        Widget intSliderWidget = new Widget(new IntSlider(0, 100, 1), 0);
        assertFalse(intSliderWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isIntSliderCompatibleWithDecType()
    {
        Widget intSliderWidget = new Widget(new IntSlider(0, 100, 1), 0);
        assertTrue(intSliderWidget.isCompatibleWithType(decType));
    }

    @Test
    public void isDecSliderCompatibleWithIntType()
    {
        Widget decSliderWidget = new Widget(new DecSlider(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE), 0);
        assertTrue(decSliderWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isDecSliderCompatibleWithBoolType()
    {
        Widget decSliderWidget = new Widget(new DecSlider(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE), 0);
        assertFalse(decSliderWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isDecSliderCompatibleWithStrType()
    {
        Widget decSliderWidget = new Widget(new DecSlider(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE), 0);
        assertFalse(decSliderWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isDecSliderCompatibleWithDecType()
    {
        Widget decSliderWidget = new Widget(new DecSlider(BigDecimal.ONE, BigDecimal.ONE, BigDecimal.ONE), 0);
        assertTrue(decSliderWidget.isCompatibleWithType(decType));
    }

    @Test
    public void isRadioCompatibleWithIntType()
    {
        Widget radioWidget = new Widget(new Radio("y", "n"), 0);
        assertFalse(radioWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isRadioCompatibleWithBoolType()
    {
        Widget radioWidget = new Widget(new Radio("y", "n"), 0);
        assertTrue(radioWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isRadioCompatibleWithStrType()
    {
        Widget radioWidget = new Widget(new Radio("y", "n"), 0);
        assertFalse(radioWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isRadioCompatibleWithDecType()
    {
        Widget radioWidget = new Widget(new Radio("y", "n"), 0);
        assertFalse(radioWidget.isCompatibleWithType(decType));
    }

    @Test
    public void isCheckboxCompatibleWithIntType()
    {
        Widget checkboxWidget = new Widget(new Checkbox(), 0);
        assertFalse(checkboxWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isCheckboxCompatibleWithBoolType()
    {
        Widget checkboxWidget = new Widget(new Checkbox(), 0);
        assertTrue(checkboxWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isCheckboxCompatibleWithStrType()
    {
        Widget checkboxWidget = new Widget(new Checkbox(), 0);
        assertFalse(checkboxWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isCheckboxCompatibleWithDecType()
    {
        Widget checkboxWidget = new Widget(new Checkbox(), 0);
        assertFalse(checkboxWidget.isCompatibleWithType(decType));
    }

    @Test
    public void isDropdownCompatibleWithIntType()
    {
        Widget dropdownWidget = new Widget(new Dropdown("y", "n"), 0);
        assertFalse(dropdownWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isDropdownCompatibleWithBoolType()
    {
        Widget dropdownWidget = new Widget(new Dropdown("y", "n"), 0);
        assertTrue(dropdownWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isDropdownCompatibleWithStrType()
    {
        Widget dropdownWidget = new Widget(new Dropdown("y", "n"), 0);
        assertFalse(dropdownWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isDropdownCompatibleWithDecType()
    {
        Widget dropdownWidget = new Widget(new Dropdown("y", "n"), 0);
        assertFalse(dropdownWidget.isCompatibleWithType(decType));
    }

    @Test
    public void isTextboxCompatibleWithIntType()
    {
        Widget textboxWidget = new Widget(new Textbox(), 0);
        assertTrue(textboxWidget.isCompatibleWithType(intType));
    }

    @Test
    public void isTextboxCompatibleWithBoolType()
    {
        Widget textboxWidget = new Widget(new Textbox(), 0);
        assertFalse(textboxWidget.isCompatibleWithType(boolType));
    }

    @Test
    public void isTextboxCompatibleWithStrType()
    {
        Widget textboxWidget = new Widget(new Textbox(), 0);
        assertTrue(textboxWidget.isCompatibleWithType(strType));
    }

    @Test
    public void isTextboxCompatibleWithDecType()
    {
        Widget textboxWidget = new Widget(new Textbox(), 0);
        assertTrue(textboxWidget.isCompatibleWithType(decType));
    }
}
