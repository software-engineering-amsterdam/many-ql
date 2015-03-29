package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.Calculation;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.conditionals.Result;

import java.util.Map;

/**
 * Created by Robert on 16-3-2015.
 */
public class CalculationRetrievalVisitor extends NullQLNodeVisitor {
    private Map<String, Result> answerMap;

    public CalculationRetrievalVisitor(Map<String, Result> answerMap) {
        this.answerMap = answerMap;
    }

    public void handle(QLNode qlNode) {
        qlNode.accept(this);
    }

    @Override
    public void visit(Calculation calculation) {
        calculation.handleExpressionResult();
        answerMap.put(calculation.getIdentifier(), calculation.getResult());
    }
}
