package ql.gui.label;

import javafx.scene.text.Text;
import ql.gui.GuiElement;
import ql.gui.ModelVisitor;

/**
 * Created by Nik on 22-02-2015
 */
public class Label extends GuiElement
{

    private final Text textNode;

    public Label(String text)
    {
        this(text, true);
    }

    public Label(String text, Boolean visible)
    {
        super(visible);
        this.textNode = new Text();
        this.textNode.setText(text);
    }

    public Text getTextNode()
    {
        return this.textNode;
    }

    public <V> V accept(LabelVisitor<V> visitor)
    {
        return visitor.visit(this);
    }
}
