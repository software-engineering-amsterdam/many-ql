package nl.uva.bromance.AST.Conditionals;

import javafx.util.Pair;
import nl.uva.bromance.AST.Exceptions.InvalidOperandException;
import nl.uva.bromance.AST.Input;
import nl.uva.bromance.AST.Node;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Expression extends Node {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Expression.class, IfStatement.class, ElseIfStatement.class, ElseStatement.class, Input.class));
    private String text;
    private Operator operator;
    private Optional<Token> id;
    //TODO: Consider using children instead of this pair.
    private Optional<Pair<Expression, Expression>> expressionPair = Optional.empty();

    public Expression(int lineNumber, Optional<Token> operator, Optional<Token> id) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
        if (operator.isPresent()){
            switch (operator.get().getText()) {
                case "+":
                    this.operator = new PlusOperator();
                    break;
                case "-":
                    this.operator = new MinusOperator();
                    break;
                case "*":
                    this.operator = new MultiplyOperator();
                    break;
                case "/":
                    this.operator = new DivideOperator();
                    break;
                case ">":
                    this.operator = new LargerThanOperator();
                    break;
                case "<":
                    this.operator = new SmallerThanOperator();
                    break;
                case "==":
                    this.operator = new EqualsOperator();
                    break;
                case "!=":
                    this.operator = new NotEqualsOperator();
                    break;
                case ">=":
                    this.operator = new LargerThanEqualsOperator();
                    break;
                case "<=":
                    this.operator = new SmallerThanEqualsOperator();
                    break;
                case "||":
                    this.operator = new OrOperator();
                    break;
                case "&&":
                    this.operator = new AndOperator();
                    break;
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
        if (operator != null) {
            List<Node> children = getChildren();
            Node one = children.get(0);
            Node two = children.get(1);
            Result resultOne = ((Expression) one).evaluate();
            Result resultTwo = ((Expression) two).evaluate();
            try {
                 return operator.performOperation(resultOne, resultTwo);
            } catch (InvalidOperandException e){
                System.err.println("Got invalid operands ["+resultOne.getClass().getSimpleName()+","+resultTwo.getClass().getSimpleName()+"] for operator type :"+operator.getClass().getSimpleName());
                return new BooleanResult(false);
            }
        } else {
            // Reached end point here, wrap value in result
            if (this.getText() != null) {
                String value = this.getText();
                if (value.matches("[0-9]*")) {
                    // Integer
                    System.out.println("Int:"+value);
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
}
