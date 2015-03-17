package ql.gui.control;

/**
 * Created by Nik on 17-3-15.
 */
public interface ControlVisitor<T>
{
    public T visit(CheckBox control);
    public T visit(Dropdown control);
    public T visit(Radio control);
    public T visit(Slider control);
    public T visit(Spinbox control);
    public T visit(TextField control);
}
