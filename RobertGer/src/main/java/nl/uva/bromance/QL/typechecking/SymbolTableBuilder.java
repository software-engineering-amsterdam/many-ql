package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.expressions.unary.Variable;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.List;

public class SymbolTableBuilder implements QLNodeVisitorInterface {

    private SymbolTable symbolTable = new SymbolTable();
    private List<TypeCheckingError> exceptions;

    public SymbolTable build(QLNode node, List<TypeCheckingError> exceptions) {
        this.exceptions = exceptions;
        node.accept(this);
        return symbolTable;
    }

    @Override
    public void visit(QLNode qlNode) {

    }

    @Override
    public void visit(Form form) {

    }

    @Override
    public void visit(Question question) {
        question.addToSymbolTable(symbolTable, exceptions);
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(If _if) {

    }

    @Override
    public void visit(Calculation calc) {
        calc.addToSymbolTable(symbolTable, exceptions);
    }

    @Override
    public void visit(Variable var) {

    }

    @Override
    public void visit() {

    }

    @Override
    public void exit(If _f) {

    }
}
