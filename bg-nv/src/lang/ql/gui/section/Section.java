package lang.ql.gui.section;

import javafx.scene.Node;
import lang.ql.gui.GuiElement;

import java.util.List;

/**
 * Created by Nik on 3-3-15.
 */
public abstract class Section<T extends Node> extends GuiElement
{
    private final T container;
    private final List<Section> subsections;

    public Section(T container, List<Section> subsections, Boolean visible)
    {
        super(visible);
        this.container = container;
        this.subsections = subsections;
    }

    @Override
    public void setVisible(Boolean visible)
    {
        super.setVisible(visible);
        this.container.setVisible(visible);
        this.container.setManaged(visible);
    }

    public List<Section> getSubsections()
    {
        return this.subsections;
    }

    public T getContainer()
    {
        return this.container;
    }
}
