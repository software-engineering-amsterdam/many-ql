package nl.uva.bromance.AST.Conditionals;

import javafx.util.Pair;
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
    private Optional<Token> operator;
    private Optional<Token> id;
    //TODO: Consider using children instead of this pair.
    private Optional<Pair<Expression, Expression>> expressionPair = Optional.empty();

    public Expression(int lineNumber, Optional<Token> operator, Optional<Token> id) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
        this.operator = operator;
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


    //TODO: Implement this.
    public void evaluate() {
        if (hasChildren()) {
            Node node = getChildren().get(0);
            Node node1 = getChildren().get(0);
            if (node != null && node1 != null) {
                if (node instanceof Expression && node1 instanceof Expression) {
                    Optional<Token> id1 = ((Expression) node).getId();
                    Optional<Token> id2 = ((Expression) node1).getId();
                    if (id1.isPresent() && id2.isPresent()) {
                        if (id1.get().getType() != id2.get().getType()) {
                            System.err.println("Expression Error @" + getLineNumber() + "cannot compare different types.");
                        } else {
                            System.err.println("Found id's of same type @" + getLineNumber());
                        }
                    }
                }
            }
        }
    }

    public Optional<Token> getId() {
        return id;
    }
}
