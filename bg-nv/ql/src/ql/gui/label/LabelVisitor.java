package ql.gui.label;

/**
 * Created by Nik on 20-03-2015
 */
public interface LabelVisitor<T>
{
    public T visit(Label label);
}
