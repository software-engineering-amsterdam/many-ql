package lang.ql.interpretation;

import lang.ql.ast.AstNode;
import lang.ql.ast.form.*;
import lang.ql.ast.statement.*;
import lang.ql.ast.visitor.VisitorAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bore on 15/02/15.
 */
public class Interpreter extends VisitorAbstract
{
    private List<Question> questions;
    private Form form;

    public Interpreter()
    {
        this.questions = new ArrayList<Question>();
    }

    public void execute(AstNode node)
    {
        this.visitInternal(node);

        this.createForm(this.form, this.questions);
    }

    private void createForm(Form form, List<Question> questions)
    {

    }

    private void visitInternal(AstNode node)
    {
        node.visit(this);

        if (node.getChildren() != null)
        {
            for (AstNode child : node.getChildren())
            {
                this.visitInternal(child);
            }
        }
    }

    @Override
    public void visit(Form n)
    {
        this.form = n;
    }

    @Override
    public void visit(Question n)
    {
        this.questions.add(n);
    }

    @Override
    public void visit(CalculatedQuestion n)
    {
        this.questions.add(n);
    }
}
