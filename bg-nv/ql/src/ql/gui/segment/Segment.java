package ql.gui.segment;

import javafx.scene.Node;
import ql.gui.GuiElement;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class Segment<T extends Node> extends GuiElement
{
    protected T container;

    public Segment(T container, Boolean visible)
    {
        super(visible);

        assert container != null;

        this.container = container;
        this.setVisible(visible);
    }
    
    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.container.setVisible(visible);
        this.container.setManaged(visible);
    }

    public T getContainer()
    {
        return this.container;
    }

    public abstract <V> V accept (SegmentVisitor<V> visitor);
}
