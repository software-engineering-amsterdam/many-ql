package ql.gui.canvas;

/**
 * Created by Nik on 20-03-2015
 */
public interface CanvasVisitor<T>
{
    public T visit(Canvas c);
}
