package lang.ql.gui.segment;

import javafx.scene.Node;
import lang.ql.gui.GuiElement;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class Segment<T extends Node> extends GuiElement
{
    private final List<Segment> subsegments;
    protected T container;

    public Segment(T container, List<Segment> subsegments, Boolean visible)
    {
        super(visible);
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
}
