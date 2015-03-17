package ql.gui.segment;


import ql.gui.control.Control;

/**
 * Created by bore on 10/03/15.
 */
public class RowStyle
{
    private Integer width;
    private String foreColor;
    private String backColor;
    private Control widget;
    private String font;
    private Integer fontSize;

    public RowStyle()
    {
        this.foreColor = "black";
        this.backColor = "white";
        this.font = "Arial";
        this.fontSize = 12;
    }

    public Integer getWidth()
    {
        return width;
    }

    public void setWidth(Integer width)
    {
        this.width = width;
    }

    public String getForeColor()
    {
        return foreColor;
    }

    public void setForeColor(String foreColor)
    {
        this.foreColor = foreColor;
    }

    public String getBackColor()
    {
        return backColor;
    }

    public void setBackColor(String backColor)
    {
        this.backColor = backColor;
    }

    public Control getWidget()
    {
        return widget;
    }

    public void setWidget(Control widget)
    {
        this.widget = widget;
    }

    public String getFont()
    {
        return font;
    }

    public void setFont(String font)
    {
        this.font = font;
    }

    public Integer getFontSize()
    {
        return fontSize;
    }

    public void setFontSize(Integer fontSize)
    {
        this.fontSize = fontSize;
    }

    public Boolean isWidgetSet()
    {
        return this.widget != null;
    }
}
