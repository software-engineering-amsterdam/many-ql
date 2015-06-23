package ql.ast.type;

/**
 * Created by Nik on 23-2-15.
 */
public interface TypeVisitor<T>
{
    public T visit(BoolType type);
    public T visit(DecType type);
    public T visit(IntType type);
    public T visit(StrType type);
    public T visit(UndefType type);
}
