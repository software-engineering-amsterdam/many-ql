package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.*;

public class TypeChecker implements QLNodeVisitorInterface {

    private List<TypeCheckingError> exceptions = new ArrayList<>();
    private SymbolTable symbolTable = new SymbolTable();

    public List<TypeCheckingError> check(QLNode node) {
        node.accept(this);
        return exceptions;
    }

    @Override
    public void visit(QLNode qlNode) {

    }

    @Override
    public void visit(Form form) {

    }

    @Override
    public void visit(Question question) {
        question.typeCheck(symbolTable, exceptions);
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(If _if) {
        _if.typeCheck(symbolTable, exceptions);
    }

    @Override
    public void visit(Calculation calc) {
        calc.typeCheck(symbolTable,exceptions);
    }
}