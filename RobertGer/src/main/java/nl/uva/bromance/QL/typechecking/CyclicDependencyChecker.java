package nl.uva.bromance.QL.typechecking;

import nl.uva.bromance.QL.ast.QLNode;
import nl.uva.bromance.QL.ast.QLNodeVisitorInterface;
import nl.uva.bromance.QL.ast.nodes.Calculation;
import nl.uva.bromance.QL.ast.nodes.Form;
import nl.uva.bromance.QL.ast.nodes.Question;
import nl.uva.bromance.QL.ast.nodes.Questionnaire;
import nl.uva.bromance.QL.controlstructures.If;
import nl.uva.bromance.QL.expressions.unary.Variable;
import nl.uva.bromance.QL.exceptions.TypeCheckingError;

import java.util.ArrayList;
import java.util.List;

public class CyclicDependencyChecker implements QLNodeVisitorInterface{

    private final QLNode node;
    private List<TypeCheckingError> exceptions = new ArrayList<>();
    private List<VariableList> variableLookupList = new ArrayList<>();

    public CyclicDependencyChecker(QLNode node){
        this.node = node;
    }

    public List<TypeCheckingError> check(){
        node.accept(this);
        return exceptions;
    }

    private class VariableList {

        private List<String> vars;
        private int lineNumber;

        public VariableList(List<String> vars, int lineNumber){
            this.vars = vars;
            this.lineNumber = lineNumber;
        }

        public List<String> getVars(){
            return vars;
        }

        public int getLineNumber(){
            return lineNumber;
        }
    }

    @Override
    public void visit(QLNode qlNode) {

    }

    @Override
    public void visit(Form form) {

    }

    @Override
    public void visit(Question question) {
        for (VariableList varList : variableLookupList){
            for (String var : varList.getVars()){
                if (var.equals(question.getIdentifier()))
                    exceptions.add(new TypeCheckingError("Question at line "+question.getLineNumber()+" depends on itself at line "+varList.getLineNumber(), TypeCheckingError.Type.ERROR));
            }
        }
    }

    @Override
    public void visit(Questionnaire questionnaire) {

    }

    // All we need to check for is if a question has its answer defined within the if statement
    @Override
    public void visit(If _if) {
        CylicDependencyVariableVisitor cdvv = new CylicDependencyVariableVisitor();
        _if.visitExpression(cdvv);
        variableLookupList.add(new VariableList(cdvv.getIdentifierList(), _if.getLineNumber()));
    }

    @Override
    public void visit(Calculation calc) {
        for (VariableList varList : variableLookupList){
            for (String var : varList.getVars()){
                if (var.equals(calc.getIdentifier()))
                    exceptions.add(new TypeCheckingError("Calculation at line "+calc.getLineNumber()+" depends on itself at line "+varList.getLineNumber(), TypeCheckingError.Type.ERROR));
            }
        }
    }

    @Override
    public void visit(Variable var) {

    }

    @Override
    public void visit() {

    }

    // Remove the last of list of variables we're looking for
    @Override
    public void exit(If _f) {
        variableLookupList.remove(variableLookupList.size() - 1);
    }

}