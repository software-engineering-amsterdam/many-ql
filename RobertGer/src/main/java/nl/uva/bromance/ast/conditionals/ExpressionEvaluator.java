package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.*;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;
import nl.uva.bromance.ast.operators.Operator;
import nl.uva.bromance.ast.visitors.NullNodeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressionEvaluator extends NullNodeVisitor{

    private List<Identifier> identifiers;
    private Map<String,Result> answerMap;

    public ExpressionEvaluator(Map<String,Result> answerMap) {
        this.answerMap = answerMap;
    }
    //TODO: We should insert the indentifiers not find them in this class.
    public void evaluate(QLNode qlnode){
    this.identifiers = getIdentifiers(qlnode);
    qlnode.accept(this);}

    @Override
    public void visit(Expression expression) {
        if (expression.getOperator().isPresent()) {
            processOperatorExpression(expression, expression.getOperator().get());
        } else {
            processTerminal(expression);
        }
    }

    //TODO: Do something about this. Maybe something more top-level.
    private static List<Identifier> getIdentifiers(QLNode node) {
        List<Identifier> identifiers = new ArrayList<>();
        if (node instanceof HasIdentifier) {
            identifiers.add(((HasIdentifier) node).getIdentifier().get());
        }
        if (node.hasChildren()) {
            for (QLNode child : node.getChildren()) {
                identifiers.addAll(getIdentifiers(child));

            }
        }
        return identifiers;
    }

    private void processTerminal(Expression expression) {
        if (expression.getTerminal().isPresent()) {
            Terminal terminal = expression.getTerminal().get();
            if (terminal.isInteger()) {
                expression.setResult(new IntResult(Integer.parseInt(terminal.getValue())));
            } else if (terminal.isString()) {
                expression.setResult(new StringResult(terminal.getValue()));
            } else {
                for (Identifier identifier : identifiers) {
                    //TODO: What if there is an identifier with the same id?
                    if (terminal.getValue().equals(identifier.getId())) {
                        if (answerMap != null && answerMap.get(terminal.getValue()) != null){
                            expression.setResult(answerMap.get(terminal.getValue()));
                        } else {
                            expression.setResult(identifier.getResult());
                        }
                        break;
                    }
                }
            }
        } else {
            expression.setResult(null);
        }
    }


    private void processOperatorExpression(Expression expression, Operator operator) {
        Result resultOne = expression.getLeftHandSideResult();
        Result resultTwo = expression.getRightHandSideResult();
        try {
            expression.setResult(operator.performOperation(resultOne, resultTwo));
            System.out.println("Expression result :"+expression.getResult().toString());
            //TODO: This should be done in TypeChecking. Don't want to run into operandExpressions when running the program.
        } catch (InvalidOperandException e) {
            System.err.println("Got invalid operands [" + resultOne.getClass().getSimpleName() + "," + resultTwo.getClass().getSimpleName() + "] for operator type :" + operator.getClass().getSimpleName());
            expression.setResult(new BooleanResult(false));
        }
    }
}
