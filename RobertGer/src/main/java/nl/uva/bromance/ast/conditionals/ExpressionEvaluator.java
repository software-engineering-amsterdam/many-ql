package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Identifier;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;
import nl.uva.bromance.ast.operators.Operator;
import nl.uva.bromance.ast.visitors.NullNodeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExpressionEvaluator extends NullNodeVisitor {

    private List<Identifier> identifiers;
    private Map<String, Result> answerMap;
    private Expression currentExpression;
    private Result currentResult;

    public ExpressionEvaluator(Map<String, Result> answerMap) {
        this.answerMap = answerMap;
    }

    //TODO: We should insert the indentifiers not find them in this class.
    public void evaluate(QLNode qlnode) {
        this.identifiers = getIdentifiers(qlnode);
        qlnode.accept(this);
    }

    @Override
    public void visit(Expression expression) {
        expression.setResult(currentResult);
        if (expression.getOperator().isPresent()) {
            processOperatorExpression(expression, expression.getOperator().get());
        }
    }

    //TODO: Do something about this. Maybe something more top-level.
    private static List<Identifier> getIdentifiers(QLNode node) {
        List<Identifier> identifiers = new ArrayList<>();
        if (node instanceof HasIdentifier) {
            identifiers.add(((HasIdentifier) node).getIdentifier());
        }
        if (node.hasChildren()) {
            for (QLNode child : node.getChildren()) {
                identifiers.addAll(getIdentifiers(child));

            }
        }
        return identifiers;
    }

    @Override
    public void visit(Terminal terminal) {
        if (terminal.isInteger()) {
            currentResult = new IntResult(Integer.parseInt(terminal.getValue()));
        } else if (terminal.isString()) {
            currentResult = new StringResult(terminal.getValue());
        } else {
            for (Identifier identifier : identifiers) {
                //TODO: What if there is an identifier with the same id?
                if (terminal.getValue().equals(identifier.getId())) {
                    if (answerMap != null && answerMap.get(terminal.getValue()) != null) {
                        currentResult = answerMap.get(terminal.getValue());
                    } else {
                        currentResult = identifier.getResult();
                    }
                    break;
                }
            }
        }
    }


    private void processOperatorExpression(Expression expression, Operator operator) {
        Result resultOne = expression.getLeftHandSideResult();
        Result resultTwo = expression.getRightHandSideResult();
        try {
            expression.setResult(operator.performOperation(resultOne, resultTwo));
            //TODO: This should be done in TypeChecking. Don't want to run into operandExpressions when running the program.
        } catch (InvalidOperandException e) {
            System.err.println("Got invalid operands [" + resultOne.getClass().getSimpleName() + "," + resultTwo.getClass().getSimpleName() + "] for operator type :" + operator.getClass().getSimpleName());
            expression.setResult(new BooleanResult(false));
        }
    }
}
