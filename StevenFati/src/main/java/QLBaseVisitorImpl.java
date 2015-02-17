import org.antlr.v4.runtime.misc.NotNull;

/**
 * Created by Steven Kok on 17/02/2015.
 */
public class QLBaseVisitorImpl extends  QLBaseVisitor{
    @Override
    public Object visitStatement(@NotNull QLParser.StatementContext ctx) {
        visitChildren(ctx);
        return super.visitStatement(ctx);
    }
}
