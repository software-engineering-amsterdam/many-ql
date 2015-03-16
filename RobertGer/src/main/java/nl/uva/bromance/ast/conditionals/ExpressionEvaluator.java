package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.Identifier;
import nl.uva.bromance.ast.QLNode;

import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluator {


    public static void evaluateExpressions(AST<QLNode> ast) {
        List<Identifier> identifiers = getIdentifiers(ast.getRoot());
        for (ContainsExpression node : findNodesWhichContainExpressions_ForNode(ast.getRoot())) {
            Result r = node.getExpression().evaluate(identifiers);
            node.handleExpressionResult(r);
            if (r instanceof BooleanResult)
                //TODO: move getREsult() to super class;
                System.out.println("Expression @line" + ((QLNode) node).getLineNumber() + " evaluates to :" + ((BooleanResult) r).getResult());
            else if (r instanceof IntResult)
                System.out.println("Expression @line" + ((QLNode) node).getLineNumber() + " evaluates to :" + ((IntResult) r).getResult());
        }
    }

    private static List<ContainsExpression> findNodesWhichContainExpressions_ForNode(QLNode node) {
        List<ContainsExpression> nodesContainingExpression = new ArrayList<>();
        if (node instanceof ContainsExpression) {
            nodesContainingExpression.add((ContainsExpression) node);

        } else {
            if (node.hasChildren()) {
                for (QLNode child : node.getChildren()) {
                    nodesContainingExpression.addAll(findNodesWhichContainExpressions_ForNode(child));
                }
            }
        }
        return nodesContainingExpression;
    }


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
}
