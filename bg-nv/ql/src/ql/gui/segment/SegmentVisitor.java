package ql.gui.segment;

/**
 * Created by Nik on 20-03-2015
 */
public interface SegmentVisitor<T>
{
    public T visit(Page page);
    public T visit(Row section);
    public T visit(Section section);
}
