package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.Calculation;
import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.conditionals.Result;

import java.util.Map;

public class CalculationRetrievalVisitor extends NullQLNodeVisitor {
    private final Map<String, Result> answerMap;

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
