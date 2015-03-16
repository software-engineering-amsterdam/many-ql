package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.conditionals.ElseIfStatement;
import nl.uva.bromance.ast.conditionals.ElseStatement;
import nl.uva.bromance.ast.conditionals.Expression;
import nl.uva.bromance.ast.conditionals.IfStatement;

/**
 * Created by Robert on 16-3-2015.
 */
public class NullNodeVisitor implements NodeVisitor {
    @Override
    public void visit(Calculation calculation) {

    }

    @Override
    public void visit(Form form) {

    }

    @Override
    public void visit(Input input) {

    }

    @Override
    public void visit(Label label) {

    }

    @Override
    public void visit(LabelText labelText) {

    }

    @Override
    public void visit(Question question) {

    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(IfStatement ifStatement) {

    }

    @Override
    public void visit(ElseIfStatement elseIfStatement) {

    }

    @Override
    public void visit(ElseStatement elseStatement) {

    }

    @Override
    public void visit(Expression expression) {

    }
}
