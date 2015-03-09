package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Input;
import nl.uva.bromance.ast.Node;
import nl.uva.bromance.ast.exceptions.InvalidOperandException;
import nl.uva.bromance.ast.operators.Operator;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Expression extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Expression.class, IfStatement.class, ElseIfStatement.class, ElseStatement.class, Input.class));
    private String text;
    private Optional<Operator> operator;
    private Optional<Token> id;

    public Expression(int lineNumber, Optional<Token> operatorToken, Optional<Token> id) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
        if (operatorToken.isPresent()) {
            for (Operator operatorType : Operator.operatorTypes) {
                if (operatorType.getOperatorString().equals(operatorToken.get().getText())) {
                    operator = Optional.of(operatorType.getNewOperatorOfThisType());
                }
            }
        }
        this.id = id;
    }

    @Override
    public void printDebug(int i) {
        for (int j = 0; j < i; j++) {
            System.out.print("\t");
        }
        System.out.print("[Expression] " + text + " \n");
        for (Node n : getChildren()) {
            n.printDebug(i + 1);
        }
    }

    public void setText(String t) {
        this.text = t;
    }

    public Result evaluate() {
        if (operator.isPresent()) {
            List<Node> children = getChildren();
            Node one = children.get(0);
            Node two = children.get(1);
            Result resultOne = ((Expression) one).evaluate();
            Result resultTwo = ((Expression) two).evaluate();
            try {
                return operator.get().performOperation(resultOne, resultTwo);
            } catch (InvalidOperandException e) {
                System.err.println("Got invalid operands [" + resultOne.getClass().getSimpleName() + "," + resultTwo.getClass().getSimpleName() + "] for operator type :" + operator.getClass().getSimpleName());
                return new BooleanResult(false);
            }
        } else {
            // Reached end point here, wrap value in result
            if (this.getText() != null) {
                String value = this.getText();
                if (value.matches("[0-9]*")) {
                    // Integer
                    System.out.println("Int:" + value);
                    return new IntResult(Integer.parseInt(value));
                } else if (value.matches("\".+\"")) {
                    // String
                    return new StringResult(value);
                } else {
                    // Identifier
                    // TODO Get value from actual identifier instead of int
                    return new IntResult(1337);
                }
            } else {
                // No text or operator, so one kid who does have something of use for us.
                return ((Expression) getChildren().get(0)).evaluate();
            }
        }
    }

    public Optional<Token> getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Optional<Operator> getOperator() {
        return operator;
    }
}
