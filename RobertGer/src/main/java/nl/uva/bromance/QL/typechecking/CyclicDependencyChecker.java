package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.AST;
import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.typechecking.exceptions.TypeCheckingError;

import java.util.ArrayList;
import java.util.List;

public class CyclicDependencyChecker implements QLNodeVisitorInterface{


    private final QLNode node;
    private List<TypeCheckingError> exceptions = new ArrayList<>();

    public  CyclicDependencyChecker(QLNode node){
        this.node = node;
    }

    public List<TypeCheckingError> check(SymbolTable s){
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
        //question.checkDependencies(symbolTable);
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    @Override
    public void visit(If _if) {

    }

    @Override
    public void visit(Calculation calc) {

    }
}