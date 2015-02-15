package lang.ql.ast.visitor;

import lang.ql.ast.expression.Expression;
import lang.ql.ast.form.Form;
import lang.ql.ast.statement.IfCondition;
import lang.ql.ast.statement.Question;

/**
 * Created by bore on 13/02/15.
 */
public interface Visitor
{
    void visit(Form n);
    void visit(Question n);
    void visit(IfCondition n);
    void visit(Expression n);
    // TODO:
}
