package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.Else;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.controlstructures.IfSequence;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;
import nl.uva.bromance.QL.expressions.unary.Variable;
import java.util.*;

public class TypeCheckerVisitor implements QLNodeVisitorInterface {

    private List<TypeCheckingError> exceptions = new ArrayList<>();
    private SymbolTable symbolTable = new SymbolTable();
    private Set<String> duplicateQuestionlabels = new HashSet<>();

    public List<TypeCheckingError> check(QLNode node)
    {
        symbolTable = new SymbolTableBuilderVisitor().build(node,exceptions);
        exceptions.addAll(new CyclicDependencyVisitor(node).check());
        node.accept(this);
        return exceptions;
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
        question.checkForDuplicateLabels(duplicateQuestionlabels, exceptions);
    }

    @Override
    public void visit(Questionnaire questionnaire)
    {
    }

    @Override
    public void visit(If _if)
    {
        _if.typeCheck(symbolTable, exceptions);
    }

    @Override
    public void visit(Calculation calc)
    {
    }

    @Override
    public void visit(Variable var)
    {
    }

    @Override
    public void visit()
    {
    }

    @Override
    public void exit(If _f)
    {
    }

    @Override
    public void visit(Else _else) {

    }

    @Override
    public void visit(IfSequence sequence) {

    }

    @Override
    public void exit(IfSequence sequence) {

    }
}