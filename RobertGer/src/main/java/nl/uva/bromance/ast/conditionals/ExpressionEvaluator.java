package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.AST;
import nl.uva.bromance.ast.Identifier;
import nl.uva.bromance.ast.Node;

import java.util.ArrayList;
import java.util.List;

public class ExpressionEvaluator {
    private List<Node> expressionList;

    public ExpressionEvaluator(AST ast) {
        expressionList = buildExpressionList(ast.getRoot(), null);
        evaluateExpressions(getIdentifiers(ast.getRoot()));
    }

    public void evaluateExpressions(List<Identifier> identifiers) {
        for (Node node : expressionList) {
            Expression e = (Expression) node;
            Result r = e.evaluate(identifiers);
            if (r instanceof BooleanResult)
                System.out.println("Expression @line" + node.getLineNumber() + " evaluates to :" + ((BooleanResult) r).getResult());
            else if (r instanceof IntResult)
                System.out.println("Expression @line" + node.getLineNumber() + " evaluates to :" + ((IntResult) r).getResult());
        }
    }

    private static List buildExpressionList(Node node, List l) {
        if (l == null) {
            l = new ArrayList<Node>();
        }
        if (node instanceof Expression) {
            l.add(node);
        } else if (node.hasChildren()) {
            for (Node child : node.getChildren()) {
                buildExpressionList(child, l);
            }
        }
        return l;
    }

    public List<Identifier> getIdentifiers(Node node) {
        List<Identifier> identifiers = new ArrayList<>();
        for (Node child : node.getChildren()) {
            if (child instanceof HasIdentifier) {
                identifiers.add(((HasIdentifier) child).getIdentifier().get());
            }
        }
        return identifiers;
    }
}
