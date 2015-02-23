package lang.ql.ast.type;

/**
 * Created by Nik on 23-2-15.
 */
public interface TypeVisitor
{
    public void visit(BoolType type);
    public void visit(DateType type);
    public void visit(DecType type);
    public void visit(IntType type);
    public void visit(StrType type);
}
