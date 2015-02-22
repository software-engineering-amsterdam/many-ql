package nl.uva.bromance.AST.Conditionals;

import nl.uva.bromance.AST.Input;
import nl.uva.bromance.AST.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Expression extends Node implements ContainsExpression {
    private static final List<Class<? extends Node>> parentsAllowed = new ArrayList<Class<? extends Node>>(Arrays.asList(Expression.class, IfStatement.class, ElseIfStatement.class, ElseStatement.class, Input.class));
    private String text;
    private Expression expression;

    public Expression(int lineNumber) {
        super(lineNumber, Expression.class);
        this.setAcceptedParents(parentsAllowed);
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

    @Override
    public Expression getExpression() {
        return expression;
    }

    @Override
    public void setExpression(Expression expression) {
        this.expression = expression;
    }
}
