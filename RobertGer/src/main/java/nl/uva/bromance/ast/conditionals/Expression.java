package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.operators.*;
import nl.uva.bromance.ast.visitors.QLNodeVisitor;
import org.antlr.v4.runtime.Token;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Expression extends QLNode {

    public List<Operator> operatorTypes = Arrays.asList(new AndOperator(), new OrOperator(), new DivideOperator(), new MultiplyOperator(), new EqualsOperator(), new NotEqualsOperator(), new LargerThanOrEqualsOperator(), new LargerThanOperator(), new MinusOperator(), new PlusOperator(), new SmallerThanOrEqualsOperator(), new SmallerThanOperator());

    private Optional<Operator> operator = Optional.empty();
    private Result result;
    private Optional<Expression> leftHandSide = Optional.empty();
    private Optional<Expression> rightHandSide = Optional.empty();

    public Expression(int lineNumber, Optional<Token> operatorToken) {
        super(lineNumber);
        if (operatorToken.isPresent()) {
            for (Operator operatorType : operatorTypes) {
                if (operatorType.getOperatorString().equals(operatorToken.get().getText())) {
                    operator = Optional.of(operatorType);
                }
            }
        }
    }

    public Optional<Operator> getOperator() {
        return operator;
    }

    //This is postorder traversal
    @Override
    public void accept(QLNodeVisitor visitor) {
        for (QLNode child : this.getChildren()) {
            child.accept(visitor);
        }
        visitor.visit(this);
    }

    public Optional<Expression> getLeftHandSide() {
        return leftHandSide;
    }

    public void setLeftHandSide(Optional<Expression> leftHandSide) {
        this.leftHandSide = leftHandSide;
    }

    public void setRightHandSide(Optional<Expression> rightHandSide) {
        this.rightHandSide = rightHandSide;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return this.result;
    }

    public Result getLeftHandSideResult() {
        if (leftHandSide.isPresent()) {
            return leftHandSide.get().getResult();
        } else {
            return null;
        }
    }

    public Result getRightHandSideResult() {
        if (rightHandSide.isPresent()) {
            return rightHandSide.get().getResult();
        } else {
            return null;
        }
    }
}
