package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.QLNode;
import nl.uva.bromance.ast.operators.Operator;
import nl.uva.bromance.ast.visitors.NodeVisitor;
import org.antlr.v4.runtime.Token;

import java.util.Optional;

public class Expression extends QLNode {
    private Optional<Operator> operator = Optional.empty();
    private Result result;
    private Optional<Expression> leftHandSide = Optional.empty();
    private Optional<Expression> rightHandSide = Optional.empty();

    public Expression(int lineNumber, Optional<Token> operatorToken) {
        super(lineNumber);
        if (operatorToken.isPresent()) {
            for (Operator operatorType : Operator.operatorTypes) {
                if (operatorType.getOperatorString().equals(operatorToken.get().getText())) {
                    operator = Optional.of(operatorType.getNewOperatorOfThisType());
                }
            }
        }
    }

    public Optional<Operator> getOperator() {
        return operator;
    }

    //This is postorder traversal
    @Override
    public void accept(NodeVisitor visitor) {
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
