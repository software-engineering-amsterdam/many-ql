package ql.gui.label;

import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ql.gui.GuiElement;

/**
 * Created by Nik on 22-02-2015
 */
public class Label extends GuiElement
{

    private final Text textNode;

    public Label(String text)
    {
        this.textNode = new Text();
        this.textNode.setText(text);
    }

    public Text getTextNode()
    {
        return this.textNode;
    }

    public void applyColor(Paint color)
    {
        this.textNode.setFill(color);
    }

    public void applyFont(Font font)
    {
        this.textNode.setFont(font);
    }
}
