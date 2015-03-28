package nl.uva.bromance.ast.visitors;

import nl.uva.bromance.ast.operators.*;

/**
 * Created by Robert on 28-3-2015.
 */
public interface OperatorVisitor {
    void visit(SmallerThanOperator operator);

    void visit(LargerThanOperator operator);

    void visit(EqualsOperator operator);

    void visit(NotEqualsOperator operator);

    void visit(LargerThanOrEqualsOperator operator);

    void visit(SmallerThanOrEqualsOperator operator);

    void visit(OrOperator operator);

    void visit(AndOperator operator);

    void visit(PlusOperator operator);

    void visit(MinusOperator operator);

    void visit(MultiplyOperator operator);

    void visit(DivideOperator operator);
}
