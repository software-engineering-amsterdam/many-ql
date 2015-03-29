package ql.gui.segment;


import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
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
    private String fontName;
    private Integer fontSize;

    public RowStyle()
    {
        this.width = 400;
        this.foreColor = "black";
        this.backColor = "white";
        this.fontName = "Arial";
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

    public Paint getForeColor()
    {
        return Paint.valueOf(this.foreColor);
    }

    public void setForeColor(String foreColor)
    {
        this.foreColor = foreColor;
    }

    public Paint getBackColor()
    {
        return Paint.valueOf(this.backColor);
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

    public Font getFont()
    {
        return new Font(this.fontName, this.fontSize);
    }

    public void setFontName(String fontName)
    {
        this.fontName = fontName;
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
