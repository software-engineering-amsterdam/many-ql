package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.operators.Operator;
import nl.uva.bromance.ast.visitors.NullQLNodeVisitor;

import java.util.Map;

public class ExpressionEvaluator extends NullQLNodeVisitor {

    private Map<String, Result> answerMap;
    private Result currentResult;

    public ExpressionEvaluator(Map<String, Result> answerMap) {
        this.answerMap = answerMap;
    }

    //TODO: We should insert the indentifiers not find them in this class.
    public void evaluate(QLNode qlnode) {
        qlnode.accept(this);
    }

    @Override
    public void visit(Expression expression) {
        expression.setResult(currentResult);
        if (expression.getOperator().isPresent()) {
            processOperatorExpression(expression, expression.getOperator().get());
        }
    }

    @Override
    public void visit(Terminal terminal) {
        if (terminal.isIdentifier()) {
            for (String identifier : answerMap.keySet()) {
                if (terminal.getValue().equals(identifier)) {
                    if (answerMap != null && answerMap.get(identifier) != null) {
                        currentResult = answerMap.get(identifier);
                    } else {
                        currentResult = answerMap.get(identifier);
                    }
                    break;
                }
            }
        } else {
            currentResult = terminal.getResult();
        }
    }


    private void processOperatorExpression(Expression expression, Operator operator) {
        Result resultOne = expression.getLeftHandSideResult();
        Result resultTwo = expression.getRightHandSideResult();
        expression.setResult(operator.performOperation(resultOne, resultTwo));
    }
}
