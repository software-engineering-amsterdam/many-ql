package ql.gui.input;

/**
 * Created by Nik on 20-03-2015
 */
public interface InputVisitor<T>
{
    public T visit(BoolInput input);
    public T visit(DecInput input);
    public T visit(IntInput input);
    public T visit(StrInput input);
    public T visit(ExprInput input);
}
