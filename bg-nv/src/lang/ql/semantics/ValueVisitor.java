package lang.ql.semantics;

import lang.ql.semantics.values.*;

/**
 * Created by Nik on 22-02-2015
 */
public interface ValueVisitor
{
    public void visit(BooleanValue val);
    public void visit(DateValue val);
    public void visit(DecimalValue val);
    public void visit(IntegerValue val);
    public void visit(StringValue val);

}
