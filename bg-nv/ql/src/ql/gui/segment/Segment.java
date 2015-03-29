package ql.gui.segment;

import javafx.scene.Node;
import ql.gui.GuiElement;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
//TODO: push down the subSegments
public abstract class Segment<T extends Node> extends GuiElement
{
    private final List<Segment> subSegments;
    protected T container;

    public Segment(T container, List<Segment> subSegments, Boolean visible)
    {
        super(visible);

        assert subSegments != null;
        assert container != null;

        this.container = container;
        this.subSegments = subSegments;
        this.setVisible(visible);
    }
    
    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.container.setVisible(visible);
        this.container.setManaged(visible);
    }

    public List<Segment> getSubSegments()
    {
        return this.subSegments;
    }

    public T getContainer()
    {
        return this.container;
    }

    public abstract <V> V accept (SegmentVisitor<V> visitor);
}
