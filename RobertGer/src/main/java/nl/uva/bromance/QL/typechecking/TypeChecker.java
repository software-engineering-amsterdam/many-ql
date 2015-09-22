package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.*;

public class TypeChecker implements QLNodeVisitorInterface {

    private List<Exception> exceptions =  new ArrayList<>();
    private SymbolTable symbolTable = new SymbolTable();

    public List<Exception> check(QLNode node) {
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
        try {
            question.typeCheck(symbolTable);
        } catch (TypeCheckingError typeCheckingError) {
            exceptions.add(typeCheckingError);
        }
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

}