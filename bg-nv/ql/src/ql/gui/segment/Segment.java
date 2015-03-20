package ql.gui.segment;

import javafx.scene.Node;
import ql.gui.GuiElement;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
//TODO: push down the subsegments
public abstract class Segment<T extends Node> extends GuiElement
{
    private final List<Segment> subsegments;
    protected T container;

    public Segment(T container, List<Segment> subsegments, Boolean visible)
    {
        super(visible);

        assert subsegments != null;
        assert container != null;

        this.container = container;
        this.subsegments = subsegments;
        this.setVisible(visible);
    }
    
    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.container.setVisible(visible);
        this.container.setManaged(visible);
    }

    public List<Segment> getSubsegments()
    {
        return this.subsegments;
    }

    public T getContainer()
    {
        return this.container;
    }

    public abstract <V> V accept (SegmentVisitor<V> visitor);
}
