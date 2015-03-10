package nl.uva.bromance.ast.conditionals;

import nl.uva.bromance.ast.Identifier;
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
    private Optional<Terminal> terminal = Optional.empty();

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

    public Result evaluate(List<Identifier> identifiers) {
        if (operator.isPresent()) {
            return processOperatorExpression(identifiers);
        } else {
            return processTerminal(identifiers);

        }
    }

    private Result processTerminal(List<Identifier> identifiers) {

        Result result = null;
        if (terminal.isPresent()) {
            Terminal terminal = this.terminal.get();
            if (terminal.isInteger()) {
                result = new IntResult(Integer.parseInt(terminal.getValue()));
            } else if (terminal.isString()) {
                result = new StringResult(terminal.getValue());
            } else {
                for (Identifier identifier : identifiers) {
                    //TODO: What if there is an identifier with the same id?
                    if (terminal.getValue().equals(identifier.getId())) {
                        result = identifier.getResult();
                        break;
                    }
                }
            }
        } else {

            //TODO: Why is this necessary?
            // No text or operator, so one kid who does have something of use for us.
            result = ((Expression) getChildren().get(0)).evaluate(identifiers);
        }

        return result;
    }


    private Result processOperatorExpression(List<Identifier> identifiers) {
        Result resultOne = getLeftHandSide().evaluate(identifiers);
        Result resultTwo = getRightHandSide().evaluate(identifiers);
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
