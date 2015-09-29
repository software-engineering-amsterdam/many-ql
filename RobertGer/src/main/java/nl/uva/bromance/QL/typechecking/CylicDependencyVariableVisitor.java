package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.expressions.unary.Variable;
import java.util.ArrayList;
import java.util.List;

public class CylicDependencyVariableVisitor implements QLNodeVisitorInterface
{
    private List<String> identifierList;

    public CylicDependencyVariableVisitor()
    {
        identifierList = new ArrayList<>();
    }

    public List<String> getIdentifierList()
    {
        return identifierList;
    }

    @Override
    public void visit(QLNode qlNode)
    {
    }

    @Override
    public void visit(Form form)
    {
    }

    @Override
    public void visit(Question question)
    {
    }

    @Override
    public void visit(Questionnaire questionnaire)
    {
    }

    @Override
    public void visit(If _if)
    {
    }

    @Override
    public void visit(Calculation calc)
    {
    }

    @Override
    public void visit(Variable var)
    {
        identifierList.add(var.getIdentifier());
    }

    @Override
    public void visit()
    {
    }

    @Override
    public void exit(If _f)
    {
    }
}
