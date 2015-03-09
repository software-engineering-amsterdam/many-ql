package lang.qls.ast.Statement;

/**
 * Created by bore on 03/03/15.
 */
public interface StatementVisitor<T>
{
    T visit(Section s);
    T visit(Question q);
    T visit(QuestionWithRules q);
    T visit(DefaultStat d);
}

