package nl.uva.bromance.AST.Conditionals;

import javafx.scene.layout.Pane;
import nl.uva.bromance.AST.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by Robert on 23-2-2015.
 */
public class ExpressionEvaluator {
    private List<Node> expressionList;

    public ExpressionEvaluator(Node ast) {
        expressionList = buildExpressionList(ast,null);
        evaluateExpressions();
    }

    public void evaluateExpressions(){
        for (Node node : expressionList){
            Expression e = (Expression) node;
            Result r = e.evaluate();
            if (r instanceof  BooleanResult)
                System.out.println("Expression @line" + node.getLineNumber() + " evaluates to :" + ((BooleanResult) r).getResult());
            else if (r instanceof IntResult)
                System.out.println("Expression @line" + node.getLineNumber() + " evaluates to :" + ((IntResult) r).getResult());
        }
    }

    private static List buildExpressionList(Node node, List l){
        if (l == null){
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
}
