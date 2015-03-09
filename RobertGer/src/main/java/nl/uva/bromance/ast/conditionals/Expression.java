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
    private Optional<Operator> operator = Optional.empty();
    private Optional<Terminal> terminal;

    public Expression(int lineNumber, Optional<Token> operatorToken) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
        if (operatorToken.isPresent()) {
            for (Operator operatorType : Operator.operatorTypes) {
                if (operatorType.getOperatorString().equals(operatorToken.get().getText())) {
                    operator = Optional.of(operatorType.getNewOperatorOfThisType());
                }
            }
        }
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
            return processOperatorExpression();
        } else {
            return processTerminal();

        }
    }

    private Result processTerminal() {
        if (terminal.isPresent()) {
            Terminal terminal = this.terminal.get();
            if (terminal.isInteger()) {
                return new IntResult(Integer.parseInt(terminal.getValue()));
            } else if (terminal.isString()) {
                return new StringResult(terminal.getValue());
            } else {
                // TODO Get value from actual identifier instead of int
                return new IntResult(1337);
            }
        } else {
            // No text or operator, so one kid who does have something of use for us.
            return ((Expression) getChildren().get(0)).evaluate();
        }
    }


    private Result processOperatorExpression() {
        Result resultOne = getLeftHandSide().evaluate();
        Result resultTwo = getRightHandSide().evaluate();
        try {
            return operator.get().performOperation(resultOne, resultTwo);

            //TODO: This should be done in TypeChecking. Don't want to run into operandExpressions when running the program.
        } catch (InvalidOperandException e) {
            System.err.println("Got invalid operands [" + resultOne.getClass().getSimpleName() + "," + resultTwo.getClass().getSimpleName() + "] for operator type :" + operator.getClass().getSimpleName());
            return new BooleanResult(false);
        }
    }

    public Optional<Terminal> getTerminal() {
        return terminal;
    }

    public Optional<Operator> getOperator() {
        return operator;
    }

    private Expression getLeftHandSide() {
        return (Expression) getChildren().get(0);
    }

    private Expression getRightHandSide() {
        return (Expression) getChildren().get(1);
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = Optional.of(terminal);
    }
}
