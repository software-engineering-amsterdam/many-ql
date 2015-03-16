package ql.semantics;

import ql.ast.expression.*;
import ql.ast.form.Form;
import ql.ast.form.FormVisitor;
import ql.ast.statement.*;

/**
 * Created by bore on 16/03/15.
 */
public class QuestionDependenciesBuilder extends DefaultExprVisitor<Void> implements FormVisitor<Void>, StatVisitor<Void>
{
    private final QuestionDependencies dependencies;
    private Question currentQuestion;

    public static QuestionDependencies build(Form f)
    {
        QuestionDependenciesBuilder builder = new QuestionDependenciesBuilder();
        f.accept(builder);
        return builder.dependencies;
    }

    private QuestionDependenciesBuilder()
    {
        this.dependencies = new QuestionDependencies();
    }

    @Override
    public Void visit(Form f)
    {
        for (Statement statement : f.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(IfCondition c)
    {
        for (Statement statement : c.getBody())
        {
            statement.accept(this);
        }

        return null;
    }

    @Override
    public Void visit(Question q)
    {
        this.dependencies.addQuestion(q.getId());
        return null;
    }

    @Override
    public Void visit(CalculatedQuestion q)
    {
        this.dependencies.addQuestion(q.getId());

        this.setScopeForExpr(q);
        q.getCalculation().accept(this);
        this.resetScopeForExpr();

        return null;
    }

    @Override
    public Void visitDefault(Expr e)
    {
        return null;
    }

    @Override
    public Void visitBinary(BinaryExpr e)
    {
        e.getLeft().accept(this);
        e.getRight().accept(this);
        return null;
    }

    @Override
    public Void visitUnary(UnaryExpr e)
    {
        e.getOperand().accept(this);
        return null;
    }

    @Override
    public Void visit(Ident n)
    {
        if (this.isScopeSet())
        {
            this.dependencies.addDependency(this.currentQuestion.getId(), n.getId());
        }

        return null;
    }

    private void setScopeForExpr(CalculatedQuestion q)
    {
        this.currentQuestion = q;
    }

    private void resetScopeForExpr()
    {
        this.currentQuestion = null;
    }

    private boolean isScopeSet()
    {
        return this.currentQuestion != null;
    }
}
